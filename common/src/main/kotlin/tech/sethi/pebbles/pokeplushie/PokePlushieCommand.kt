package tech.sethi.pebbles.pokeplushie

import com.mojang.brigadier.CommandDispatcher
import com.mojang.brigadier.arguments.IntegerArgumentType
import net.minecraft.command.CommandSource
import net.minecraft.server.command.CommandManager.argument
import net.minecraft.server.command.CommandManager.literal
import net.minecraft.server.command.ServerCommandSource

object PokePlushiesCommand {

    val slotSuggestions = listOf(1, 2, 3, 4, 5, 6)

    fun register(dispatcher: CommandDispatcher<ServerCommandSource>) {

        val command = literal("pokeplushie")
            .then(
                argument("slotNumber", IntegerArgumentType.integer())
                    .suggests { _, builder ->
                        CommandSource.suggestMatching(
                            slotSuggestions.map { it.toString() },
                            builder
                        )
                    }
                    .executes { ctx ->
                        val player = ctx.source.player!!
                        val slot = IntegerArgumentType.getInteger(ctx, "slotNumber")

                        val result = BuyPlushie().buyPlushie(player, slot)

                        if (result) {
                            ctx.source.sendFeedback(
                                { PM.returnStyledText("<aqua>You got a plushie!</aqua>") },
                                false
                            )
                            1
                        } else {
                            ctx.source.sendFeedback(
                                { PM.returnStyledText("<red>Failed to get a plushie!</red>") },
                                false
                            )
                            0
                        }
                    }
            )

        dispatcher.register(command)
    }
}
