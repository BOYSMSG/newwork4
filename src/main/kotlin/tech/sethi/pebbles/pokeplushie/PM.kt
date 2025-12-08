package tech.sethi.pebbles.pokeplushie

import net.minecraft.item.ItemStack
import net.minecraft.nbt.NbtList
import net.minecraft.nbt.NbtString
import net.minecraft.text.Text

object PM {
    fun returnStyledText(text: String): Text {
        val formattedText = text
            .replace("<red>", "§c")
            .replace("</red>", "§r")
            .replace("<aqua>", "§b")
            .replace("</aqua>", "§r")
            .replace("<green>", "§a")
            .replace("</green>", "§r")
            .replace("<yellow>", "§e")
            .replace("</yellow>", "§r")
            .replace("<blue>", "§9")
            .replace("</blue>", "§r")
            .replace("<white>", "§f")
            .replace("</white>", "§r")
            .replace("<gray>", "§7")
            .replace("</gray>", "§r")
        
        return Text.literal(formattedText.replace(Regex("<[^>]+>"), ""))
    }

    fun returnStyledJson(text: String): String {
        val color = when {
            text.contains("<red>") -> "red"
            text.contains("<aqua>") -> "aqua"
            text.contains("<green>") -> "green"
            text.contains("<yellow>") -> "yellow"
            text.contains("<blue>") -> "blue"
            text.contains("<gray>") -> "gray"
            else -> "white"
        }
        
        val cleanText = text.replace(Regex("<[^>]+>"), "")
        return """{"text":"$cleanText","color":"$color","italic":false}"""
    }

    fun setLore(itemStack: ItemStack, lore: List<String>) {
        val itemNbt = itemStack.getOrCreateSubNbt("display")
        val loreNbt = NbtList()

        for (line in lore) {
            loreNbt.add(NbtString.of(returnStyledJson(line)))
        }

        itemNbt.put("Lore", loreNbt)
    }
}