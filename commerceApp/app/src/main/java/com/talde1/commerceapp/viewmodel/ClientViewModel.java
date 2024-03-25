package com.talde1.commerceapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.talde1.commerceapp.model.Bill;
import com.talde1.commerceapp.model.Client;
import com.talde1.commerceapp.repos.ClientsRepo;

import java.util.List;

public class ClientViewModel extends AndroidViewModel {
    ClientsRepo clientsRepo;
    //MutableLiveData<List<Client>> listClientsMutableLiveData = new MutableLiveData<>();
    //MutableLiveData<Client> clientSelected = new MutableLiveData<>();
    MutableLiveData<Client> clientSelected;

    public ClientViewModel(@NonNull Application application){
        super(application);
        clientsRepo = new ClientsRepo(application);
    }

    public LiveData<List<Client>> get(){ return clientsRepo.get(); }

    public void add(Client client) {
        clientsRepo.insert(client);
    }

    void delete(Client client) {
        clientsRepo.delete(client);
    }

    void update(Client client) {
        clientsRepo.update(client);
    }

    public void select(Client client) {
        clientSelected.setValue(client);
    }

    public LiveData<List<Bill>> getClientUnpaidBills(int id){
        return clientsRepo.getClientUnpaidBills(id);
    }
    public LiveData<List<Bill>> getClientUnsentBills(int id){
        return clientsRepo.getClientUnsentBills(id);
    }

    public MutableLiveData<Client> selected() {
        return clientSelected;
    }

    public Client detailClient(int id){ return clientsRepo.detailClient(id); }

}
