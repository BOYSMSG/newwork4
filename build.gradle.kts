plugins {
    id("java")
    id("java-library")
    kotlin("jvm") version "2.0.20"

    // Architectury plugin (used only at root)
    id("architectury-plugin") version "3.4-SNAPSHOT"

    // Loom (applied in subprojects, not root)
    id("dev.architectury.loom") version "1.7-SNAPSHOT" apply false
}

architectury {
    // Only Fabric. No Forge.
    platformSetupLoomIde()
}

allprojects {

    apply(plugin = "java")
    apply(plugin = "org.jetbrains.kotlin.jvm")

    version = project.properties["mod_version"]!!
    group = project.properties["maven_group"]!!

    repositories {
        mavenCentral()

        // Cobblemon Maven
        maven("https://maven.impactdev.net/repository/development/")

        // In-project libs
        flatDir {
            dirs("libs")
        }
    }

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(21)) // REQUIRED for MC 1.21+
        }
        withSourcesJar()
    }

    dependencies {
        implementation(kotlin("stdlib"))
    }
}
