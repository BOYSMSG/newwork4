plugins {
    id("dev.architectury.loom") version "1.7-SNAPSHOT"
    id("architectury-plugin") version "3.4-SNAPSHOT"
}

architectury {
    common("fabric")   // No Forge for 1.21.1
}

loom {
    silentMojangMappingsLicense()
}

dependencies {

    // ========== Minecraft + Mappings ==========
    minecraft("com.mojang:minecraft:${property("minecraft_version")}")
    mappings("net.fabricmc:yarn:${property("yarn_mappings")}:v2")

    // ========== Fabric Loader ==========
    modImplementation("net.fabricmc:fabric-loader:${property("fabric_loader_version")}")

    // ========== Kyori Adventure (MiniMessage + Gson) ==========
    implementation("net.kyori:adventure-text-minimessage:${property("minimessage_version")}")
    implementation("net.kyori:adventure-text-serializer-gson:${property("minimessage_version")}")
    implementation("net.kyori:adventure-text-serializer-legacy:${property("minimessage_version")}")

    // ========== Architectury ==========
    modApi("dev.architectury:architectury:${property("architectury_version")}") {
        isTransitive = false
    }

    // ========== Cobblemon 1.7.1 for Minecraft 1.21.1 ==========
    modImplementation("com.cobblemon:mod:1.7.1+1.21.1") {
        isTransitive = false
    }

    // ========== Your economy mod ==========
    modImplementation(files("libs/pebbles-economy-1.0.0.jar"))
}
