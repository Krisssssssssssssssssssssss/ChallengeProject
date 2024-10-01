package com.example.demo.service;

import com.example.demo.dto.NoteDtoClient;
import com.example.demo.model.Note;
import com.example.demo.repository.INotesService;
import com.example.demo.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class NotesService implements INotesService {

    private final NoteRepository noteRepository;

    @Override
    public List<NoteDtoClient> getAllNotes() {
        List<NoteDtoClient> result = new ArrayList<>();
        return noteRepository.findAll()
                .stream()
                .map(x -> new NoteDtoClient(x.title(), x.content(), x.status()))
                .collect(Collectors.toCollection(() -> result));
    }
}

