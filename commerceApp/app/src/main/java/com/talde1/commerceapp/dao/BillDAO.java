package com.talde1.commerceapp.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.talde1.commerceapp.model.Bill;

import java.util.List;

@Dao
public interface BillDAO {

    @Query("SELECT * FROM bill")
    LiveData<List<Bill>> getBills();

    @Query("SELECT * FROM bill WHERE partnerId = :partner")
    LiveData<List<Bill>> getClientBills(int partner);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Bill bill);

    @Update
    void update(Bill bill);

    @Delete
    void delete(Bill bill);
}
