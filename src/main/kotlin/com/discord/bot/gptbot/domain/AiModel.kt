package com.discord.bot.gptbot.domain

enum class AiModel(val versionName: String) {

    DA_VINCI("text-davinci-003"),
    CURIE("text-curie-001"),
    BABBAGE("text-babbage-001"),
    ADA("text-ada-001"),
    GPT_3_TURBO("gpt-3.5-turbo"),
    GPT_3_TURBO_0301("gpt-3.5-turbo-0301"),
}
