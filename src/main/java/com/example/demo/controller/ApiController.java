package com.example.demo.controller;

import com.example.demo.model.Note;
import com.example.demo.service.ChatGptService;
import com.example.demo.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
@RequiredArgsConstructor
public class ApiController {

    private final NoteService noteService;
    private final ChatGptService chatGptService;
    @GetMapping
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable String id) {
        try {
            Note note = noteService.getNoteById(id);
            return ResponseEntity.ok(note);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body(null);  // Return 404 if not found
        }
    }

    @PostMapping
    public ResponseEntity<Note> createNewNote(@RequestBody Note newNote) {
        String correctedDescription = chatGptService.correct(newNote.description());
        Note correctedNote = newNote.toBuilder().description(correctedDescription).build();
        Note createdNote = noteService.addNote(correctedNote);

        return ResponseEntity.ok(createdNote);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable String id, @RequestBody Note updatedNote) {
        try {
            Note note = noteService.updateNote(id, updatedNote);
            return ResponseEntity.ok(note);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNoteById(@PathVariable String id) {
        try {
            noteService.deleteNoteById(id);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).build();  // Return 404 if not found
        }
    }
}
