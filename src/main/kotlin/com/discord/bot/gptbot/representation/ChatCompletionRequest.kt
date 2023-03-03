package com.discord.bot.gptbot.representation

import com.discord.bot.gptbot.representation.chat.ChatMessage

data class ChatCompletionRequest(
    val messages: List<ChatMessage>,
    val model: String
)
