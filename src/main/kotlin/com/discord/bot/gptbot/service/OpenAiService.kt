package com.discord.bot.gptbot.service

import com.discord.bot.gptbot.repository.OpenAiRepository
import reactor.core.publisher.Mono

private const val INVALID_QUESTION_MESSAGE = "Provide a valid question"

class OpenAiService(
    private val repository: OpenAiRepository
) {

    fun ask(question: String?): Mono<String> {
        if (question.isNullOrBlank()) {
            return Mono.just(INVALID_QUESTION_MESSAGE)
        }

        return repository.processText(question)
    }

}