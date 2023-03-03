package com.discord.bot.gptbot.representation.text

class TextCompletionResponse {

    lateinit var choices: List<Choice>

    class Choice {
        val text: String? = null
    }
}
