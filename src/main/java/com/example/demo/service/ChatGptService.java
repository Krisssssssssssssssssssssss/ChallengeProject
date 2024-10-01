package com.example.demo.service;

import com.example.demo.dto.chatGpt.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class ChatGptService {

    private final RestClient restClient;

    public ChatGptService(
            RestClient.Builder restClientBuilder,
            @Value("${chat.gpt.api.token}") String chatGptApiToken) {
        this.restClient = restClientBuilder
                .baseUrl("https://api.openai.com/v1/chat/completions")
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + chatGptApiToken)
                .build();
    }

    public String correct(
            String rawMessage
    ) {
        String fullMessage = "Do not change the context of this message, just fix grammar misstakes if present: " + rawMessage + ". If correction was needed, add (grammar mistakes were automatically corrected)";
        ChatGptRequestMessage message = new ChatGptRequestMessage("user", fullMessage);
        ChatGptRequest request = new ChatGptRequest("gpt-4o-mini", List.of(message));

        return restClient
                .post()
                .body(request)
                .retrieve()
                .body(ChatGptResponse.class)
                .choices()
                .get(0)
                .message()
                .content();
    }
}
