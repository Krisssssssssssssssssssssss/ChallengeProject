package com.example.demo.dto.chatGpt;

import java.util.List;

public record ChatGptRequest(String model, List<ChatGptRequestMessage> messages) {
}
