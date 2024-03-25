package com.talde1.commerceapp.repos;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.talde1.commerceapp.dao.BillDAO;
import com.talde1.commerceapp.dao.DBAccess;
import com.talde1.commerceapp.model.Bill;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class BillRepo {

    BillDAO billDAO;

    Executor executor = Executors.newSingleThreadExecutor();

    public BillRepo(Application application) {
        billDAO = DBAccess.obtainInstance(application).getBillDAO();
    }

    public LiveData<List<Bill>> get() {
        return billDAO.getBills();
    }

    public LiveData<List<Bill>> getClientBills(int position){
        return billDAO.getClientBills(position);
    }

    public void insert(Bill bill) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                billDAO.insert(bill);
            }
        });
    }

    public void delete(Bill bill) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                billDAO.delete(bill);
            }
        });
    }

    public void update(Bill bill) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                billDAO.update(bill);
            }
        });
    }
}
