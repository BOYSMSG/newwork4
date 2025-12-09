package tech.sethi.pebbles.pokeplushie

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextDecoration
import net.kyori.adventure.text.minimessage.MiniMessage
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NbtList
import net.minecraft.nbt.NbtString
import net.minecraft.text.Text

object PM {

    // Parse MiniMessage safely
    fun parse(text: String): Component {
        val mm = MiniMessage.miniMessage()
        return mm.deserialize(text).decoration(TextDecoration.ITALIC, false)
    }

    // Convert MiniMessage → Component → Vanilla Text (Safe)
    fun returnStyledText(text: String): Text {
        val component = parse(text)
        val json = GsonComponentSerializer.gson().serialize(component)
        return Text.Serializer.fromJson(json) ?: Text.literal("")
    }

    fun returnStyledJson(text: String): String {
        val component = parse(text)
        return GsonComponentSerializer.gson().serialize(component)
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
