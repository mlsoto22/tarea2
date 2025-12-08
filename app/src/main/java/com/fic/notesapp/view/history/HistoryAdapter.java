package com.fic.notesapp.view.history;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fic.notesapp.R;
import com.fic.notesapp.model.history.History;

import java.util.ArrayList;
import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryViewHolder> {

    List<History> listHistory = new ArrayList<>();
    public void setData(List<History> listHistory){
        this.listHistory.clear();
        if (listHistory != null){
            this.listHistory.addAll(listHistory);
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View layoutInflater = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history, parent, false);
        return new HistoryViewHolder(layoutInflater);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        History item = listHistory.get(position);
        holder.render(item);
    }

    @Override
    public int getItemCount() {
        return listHistory.size();
    }
}
