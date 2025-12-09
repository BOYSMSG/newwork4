package tech.sethi.pebbles.pokeplushie

import dev.architectury.event.events.common.CommandRegistrationEvent
import org.apache.logging.log4j.LogManager

object PokePlushie {
    const val MOD_ID = "pokeplushie"
    val LOGGER = LogManager.getLogger()

    @JvmStatic
    fun init() {
        LOGGER.info("Pebble's PokePlushie Initialized!")

        CommandRegistrationEvent.EVENT.register { dispatcher, _, _ ->
            PokePlushiesCommand.register(dispatcher)
        }
    }
}
