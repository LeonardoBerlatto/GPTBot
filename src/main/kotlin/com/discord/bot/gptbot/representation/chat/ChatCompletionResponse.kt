package com.discord.bot.gptbot.representation.chat

class ChatCompletionResponse {
    lateinit var choices: List<ChatChoice>

    class ChatChoice {
        val message: ChatMessage? = null
    }
}
