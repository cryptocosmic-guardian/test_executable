plugins {
    kotlin("jvm") version "2.2.20"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "org.example"
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
    jvmToolchain(21)
}


tasks.shadowJar {
    mergeServiceFiles() // Importante para evitar conflitos
    manifest {
        attributes["Main-Class"] = "org.example.MainKt" // <-- MUDE ISSO
    }
}