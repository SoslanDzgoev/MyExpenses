package com.example.myexpenses.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Configuration
@Data
public class BotConfig {
    @Value("${bot.name}")
    String botUserName;
    @Value("${bot.token}")
    String token;
}
