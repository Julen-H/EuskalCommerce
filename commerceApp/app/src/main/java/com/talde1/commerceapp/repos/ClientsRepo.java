package com.talde1.commerceapp.repos;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.talde1.commerceapp.dao.BillDAO;
import com.talde1.commerceapp.dao.ClientDAO;
import com.talde1.commerceapp.dao.DBAccess;
import com.talde1.commerceapp.model.Bill;
import com.talde1.commerceapp.model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ClientsRepo {


    ClientDAO clientDAO;
    BillDAO billDAO;

    Executor executor = Executors.newSingleThreadExecutor();


    public ClientsRepo(Application application){

        clientDAO = DBAccess.obtainInstance(application).getClientDAO();
    }

    public LiveData<List<Client>> get(){ return clientDAO.getClients(); }
    public LiveData<List<Bill>> getClientUnpaidBills(int id){
        return clientDAO.getClientUnpaidBills(id);
    }
    public LiveData<List<Bill>> getClientUnsentBills(int id){
        return clientDAO.getClientUnsentBills(id);
    }

    public Client detailClient(int id) { return clientDAO.detailClient(id); }


    public void insert(Client client) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                clientDAO.insert(client);
            }
        });
    }

    public void delete(Client client) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                clientDAO.delete(client);
            }
        });
    }

    public void update(Client client) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                clientDAO.update(client);
            }
        });
    }
}
