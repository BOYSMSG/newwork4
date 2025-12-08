plugins {
    kotlin("jvm") version "1.9.22"
    id("fabric-loom") version "1.7.4"
    id("maven-publish")
}

group = "tech.sethi.pebbles.pokeplushie"
version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://maven.fabricmc.net/")
    maven("https://repo.kryptonmc.org/releases")
}

dependencies {
    minecraft("com.mojang:minecraft:1.21.1")
    mappings("net.fabricmc:yarn:1.21.1+build.2:v2")
    modImplementation("net.fabricmc:fabric-loader:0.16.7")
    modImplementation("net.fabricmc.fabric-api:fabric-api:0.103.0+1.21.1")
    
<<<<<<< HEAD
=======
    // Adventure API
    include(implementation("net.kyori:adventure-platform-fabric:5.15.0")!!)
    include(implementation("net.kyori:adventure-text-minimessage:4.17.0")!!)
    include(implementation("net.kyori:adventure-text-serializer-gson:4.17.0")!!)
    
    // Kotlin
>>>>>>> 4d38e48b2aadad55ba736f28f3587bff2f451e2f
    implementation(kotlin("stdlib"))
}

kotlin {
    jvmToolchain(21)
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "21"
    }
}

tasks {
    jar {
        from("src/main/resources")
    }
    
    processResources {
        inputs.property("version", project.version)
        filesMatching("fabric.mod.json") {
            expand("version" to project.version)
        }
    }
<<<<<<< HEAD
}
=======
    
    java {
        withSourcesJar()
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(21))
        }
    }
}
>>>>>>> 4d38e48b2aadad55ba736f28f3587bff2f451e2f
