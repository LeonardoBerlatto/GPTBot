package com.discord.bot.gptbot.listener

import com.discord.bot.gptbot.service.OpenAiService
import mu.KotlinLogging
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import org.springframework.stereotype.Component

private const val DEFAULT_ERROR_MESSAGE = "Something went wrong. Please try again later."

@Component
class SlashCommandListener(
    val openAiService: OpenAiService
) : ListenerAdapter() {

    private val logger = KotlinLogging.logger {}

    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        when (event.name) {
            "ask" -> askChatGpt(event)
        }
    }

    private fun askChatGpt(event: SlashCommandInteractionEvent) {
        val question = event.getOption("question")?.asString
        openAiService.ask(question)
            .doOnSuccess { event.reply(it).queue() }
            .doOnError {
                logger.error(it) { "Error while processing question: $question - ${it.message}" }
                event.reply(DEFAULT_ERROR_MESSAGE).queue()
            }
            .subscribe()

    }
}