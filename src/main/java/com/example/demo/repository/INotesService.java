package com.example.demo.repository;

import com.example.demo.dto.NoteDtoClient;
import com.example.demo.model.Note;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public interface INotesService {
    List<NoteDtoClient> getAllNotes = new List<NoteDtoClient>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<NoteDtoClient> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(NoteDtoClient noteDtoClient) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends NoteDtoClient> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends NoteDtoClient> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public NoteDtoClient get(int index) {
            return null;
        }

        @Override
        public NoteDtoClient set(int index, NoteDtoClient element) {
            return null;
        }

        @Override
        public void add(int index, NoteDtoClient element) {

        }

        @Override
        public NoteDtoClient remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<NoteDtoClient> listIterator() {
            return null;
        }

        @Override
        public ListIterator<NoteDtoClient> listIterator(int index) {
            return null;
        }

        @Override
        public List<NoteDtoClient> subList(int fromIndex, int toIndex) {
            return List.of();
        }
    };

    List<NoteDtoClient> getAllNotes();
//    NoteDtoClient getNoteById(Long id);
//    NoteDtoClient addNote(Note noteDtoClient);

}
