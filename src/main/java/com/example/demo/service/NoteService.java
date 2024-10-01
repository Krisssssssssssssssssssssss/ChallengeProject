package com.example.demo.service;

import com.example.demo.model.Note;
import com.example.demo.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Note getNoteById(String id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Note with ID " + id + " not found"));
    }

    public Note addNote(Note note) {
        return noteRepository.save(note);
    }

    public Note updateNote(String id, Note updatedNote) {
        if (noteRepository.existsById(id)) {
            Note noteToUpdate = updatedNote.toBuilder().id(id).build();
            return noteRepository.save(noteToUpdate);
        } else {
            throw new IllegalArgumentException("Note with ID " + id + " does not exist");
        }
    }

    public void deleteNoteById(String id) {
        if (noteRepository.existsById(id)) {
            noteRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Note with ID " + id + " does not exist");
        }
    }
}
