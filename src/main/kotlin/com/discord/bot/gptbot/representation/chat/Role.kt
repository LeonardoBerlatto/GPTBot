package com.discord.bot.gptbot.representation.chat

enum class Role(private val text: String) {
    USER("user"),
    ASSISTANT("assistant");

    override fun toString(): String {
        return text
    }
}
