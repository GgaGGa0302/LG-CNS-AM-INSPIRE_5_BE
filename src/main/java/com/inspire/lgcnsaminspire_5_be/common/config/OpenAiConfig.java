package com.inspire.lgcnsaminspire_5_be.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.OkHttpClient;

@Configuration
public class OpenAiConfig {
    @Bean
    public ObjectMapper objectMapper() {
        System.out.println(">>>> debug OpenAi config objectMapper");
        return new ObjectMapper();
    }

    @Bean
    public OkHttpClient okHttpClient() {
        System.out.println(">>>> debug OpenAi config okHttpClient");
        return new OkHttpClient();
    }
}
