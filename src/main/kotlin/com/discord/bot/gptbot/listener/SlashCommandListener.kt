package com.discord.bot.gptbot.listener

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import org.springframework.stereotype.Component

@Component
class SlashCommandListener : ListenerAdapter() {

    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        when (event.name) {
            "ask" -> {
                TODO("convert to call to GPT-3")
                event.reply("Not yet implemented").queue()
            }
        }
    }
}