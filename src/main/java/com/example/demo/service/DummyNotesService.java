package com.example.demo.service;

import com.example.demo.dto.NoteDtoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DummyNotesService {

    private final List<NoteDtoClient> dummyNotes = new ArrayList<>();

    public List<NoteDtoClient> getAllNotes() {
        return dummyNotes;
    }

    public NoteDtoClient getNoteById(String id) {
        return dummyNotes.stream()
                .filter(note -> note.id().equals(id))
                .findFirst()
                .orElse(null);
    }

    public NoteDtoClient addNote(NoteDtoClient newNote) {
        String newId = UUID.randomUUID().toString();
        NoteDtoClient noteWithId = new NoteDtoClient(newId, newNote.title(), newNote.description(), newNote.status());
        dummyNotes.add(noteWithId);
        return noteWithId;
    }

    public NoteDtoClient updateNote(String id, NoteDtoClient updatedNote) {
        Optional<NoteDtoClient> existingNote = dummyNotes.stream()
                .filter(note -> note.id().equals(id))
                .findFirst();

        if (existingNote.isPresent()) {
            NoteDtoClient updatedNoteWithId = new NoteDtoClient(id, updatedNote.title(), updatedNote.description(), updatedNote.status());
            dummyNotes.remove(existingNote.get());
            dummyNotes.add(updatedNoteWithId);
            return updatedNoteWithId;
        }

        return null;
    }

    public boolean deleteNoteById(String id) {
        return dummyNotes.removeIf(note -> note.id().equals(id));
    }
}
