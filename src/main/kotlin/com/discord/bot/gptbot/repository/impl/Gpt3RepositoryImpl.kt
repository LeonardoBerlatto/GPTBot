package com.discord.bot.gptbot.repository.impl

import com.discord.bot.gptbot.representation.CompletionResponse
import com.discord.bot.gptbot.domain.AiModel
import com.discord.bot.gptbot.repository.ChatGptRepository
import com.discord.bot.gptbot.representation.CompletionRequest
import org.springframework.stereotype.Repository
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Repository
class Gpt3RepositoryImpl(private val webClient: WebClient) : ChatGptRepository {


    override fun processText(text: String, model: AiModel): Mono<String> {

        return webClient.post()
            .uri("/completions")
            .body(Mono.just(buildRequest(text, model)), CompletionRequest::class.java)
            .retrieve()
            .bodyToMono(CompletionResponse::class.java)
            .mapNotNull(this::mapResponse)
    }

    private fun mapResponse(response: CompletionResponse): String? {
        return response.choices.firstOrNull()?.text
    }

    private fun buildRequest(text: String, model: AiModel) = CompletionRequest(
        prompt = text,
        model = model.latestVersionName,
    )
}