package com.fic.notesapp.model.history;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "history")
public class History {

    @PrimaryKey(autoGenerate = true)
    public int history_id;

    @ColumnInfo(name = "action")
    public String action;

    @ColumnInfo(name = "created_at")
    public String created_at;

    @ColumnInfo(name = "details")
    public String details;

}
