package com.fic.notesapp.view;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.fic.notesapp.R;
import com.fic.notesapp.controller.CategoryController;
import com.fic.notesapp.controller.NoteController;
import com.fic.notesapp.model.category.Category;
import com.fic.notesapp.model.note.Note;
import com.google.android.material.transformation.ExpandableTransformationBehavior;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AddNotesActivity extends AppCompatActivity {

    NoteController noteController;
    CategoryController categoryController;
    EditText etTitle, etContent;
    Spinner spCategory;
    AppCompatButton btnAddNote;
    int idCategory = 1;
    boolean extra = getIntent().getBooleanExtra("ON_EDIT", false);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notes);
        initComponents();
        initListeners();

    }

    private void initComponents() {

        noteController = new NoteController(this);
        categoryController = new CategoryController(this);
        etTitle = findViewById(R.id.etTitle);
        etContent = findViewById(R.id.etContent);
        btnAddNote = findViewById(R.id.addNote);
        initSpinner();
    }

    private void initSpinner(){
        List<Category> listCategories = categoryController.getAllCategories();
        List<String> listCategoriesNames = new ArrayList<>();
        for(Category category : listCategories){
            listCategoriesNames.add(category.category_name);
        }

        spCategory = findViewById(R.id.spCategory);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                listCategoriesNames
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCategory.setAdapter(adapter);

        spCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Category selectedCategory = listCategories.get(position);
                Log.i("SELECTED_CATEGORY", "Categoria seleccionada: " + selectedCategory.category_id);
                idCategory = selectedCategory.category_id;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                idCategory = listCategories.get(0).category_id;
            }
        });
    }

    private void initListeners() {

        btnAddNote.setOnClickListener(v -> {
            if(validarDatos()){
                
                saveNote();
                finish();
                
            }
        });

    }

    private void saveNote() {

        try {
            noteController.insertNote(etTitle.getText().toString(), etContent.getText().toString(), idCategory,"10/10/2023");
            Toast.makeText(this, "La nota se ha guardado correctamente", Toast.LENGTH_SHORT).show();
        } catch (Exception e){
            Toast.makeText(this, "No se ha podido añadir la nota", Toast.LENGTH_SHORT).show();
            Log.i("ERROR_ADD_NOTE", "Error al guardar la nota: " + e.getMessage());
        }
        
    }

    private boolean validarDatos() {
        return !etTitle.getText().toString().isEmpty() && !etContent.getText().toString().isEmpty();
    }
}