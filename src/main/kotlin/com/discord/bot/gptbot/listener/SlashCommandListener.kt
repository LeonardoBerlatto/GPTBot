package com.discord.bot.gptbot.listener

import com.discord.bot.gptbot.service.OpenAiService
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import org.springframework.stereotype.Component

@Component
class SlashCommandListener(val openAiService: OpenAiService) : ListenerAdapter() {

    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        when (event.name) {
            "ask" -> askChatGpt(event)
        }
    }

    private fun askChatGpt(event: SlashCommandInteractionEvent) {
        val question = event.getOption("question")?.asString
        openAiService.ask(question).subscribe { answer ->
            event.reply(answer).queue()
        }
    }
}