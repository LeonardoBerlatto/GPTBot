package com.discord.bot.gptbot.representation

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
class TextCompletion(
    val model: String,
    val prompt: String? = null,
    val maxTokens: Int = 4000,
)
