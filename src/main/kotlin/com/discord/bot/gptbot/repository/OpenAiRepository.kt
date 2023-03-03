package com.discord.bot.gptbot.repository

import com.discord.bot.gptbot.domain.AiModel
import reactor.core.publisher.Mono

interface OpenAiRepository {

    fun processText(text: String): Mono<String>

    fun processText(text: String, model: AiModel): Mono<String>

}
