package com.discord.bot.gptbot.config

import com.discord.bot.gptbot.listener.SlashCommandListener
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.entities.Activity
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
    fun discordBot() {
        val jda = JDABuilder.createDefault(token)
            .enableIntents(GatewayIntent.MESSAGE_CONTENT)
            .addEventListeners(SlashCommandListener())
            .setActivity(Activity.listening("type /ask"))
            .build()

        jda.updateCommands().addCommands(
            Commands.slash("ask", "Ask Chat GPT a question"),
        ).queue();
    }
}