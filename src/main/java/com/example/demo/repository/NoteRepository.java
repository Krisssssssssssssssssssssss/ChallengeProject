package com.example.demo.repository;

import com.example.demo.model.Note;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
@Document("note")
public interface NoteRepository extends MongoRepository<Note, String> {
}
