package com.fic.notesapp.controller;

import android.content.Context;

import com.fic.notesapp.model.ProviderDatabase;
import com.fic.notesapp.model.category.Category;
import com.fic.notesapp.model.category.CategoryDao;

import java.util.List;

public class CategoryController {

    private final CategoryDao categoryDao;

    public CategoryController(Context context) {
        this.categoryDao = ProviderDatabase.getInstance(context).categoryDao();
    }

    public void insertCategory(String name) {
        try{

            Category category = new Category();
            category.category_name = name;
            categoryDao.insertCategory(category);

        } catch (Exception e){

        }
    }

    public List<Category> getAllCategories() { return categoryDao.getAllCategories(); }

    public Category getCategoryById(int id) { return categoryDao.getCategoryById(id); }
}
