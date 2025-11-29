package com.fic.notesapp.view.category;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fic.notesapp.R;
import com.fic.notesapp.model.category.Category;

public class CategoryViewHolder extends RecyclerView.ViewHolder {

    CheckBox cbBusqueda;
    TextView tvTitle;

    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);
    }


    public void render(Category item) {
        cbBusqueda = itemView.findViewById(R.id.cbBusqueda);
        tvTitle = itemView.findViewById(R.id.tvTitle);
        
        tvTitle.setText(item.category_name);
    }
}
