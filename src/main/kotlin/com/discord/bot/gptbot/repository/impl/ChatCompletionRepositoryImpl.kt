package com.discord.bot.gptbot.repository.impl

import com.discord.bot.gptbot.domain.AiModel
import com.discord.bot.gptbot.repository.OpenAiRepository
import com.discord.bot.gptbot.representation.chat.ChatCompletionRequest
import com.discord.bot.gptbot.representation.chat.ChatCompletionResponse
import com.discord.bot.gptbot.representation.chat.ChatMessage
import com.discord.bot.gptbot.representation.chat.Role
import org.springframework.stereotype.Repository
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@JvmField
val DEFAULT_CHAT_COMPLETION_MODEL: AiModel = AiModel.GPT_3_TURBO

@Repository("chatCompletionRepository")
class ChatCompletionRepositoryImpl(
    private val webClient: WebClient
) : OpenAiRepository {

    override fun processText(text: String): Mono<String> = processText(text, DEFAULT_CHAT_COMPLETION_MODEL)

    override fun processText(text: String, model: AiModel): Mono<String> = webClient.post()
        .uri("/chat/completions")
        .body(Mono.just(buildRequest(text, model)), ChatCompletionRequest::class.java)
        .retrieve()
        .bodyToMono(ChatCompletionResponse::class.java)
        .mapNotNull(this::mapResponse)

    private fun mapResponse(chatCompletionResponse: ChatCompletionResponse): String? {
        return chatCompletionResponse.choices.firstOrNull()?.message?.content
    }

    private fun buildRequest(text: String, model: AiModel): Any {
        return ChatCompletionRequest(
            messages = listOf(
                ChatMessage(
                    role = Role.USER,
                    content = text,
                )
            ),
            model = model.versionName,
        )
    }
}