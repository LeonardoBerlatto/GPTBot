package com.discord.bot.gptbot.config

import com.discord.bot.gptbot.listener.SlashCommandListener
import com.discord.bot.gptbot.service.OpenAiService
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.entities.Activity
import net.dv8tion.jda.api.interactions.commands.OptionType
import net.dv8tion.jda.api.interactions.commands.build.Commands
import net.dv8tion.jda.api.requests.GatewayIntent
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DiscordConfiguration {

    @Value("\${discord.token}")
    lateinit var token: String

    @Bean
    fun discordBot(openAiService: OpenAiService): JDA {
        val jda = JDABuilder.createDefault(token)
            .enableIntents(GatewayIntent.MESSAGE_CONTENT)
            .addEventListeners(SlashCommandListener(openAiService))
            .setActivity(Activity.listening("/ask"))
            .build()

        jda.updateCommands().addCommands(
            Commands.slash("ask", "Ask Chat GPT a question")
                .addOption(
                    OptionType.STRING,
                    "question",
                    "The question to ask",
                    true
                )

        ).queue()

        return jda
    }
}