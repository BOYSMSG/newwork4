plugins {
    id("dev.architectury.loom")
    id("architectury-plugin")
}

architectury {
    // Only Fabric module is generated. No Forge at all.
    common("fabric")
}

loom {
    silentMojangMappingsLicense()
}

dependencies {

    // Minecraft + Mappings
    minecraft("com.mojang:minecraft:${property("minecraft_version")}")
    mappings("net.fabricmc:yarn:${property("yarn_mappings")}:v2")

    // Architectury API (common logic)
    implementation("dev.architectury:architectury:${property("architectury_version")}") {
        isTransitive = false
    }

    // Adventure (MiniMessage)
    implementation("net.kyori:adventure-text-minimessage:${property("minimessage_version")}")
    implementation("net.kyori:adventure-text-serializer-gson:${property("minimessage_version")}")

    // Optional legacy formatting if you need it
    implementation("net.kyori:adventure-text-serializer-legacy:${property("minimessage_version")}")

    // Cobblemon (common-side logic only)
    // NOTE: Use implementation, NOT modImplementation
    implementation("com.cobblemon:mod:${property("cobblemon_version")}") {
        isTransitive = false
    }

    // Economy internal lib (common code)
    implementation(files("libs/pebbles-economy-1.0.0.jar"))
}
