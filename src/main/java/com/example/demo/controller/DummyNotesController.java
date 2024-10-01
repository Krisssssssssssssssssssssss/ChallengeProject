package com.example.demo.controller;

import com.example.demo.dto.NoteDtoClient;
import com.example.demo.service.DummyNotesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo/dummy")
@RequiredArgsConstructor
public class DummyNotesController {

    private final DummyNotesService dummyNotesService;

    @GetMapping
    public List<NoteDtoClient> getAllNotes() {
        return dummyNotesService.getAllNotes();
    }

    @GetMapping("/{id}")
    public NoteDtoClient getNoteById(@PathVariable String id) {
        return dummyNotesService.getNoteById(id);
    }

    @PostMapping
    public NoteDtoClient createNewNote(@RequestBody NoteDtoClient newNote) {
        return dummyNotesService.addNote(newNote);
    }

    @PutMapping("/{id}")
    public NoteDtoClient updateNote(@PathVariable String id, @RequestBody NoteDtoClient updatedNote) {
        return dummyNotesService.updateNote(id, updatedNote);
    }

    @DeleteMapping("/{id}")
    public void deleteNoteById(@PathVariable String id) {
        dummyNotesService.deleteNoteById(id);
    }
}
