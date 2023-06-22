val kotlin_version: String  = "1.8.21"
val ktor_version: String = "2.3.0"

plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    implementation(kotlin("gradle-plugin", version = kotlin_version))
    implementation(kotlin("serialization", version = kotlin_version))
    implementation("io.ktor.plugin", "plugin", ktor_version)
    implementation(gradleApi())
    implementation(localGroovy())
}
