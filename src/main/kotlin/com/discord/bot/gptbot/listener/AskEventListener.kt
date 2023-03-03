package com.discord.bot.gptbot.listener

import com.discord.bot.gptbot.service.OpenAiService
import mu.KotlinLogging
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import org.springframework.stereotype.Component

private const val DEFAULT_ERROR_MESSAGE = "Something went wrong. Please try again later."

@Component
class AskEventListener(
    val openAiService: OpenAiService
) : ListenerAdapter() {

    private val logger = KotlinLogging.logger {}

    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        event.deferReply(true).queue()
        when (event.name) {
            "ask" -> {
                val question = event.getOption("question")?.asString
                askChatGpt(question,
                    successCallback = {
                        event.hook.sendMessage(it).queue()
                    }, errorCallback = {
                        event.hook.sendMessage(DEFAULT_ERROR_MESSAGE).queue()
                    })
            }
        }
    }

    private fun askChatGpt(
        question: String?,
        successCallback: (String) -> Unit,
        errorCallback: (Throwable) -> Unit
    ) {
        openAiService.ask(question)
            .doOnSuccess { successCallback(it) }
            .doOnError {
                logger.error(it) { "Error while processing question: $question - ${it.message}" }
                errorCallback(it)
            }
            .subscribe()
    }
}