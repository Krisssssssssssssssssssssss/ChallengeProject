package com.example.demo.dto;

import com.example.demo.model.Note;

public record NoteDtoClient(String title, String content, String status) {
    public Note toModel() {
        return Note.builder()
                .title(title)
                .content(content)
                .status(status)
                .build();
    }
}
