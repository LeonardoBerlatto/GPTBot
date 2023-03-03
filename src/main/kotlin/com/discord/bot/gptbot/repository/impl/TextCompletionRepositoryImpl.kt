package com.discord.bot.gptbot.repository.impl

import com.discord.bot.gptbot.representation.TextCompletionResponse
import com.discord.bot.gptbot.domain.AiModel
import com.discord.bot.gptbot.repository.OpenAiRepository
import com.discord.bot.gptbot.representation.TextCompletion
import org.springframework.stereotype.Repository
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@JvmField
val DEFAULT_TEXT_COMPLETION_MODEL = AiModel.DA_VINCI

@Repository("textCompletionRepository")
class TextCompletionRepositoryImpl(
    private val webClient: WebClient
) : OpenAiRepository {

    override fun processText(text: String): Mono<String> =
        processText(text, DEFAULT_TEXT_COMPLETION_MODEL)

    override fun processText(text: String, model: AiModel): Mono<String> = webClient.post()
        .uri("/completions")
        .body(Mono.just(buildRequest(text, model)), TextCompletion::class.java)
        .retrieve()
        .bodyToMono(TextCompletionResponse::class.java)
        .mapNotNull(this::mapResponse)

    private fun mapResponse(response: TextCompletionResponse): String? =
        response.choices.firstOrNull()?.text

    private fun buildRequest(text: String, model: AiModel) = TextCompletion(
        prompt = text,
        model = model.versionName,
    )
}