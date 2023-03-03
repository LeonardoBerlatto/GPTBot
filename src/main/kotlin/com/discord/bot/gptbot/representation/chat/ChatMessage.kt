package com.discord.bot.gptbot.representation.chat

data class ChatMessage(
    val role: Role,
    val content: String,
)