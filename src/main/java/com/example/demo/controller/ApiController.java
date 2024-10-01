package com.example.demo.controller;

import com.example.demo.dto.NoteDtoClient;
import com.example.demo.model.Note;
import com.example.demo.service.NotesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class ApiController {

    private final NotesService notesService;

    public ApiController(NotesService notesService) {
        this.notesService = notesService;
    }
    @GetMapping("todo")
    public String getAllNotes() {
        return "text";
    }


//    @GetMapping("todo")
//    public List<NoteDtoClient> getAllNotes() {
//        return notesService.getAllNotes();
//    }

}