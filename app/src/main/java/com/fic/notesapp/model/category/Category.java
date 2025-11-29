package com.fic.notesapp.model.category;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "category")
public class Category {

    @PrimaryKey(autoGenerate = true)
    public int category_id;

    @ColumnInfo(name = "category_name")
    public String category_name;

}
