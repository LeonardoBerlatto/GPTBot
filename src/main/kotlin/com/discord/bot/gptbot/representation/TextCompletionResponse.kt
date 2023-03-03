package com.discord.bot.gptbot.representation

class TextCompletionResponse {

    lateinit var choices: List<Choice>

    class Choice {
        val text: String? = null
    }
}
