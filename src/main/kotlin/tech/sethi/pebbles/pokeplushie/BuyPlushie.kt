package tech.sethi.pebbles.pokeplushie

import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.server.network.ServerPlayerEntity

class BuyPlushie {
    fun buyPlushie(playerEntity: ServerPlayerEntity, slot: Int): Boolean {
        // Create a plushie item (using player head as placeholder)
        val plushie = ItemStack(Items.PLAYER_HEAD)
        
        // Set custom name based on slot
        plushie.setCustomName(PM.returnStyledText("<aqua>Slot $slot Pokémon Plushie</aqua>"))
        
        // Add lore to the item
        val lore = listOf(
            "<yellow>Pokémon from slot $slot</yellow>",
            "<gray>A cute plushie of your Pokémon!</gray>",
            "<green>Right-click to display!</green>"
        )
        PM.setLore(plushie, lore)
        
        // Give the item to the player
        playerEntity.giveItemStack(plushie)
        
        return true
    }
}