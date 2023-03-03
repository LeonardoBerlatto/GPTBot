package com.discord.bot.gptbot.service

import com.discord.bot.gptbot.domain.AiModel
import com.discord.bot.gptbot.repository.OpenAiRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource
import reactor.core.publisher.Mono

class OpenAiServiceTest {

    private val repository = mockk<OpenAiRepository>()

    private val service = OpenAiService(repository)

    @Test
    fun `should return the answer when providing a valid question passing the right model as parameter`() {
        val question = "What is the meaning of life?"
        val answer = "42"

        every { repository.processText(question) } returns Mono.just(answer)

        val result = service.ask(question).block()

        assertEquals(answer, result)
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = [" ", "  ", "   "])
    fun `should return warning message when question is null or blank`(question: String?) {
        val result = service.ask(question).block()

        assertEquals("Provide a valid question", result)
    }

}