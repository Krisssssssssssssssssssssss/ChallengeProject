package com.example.demo.dto;

import com.example.demo.model.Note;

import java.util.UUID;

public record NoteDtoClient(String id, String title, String description, String status) {
    public Note toModel() {
        return Note.builder()
                .id(id)
                .title(title)
                .description(description)
                .status(status)
                .build();
    }

    public static NoteDtoClient fromModel(Note note) {
        return new NoteDtoClient(UUID.randomUUID().toString(), note.title(), note.description(), note.status());
    }
}
