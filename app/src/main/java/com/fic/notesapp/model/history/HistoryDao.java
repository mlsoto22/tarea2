package com.fic.notesapp.model.history;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface HistoryDao {

    @Query("SELECT * FROM history ORDER BY  history_id DESC")
    List<History> getAllHistory();

    @Insert
    void insertHistory(History history);

    @Delete
    void deleteHistory(History history);

    @Query("SELECT * FROM history ORDER BY created_at ASC")
    List<History> getHistoryByDate();

    @Query("SELECT * FROM history WHERE `action` = :action")
    List<History> getHistoyByAction(String action);

    @Query("SELECT * FROM history WHERE `action` = :action ORDER BY created_at ASC")
    List<History> getHistoyByActionDate(String action);

}
