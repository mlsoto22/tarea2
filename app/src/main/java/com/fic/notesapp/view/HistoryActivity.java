package com.fic.notesapp.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fic.notesapp.R;
import com.fic.notesapp.controller.HistoryController;
import com.fic.notesapp.model.history.History;
import com.fic.notesapp.model.history.HistoryDao;
import com.fic.notesapp.view.history.HistoryAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    RecyclerView rvHistory;
    HistoryAdapter historyAdapter;
    HistoryController historyController;
    ImageButton btnDate, btnAction;
    boolean isDate = false;
    int index = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        initComponents();
        initRV();
        initListeners();
    }

    private void initComponents() {
        rvHistory = findViewById(R.id.rvHistory);
        historyController = new HistoryController(this);
        historyAdapter = new HistoryAdapter();
        btnAction = findViewById(R.id.btnAction);
        btnDate = findViewById(R.id.btnDate);

    }

    private void initRV() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvHistory.setLayoutManager(layoutManager);
        rvHistory.setAdapter(historyAdapter);
        historyAdapter.setData(historyController.getAllHistory());
    }

    private void initListeners() {

        btnAction.setOnClickListener(view -> {
            PopupMenu popup = new PopupMenu(this, view);
            popup.getMenuInflater().inflate(R.menu.menu_actions, popup.getMenu());
            popup.show();

            popup.setOnMenuItemClickListener(item -> {
                int itemId = item.getItemId();
                if (itemId == R.id.action_create){
                    updateListByAtion("C");
                } else if (itemId == R.id.action_update){
                    updateListByAtion("U");
                } else if (itemId == R.id.action_delete){
                    updateListByAtion("D");
                }
                return true;
            }
        );

        btnDate.setOnClickListener(view2 -> {
            isDate = !isDate;
            if (isDate){
                updateList(historyController.getHistoryByDate());
            } else {
                updateList(historyController.getAllHistory());
            }
        });

    });

    }

    private void updateListByAtion(String action) {
        if (isDate){
            updateList(historyController.getHistoyByActionDate(action));
        } else {
            updateList(historyController.getHistoyByAction(action));
        }
    }

    public void updateList(List<History> list) {
        historyAdapter.setData(list);
    }

}