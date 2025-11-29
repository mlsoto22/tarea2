package com.fic.notesapp.view.note;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.fic.notesapp.R;
import com.fic.notesapp.controller.CategoryController;
import com.fic.notesapp.model.category.Category;
import com.fic.notesapp.model.note.Note;

public class NoteViewHolder extends RecyclerView.ViewHolder {

    TextView tvTitle, tvContent, tvDate, tvCategory;
    CategoryController categoryController;
    Category category;
    CardView cvNoteParent;

    public NoteViewHolder(@NonNull View itemView) {
        super(itemView);
        categoryController = new CategoryController(itemView.getContext());
    }

    public void render(Note item, NoteAdapter.OnNoteActionListener listener) {

        tvTitle = itemView.findViewById(R.id.tvTitle);
        tvContent = itemView.findViewById(R.id.tvContent);
        tvDate = itemView.findViewById(R.id.tvDate);
        tvCategory = itemView.findViewById(R.id.tvCategory);
        cvNoteParent = itemView.findViewById(R.id.cvNoteParent);
        category = categoryController.getCategoryById(item.category_id);

        tvTitle.setText(item.note_title);
        tvContent.setText(item.note_content);
        tvDate.setText(item.created_at);
        tvCategory.setText(category.category_name);

        cvNoteParent.setOnClickListener(view -> {
            listener.onEdit(item);
        });
    }
}
