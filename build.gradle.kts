plugins {
    kotlin("jvm") version "2.1.20"
    application
}
application {
    mainClass = "io.github.ajcode404.MainKt"
}

group = "io.github.ajcode404"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(18)
}