package com.discord.bot.gptbot.representation

import com.discord.bot.gptbot.representation.chat.ChatMessage

class ChatCompletionResponse {
    lateinit var choices: List<ChatChoice>

    class ChatChoice(val message: ChatMessage)
}
