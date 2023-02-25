package com.discord.bot.gptbot.config

import com.discord.bot.gptbot.repository.ChatGptRepository
import com.discord.bot.gptbot.service.OpenAiService
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient


@Configuration
class ChatGptConfiguration {

    @Value("\${open-ai.api.url}")
    private lateinit var apiBaseUrl: String

    @Value("\${open-ai.api.token}")
    private lateinit var apiToken: String

    @Bean
    fun webClient(): WebClient {
        return WebClient.builder()
            .baseUrl(apiBaseUrl)
            .defaultHeader("content-type", "application/json")
            .defaultHeader("Authorization", "Bearer $apiToken")
            .build()
    }

    @Bean
    fun openAiService(chatGptRepository: ChatGptRepository): OpenAiService {
        return OpenAiService(chatGptRepository)
    }
}