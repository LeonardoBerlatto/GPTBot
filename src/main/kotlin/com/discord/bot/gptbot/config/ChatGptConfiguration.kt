package com.discord.bot.gptbot.config

import com.discord.bot.gptbot.repository.ChatGptRepository
import com.discord.bot.gptbot.service.OpenAiService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ChatGptConfiguration {

    @Bean
    fun openAiService(chatGptRepository: ChatGptRepository): OpenAiService {
        return OpenAiService(chatGptRepository)
    }
}