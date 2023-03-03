package com.discord.bot.gptbot.representation.chat

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class ChatCompletionRequest(
    val messages: List<ChatMessage>,
    val model: String
)
