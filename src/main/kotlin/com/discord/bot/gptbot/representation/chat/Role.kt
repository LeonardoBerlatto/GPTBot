package com.discord.bot.gptbot.representation.chat

import com.fasterxml.jackson.annotation.JsonValue

enum class Role(@JsonValue val text: String) {
    USER("user"),
    ASSISTANT("assistant");

    override fun toString(): String {
        return text
    }
}
