package com.fic.notesapp.model;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.fic.notesapp.model.category.Category;
import com.fic.notesapp.model.category.CategoryDao;
import com.fic.notesapp.model.note.Note;
import com.fic.notesapp.model.note.NoteDao;

import java.util.concurrent.Executors;

@Database(entities = {Category.class, Note.class},version = 1,exportSchema = false)
public abstract class ProviderDatabase extends RoomDatabase {

    private static ProviderDatabase INSTANCE;
    public abstract CategoryDao categoryDao();
    public abstract NoteDao noteDao();


    public static synchronized ProviderDatabase getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(
                    context.getApplicationContext(),
                    ProviderDatabase.class,
                    "app_database"
            ).addCallback(new RoomDatabase.Callback() {

                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);

                            Executors.newSingleThreadExecutor().execute(() -> {
                                ProviderDatabase database = INSTANCE;

                                if (database != null) {
                                    Category defaultCategory = new Category();
                                    defaultCategory.category_id = 1;
                                    defaultCategory.category_name = "Sin categoria";

                                    database.categoryDao().insertCategory(defaultCategory);
                                }
                            });
                        }
                    })
                    .allowMainThreadQueries()
                    .build();
        }

        return INSTANCE;
    }

}
