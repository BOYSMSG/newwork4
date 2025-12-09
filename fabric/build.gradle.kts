plugins {
    id("dev.architectury.loom")
    id("architectury-plugin")
}

architectury {
    platformSetupLoomIde()
    fabric()
}

loom {
    silentMojangMappingsLicense()
    enableTransitiveAccessWideners.set(true)
}

dependencies {

    // Minecraft + Mappings
    minecraft("com.mojang:minecraft:${property("minecraft_version")}")
    mappings("net.fabricmc:yarn:${property("yarn_mappings")}:v2")

    // Fabric loader
    modImplementation("net.fabricmc:fabric-loader:${property("fabric_loader_version")}")

    // Fabric API
    modImplementation("net.fabricmc.fabric-api:fabric-api:${property("fabric_api_version")}")

    // Architectury (Fabric)
    modImplementation("dev.architectury:architectury-fabric:${property("architectury_version")}")

    // Common module shared code
    implementation(project(":common", configuration = "namedElements"))
    "developmentFabric"(project(":common", configuration = "namedElements"))

    // Cobblemon 1.7.1 for 1.21.1
    modImplementation("com.cobblemon:fabric:${property("cobblemon_version")}")

    // MiniMessage (Adventure API)
    implementation("net.kyori:adventure-text-minimessage:${property("minimessage_version")}")
    implementation("net.kyori:adventure-text-serializer-gson:${property("minimessage_version")}")
}

tasks.processResources {
    inputs.property("version", project.version)

    filesMatching("fabric.mod.json") {
        expand(project.properties)
    }
}

tasks.jar {
    archiveBaseName.set("${rootProject.properties["archives_base_name"]}-${project.name}")
    archiveClassifier.set("dev")
}

tasks.remapJar {
    archiveBaseName.set("${rootProject.properties["archives_base_name"]}-${project.name}")
    archiveVersion.set("${rootProject.version}")
}
