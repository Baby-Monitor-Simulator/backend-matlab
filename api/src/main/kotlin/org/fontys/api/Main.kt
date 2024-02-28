package org.fontys.api

import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.autohead.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.sessions.*
import io.ktor.util.cio.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.fontys.api.json.GraphData
import org.fontys.api.json.Session
import org.fontys.api.json.SettingsPatch
import java.time.Instant
import java.util.*
import kotlin.time.Duration

fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.application() {
    install(AutoHeadResponse)
    install(ContentNegotiation) {
        json(Json)
    }
    install(Sessions) {
        cookie<Session>("session") {
            cookie.maxAge = Duration.INFINITE
        }
    }

    routing {
        route("/api") {
            route("/settings") {
                patch<SettingsPatch> {
                    val session = call.sessions.getOrSet { Session(UUID.randomUUID().toString(), 0, 0, 0, 0, 0) }
                    val new = session.copy(
                        fetalHeartRate = it.fetalHeartRate,
                        fetalBloodPressure = it.fetalBloodPressure,
                        fetalBloodSaturation = it.fetalBloodSaturation,
                        umbilicalArteryBloodFlow = it.umbilicalArteryBloodFlow,
                        uterineContractions = it.uterineContractions
                    )
                    call.sessions.set(new)
                }
            }

            route("/sse") {
                get {
                    // TODO: Use session to generate data specific to each client
                    val session = call.sessions.getOrSet { Session(UUID.randomUUID().toString(), 0, 0, 0, 0, 0) }

                    call.response.cacheControl(CacheControl.NoCache(null))

                    try {
                        withContext(Dispatchers.IO) {
                            call.respondTextWriter(contentType = ContentType.Text.EventStream) {
                                val start = Instant.now().toEpochMilli()
                                var now = start

                                // This loop will error out when the channel closes (client closes the page) so
                                // it is safe to use while true loop here.
                                while (true) {
                                    // Note: Ktor currently doesn't natively support SSE, so this is the way we're working
                                    // around that deficiency for now. Supposedly, it was planned to be added in the next
                                    // release. Once it is, this should probably use whatever native support they add instead.
                                    write(  // TODO: Replace this with Matlab data and not just random values as printed below
                                        "data: " + Json.encodeToString(
                                            GraphData(
                                                now - start,
                                                Random().nextInt(10, 21),
                                                Random().nextInt(35, 56),
                                                Random().nextInt(0, 101),
                                                Random().nextInt(60, 201)
                                            )
                                        ) + "\n\n"
                                    )
                                    flush()

                                    now = Instant.now().toEpochMilli()
                                    delay(250)
                                }
                            }
                        }
                    } catch (ignored: ChannelWriteException) {
                        // User closed the page or otherwise disconnected.
                    }
                }
            }
        }
    }
}
