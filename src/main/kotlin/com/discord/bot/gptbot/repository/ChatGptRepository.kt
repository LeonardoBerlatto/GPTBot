package com.discord.bot.gptbot.repository

import reactor.core.publisher.Mono

interface ChatGptRepository {

    fun processText(text: String): Mono<String>
}
