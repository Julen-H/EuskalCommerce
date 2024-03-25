package com.talde1.commerceapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.talde1.commerceapp.model.Settings;
import com.talde1.commerceapp.repos.SettingsRepo;

import java.util.List;

public class SettingsViewModel extends AndroidViewModel {
    SettingsRepo settingsRepo;
    //MutableLiveData<List<Client>> listClientsMutableLiveData = new MutableLiveData<>();
    MutableLiveData<Settings> settingsSelected = new MutableLiveData<>();

    public SettingsViewModel(@NonNull Application application){
        super(application);
        settingsRepo = new SettingsRepo(application);
    }

    public LiveData<List<Settings>> get(){ return settingsRepo.get(); }

    public LiveData<Settings> getUserSettings(int id){
        return settingsRepo.getUserSettings(id);
    };

    public void add(Settings settings) {
        settingsRepo.insert(settings);
    }

    void delete(Settings settings) {
        settingsRepo.delete(settings);
    }

    void update(Settings settings) {
        settingsRepo.update(settings);
    }

    void select(Settings settings) {
        settingsSelected.setValue(settings);
    }

    MutableLiveData<Settings> selected() {
        return settingsSelected;
    }
    private String selectedLanguage;
    public String getSelectedLanguage() {
        return selectedLanguage;
    }
    public void setSelectedLanguage(String language) {
        selectedLanguage = language;
    }
}

