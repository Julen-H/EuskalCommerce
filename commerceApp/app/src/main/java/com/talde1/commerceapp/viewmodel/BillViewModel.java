package com.talde1.commerceapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.talde1.commerceapp.model.Bill;
import com.talde1.commerceapp.repos.BillRepo;

import java.util.List;

public class BillViewModel extends AndroidViewModel {
    BillRepo billRepo;
    //MutableLiveData<List<Client>> listClientsMutableLiveData = new MutableLiveData<>();
    MutableLiveData<Bill> billSelected = new MutableLiveData<>();

    public BillViewModel(@NonNull Application application){
        super(application);
        billRepo = new BillRepo(application);
    }

    public LiveData<List<Bill>> get(){ return billRepo.get(); }

    public LiveData<List<Bill>> getClientBills(int partnerId){ return billRepo.getClientBills(partnerId); }

    public void add(Bill bill) {
        billRepo.insert(bill);
    }

    void delete(Bill bill) {
        billRepo.delete(bill);
    }

    void update(Bill bill) {
        billRepo.update(bill);
    }

    void select(Bill bill) {
        billSelected.setValue(bill);
    }

    public MutableLiveData<Bill> selected() {
        return billSelected;
    }
}
