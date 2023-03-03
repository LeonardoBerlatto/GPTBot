package com.discord.bot.gptbot.representation.chat

class ChatMessage() {
    lateinit var role: Role
    lateinit var content: String


    constructor(role: Role, content: String) : this() {
        this.role = role
        this.content = content
    }
}