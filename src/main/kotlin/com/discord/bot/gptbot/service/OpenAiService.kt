package com.discord.bot.gptbot.service

import com.discord.bot.gptbot.repository.ChatGptRepository

private const val INVALID_QUESTION_MESSAGE = "Provide a valid question"

class OpenAiService(private val repository: ChatGptRepository) {

    fun ask(question: String?): String {
        if (question.isNullOrBlank()) {
            return INVALID_QUESTION_MESSAGE
        }

        return repository.processText(question)
    }

}