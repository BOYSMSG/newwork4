plugins {
    id("fabric-loom") version "1.7-SNAPSHOT"   // Use 1.7+ for MC 1.21.x
    id("maven-publish")
}

repositories {
    mavenCentral()
    maven("https://maven.fabricmc.net/")
}

dependencies {
    // Minecraft
    minecraft("com.mojang:minecraft:${property("minecraft_version")}")
    mappings("net.fabricmc:yarn:${property("yarn_mappings")}:v2")

    // Fabric Loader
    modImplementation("net.fabricmc:fabric-loader:${property("loader_version")}")

    // Fabric API (optional, but usually required)
    modImplementation("net.fabricmc.fabric-api:fabric-api:${property("fabric_api_version")}")
}

loom {
    silentMojangMappingsLicense()
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21)) // MC 1.21.x REQUIRES Java 21
}
