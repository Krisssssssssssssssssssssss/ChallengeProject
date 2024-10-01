package com.example.demo.dto.chatGpt;

import java.util.List;

public record ChatGptResponse(List<ChatGptResponseChoice> choices) {
}