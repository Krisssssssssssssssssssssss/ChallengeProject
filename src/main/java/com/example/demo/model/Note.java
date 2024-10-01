package com.example.demo.model;

import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Builder(toBuilder = true)
@Document(collection = "Notes")
public record Note(
        @Id String id,
        String title,
        String description,
        String status
) {
}
