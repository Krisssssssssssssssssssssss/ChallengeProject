package com.example.demo.repository;

import com.example.demo.dto.NoteDtoClient;
import com.example.demo.model.Note;

import java.util.List;

public interface INotesService {
    List<Note> getAllNotes();
    Note getNoteById(String id);
    Note addNote(NoteDtoClient noteDtoClient);
    Note updateNote(String id, NoteDtoClient noteDtoClient);
    void deleteNoteById(String id);
}
