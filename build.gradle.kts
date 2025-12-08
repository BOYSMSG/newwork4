import java.net.URI

plugins {
    kotlin("jvm") version (property("kotlin_version") as String)
    id("fabric-loom") version (property("loom_version") as String)
    id("base")
}

group = property("maven_group") as String
version = property("mod_version") as String

repositories {
    mavenCentral()
    maven("https://maven.fabricmc.net/")
    // Cobblemon placeholder repo - replace if you have a different one
    maven("https://maven.cobblemon.com/")
}

dependencies {
    minecraft("com.mojang:minecraft:${'$'}{property("minecraft_version")}")
    mappings("net.fabricmc:yarn:1.21.1+build.1:v2")
    modImplementation("net.fabricmc:fabric-loader:${'$'}{property("fabric_loader_version")}")
    modImplementation("net.fabricmc.fabric-api:fabric-api:${'$'}{property("fabric_api_version")}")

    // Cobblemon is required at compile time for your code (placeholder)
    modCompileOnly("com.cobblemon:cobblemon:1.7.0") // <-- replace with correct version if needed
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "21"
}

loom {
    accessWidenerPath.set(file("src/main/resources/yourmod.accesswidener"))
}
