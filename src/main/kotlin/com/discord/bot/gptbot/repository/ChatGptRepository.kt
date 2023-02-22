package com.discord.bot.gptbot.repository

interface ChatGptRepository {

    fun processText(text: String?): String
}
