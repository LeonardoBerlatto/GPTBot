package com.discord.bot.gptbot.service

import com.discord.bot.gptbot.domain.AiModel
import com.discord.bot.gptbot.repository.ChatGptRepository
import reactor.core.publisher.Mono

private const val INVALID_QUESTION_MESSAGE = "Provide a valid question"

@JvmField
val DEFAULT_MODEL = AiModel.DA_VINCI

class OpenAiService(private val repository: ChatGptRepository) {

    fun ask(question: String?): Mono<String> {
        if (question.isNullOrBlank()) {
            return Mono.just(INVALID_QUESTION_MESSAGE)
        }

        return repository.processText(question, DEFAULT_MODEL)
    }

}