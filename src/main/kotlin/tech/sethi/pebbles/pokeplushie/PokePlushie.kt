package tech.sethi.pebbles.pokeplushie

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback
import net.minecraft.server.command.CommandManager
import org.apache.logging.log4j.LogManager

object PokePlushie {
    const val MOD_ID = "pokeplushie"
    val LOGGER = LogManager.getLogger()

    @JvmStatic
    fun init() {
        LOGGER.info("Pebble's PokePlushie Initialized!")
        
        // Register command using Fabric's callback
        CommandRegistrationCallback.EVENT.register { dispatcher, registryAccess, environment ->
            PokePlushiesCommand.register(dispatcher)
        }
    }
}
