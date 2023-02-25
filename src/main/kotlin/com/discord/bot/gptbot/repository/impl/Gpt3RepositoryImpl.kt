package com.discord.bot.gptbot.repository.impl

import com.discord.bot.gptbot.repository.ChatGptRepository
import org.springframework.stereotype.Repository
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Repository
class Gpt3RepositoryImpl(private val webClient: WebClient) : ChatGptRepository {

    override fun processText(text: String): Mono<String> {
        return webClient.post()
            .uri("/completions")
            .body(Mono.just(text), String::class.java)
            .retrieve()
            .bodyToMono(String::class.java)
    }
}