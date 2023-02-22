package com.discord.bot.gptbot.repository.impl

import com.discord.bot.gptbot.repository.ChatGptRepository
import org.springframework.stereotype.Repository

@Repository
class Gpt3RepositoryImpl : ChatGptRepository {

    override fun processText(text: String?): String {
        TODO("Not yet implemented")
    }
}