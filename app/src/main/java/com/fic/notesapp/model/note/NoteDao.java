package com.fic.notesapp.model.note;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NoteDao {

    @Insert
    void insertNote(Note note);

    @Query("SELECT * FROM note")
    List<Note> getAllNotes();

    @Query("SELECT * FROM note WHERE note_id = :id")
    Note getNoteById(int id);

    @Query("SELECT * FROM note WHERE category_id = :categoryId")
    List<Note> getAllNotesByCategory(int categoryId);

    @Delete
    void deleteNote(Note note);

    @Update
    void updateNote(Note note);

}
