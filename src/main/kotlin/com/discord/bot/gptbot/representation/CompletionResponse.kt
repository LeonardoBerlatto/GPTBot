package com.discord.bot.gptbot.representation

class CompletionResponse {

    lateinit var choices: List<Choice>

    class Choice {
        val text: String? = null
    }
}
