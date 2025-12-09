plugins {
    id("java")
    id("java-library")
    kotlin("jvm") version "2.0.20"

    // Architectury Loom for MC 1.21.1
    id("dev.architectury.loom") version "1.7-SNAPSHOT" apply false

    // Architectury plugin (must match Architectury 13.x)
    id("architectury-plugin") version "3.4-SNAPSHOT" apply false
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

        // In-project JAR libs folder
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
        // Ensure all modules use Kotlin stdlib automatically
        implementation(kotlin("stdlib"))
    }
}
