package com.example.demo.model;

import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder(toBuilder = true)
@Document("note")
public record Note(String id, String title, String content, String status) {
}
