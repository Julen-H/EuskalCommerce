package com.talde1.commerceapp.repos;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.talde1.commerceapp.dao.DBAccess;
import com.talde1.commerceapp.dao.SettingsDAO;
import com.talde1.commerceapp.model.Product;
import com.talde1.commerceapp.model.Settings;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SettingsRepo {
    SettingsDAO settingsDAO;
    Executor executor = Executors.newSingleThreadExecutor();
    public SettingsRepo(Application application){
        settingsDAO = DBAccess.obtainInstance(application).getSettingDAO();
    }
    public LiveData<List<Settings>> get(){ return settingsDAO.getSettings(); }

    public LiveData<Settings> getUserSettings(int id){
        return settingsDAO.getUserSettings(id);
    };

    public void insert(Settings settings) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                settingsDAO.insert(settings);
            }
        });
    }

    public void delete(Settings settings) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                settingsDAO.delete(settings);
            }
        });
    }

    public void update(Settings settings) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                settingsDAO.update(settings);
            }
        });
    }
}
