package com.discord.bot.gptbot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GptBotApplication

fun main(args: Array<String>) {
	runApplication<GptBotApplication>(*args)
}
