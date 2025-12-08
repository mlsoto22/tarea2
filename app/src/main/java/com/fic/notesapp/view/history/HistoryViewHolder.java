package com.fic.notesapp.view.history;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fic.notesapp.R;
import com.fic.notesapp.model.history.History;

public class HistoryViewHolder extends RecyclerView.ViewHolder {

    TextView date, action, description;

    public HistoryViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void render(History item){
        date = itemView.findViewById(R.id.tvDate);
        action = itemView.findViewById(R.id.tvAction);
        description = itemView.findViewById(R.id.tvDescription);
        String[] actions = itemView.getResources().getStringArray(R.array.action_history);


        switch (item.action){
            case "C":
                action.setText(actions[0]);
                action.setTextColor(itemView.getResources().getColor(R.color.green, null));
                break;
            case "U":
                action.setText(actions[1]);
                action.setTextColor(itemView.getResources().getColor(R.color.yellow, null));
                break;
            case "D":
                action.setText(actions[2]);
                action.setTextColor(itemView.getResources().getColor(R.color.red, null));
                break;
        }

        date.setText(item.created_at);
        description.setText(item.details);


    }
}
