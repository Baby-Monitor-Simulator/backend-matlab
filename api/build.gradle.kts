val kotlin_version: String by project
val kord_version: String by project
val ktor_version: String by project
val logback_version: String by project
val jansi_version: String by project

plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    id("io.ktor.plugin")
    sources
}

group = "org.fontys"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("io.github.microutils:kotlin-logging-jvm:3.0.4")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")

    implementation("io.ktor:ktor-server-core-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-netty-jvm:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-content-negotiation-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-auto-head-response-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-sessions:$ktor_version")

    implementation("io.ktor:ktor-server-cors:$ktor_version")

    implementation(project(mapOf("path" to ":data-generation-microservice")))

    testImplementation(kotlin("test"))

    runtimeOnly("ch.qos.logback:logback-classic:$logback_version")
    runtimeOnly("org.fusesource.jansi:jansi:$jansi_version")
}

project.setProperty("mainClassName", "$group.$name.MainKt")

tasks.jar {
    manifest {
        attributes(
            "Main-Class" to "$group.$name.MainKt"
        )
    }
}

tasks.test {
    useJUnitPlatform()
}
