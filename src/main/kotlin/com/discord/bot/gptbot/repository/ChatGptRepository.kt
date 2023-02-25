package com.discord.bot.gptbot.repository

import com.discord.bot.gptbot.domain.AiModel
import reactor.core.publisher.Mono

interface ChatGptRepository {

    fun processText(text: String, model: AiModel): Mono<String>
}
