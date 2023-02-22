package com.discord.bot.gptbot.service

import com.discord.bot.gptbot.repository.ChatGptRepository

class OpenAiService(private val repository: ChatGptRepository) {

    fun ask(question: String?): String {
        if (question.isNullOrBlank()) {
            return "Provide a valid question"
        }

        return repository.processText(question)
    }

}