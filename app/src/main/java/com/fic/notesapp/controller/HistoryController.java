package com.fic.notesapp.controller;

import android.content.Context;

import com.fic.notesapp.model.ProviderDatabase;
import com.fic.notesapp.model.history.History;
import com.fic.notesapp.model.history.HistoryDao;

import java.util.List;

public class HistoryController {

    HistoryDao historyDao;

    public HistoryController(Context context){
        this.historyDao = ProviderDatabase.getInstance(context).historyDao();
    }

    public List<History> getAllHistory(){return historyDao.getAllHistory();}

    public void insertHistory(String action, String details, String created_at){

        History history = new History();
        history.action = action;
        history.created_at = created_at;
        history.details = details;

        historyDao.insertHistory(history);
    }

    public void deleteHistory(History history){historyDao.deleteHistory(history);}

    public List<History> getHistoryByDate(){return historyDao.getHistoryByDate();}

    public List<History> getHistoyByAction(String action){return historyDao.getHistoyByAction(action);}

    public List<History> getHistoyByActionDate(String action){return historyDao.getHistoyByActionDate(action);}

}
