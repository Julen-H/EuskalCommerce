package com.talde1.commerceapp.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.talde1.commerceapp.model.Bill;
import com.talde1.commerceapp.model.Client;

import java.util.List;

@Dao
public interface ClientDAO {

    @Query("SELECT * FROM client")
    LiveData<List<Client>> getClients();

    @Query("SELECT * FROM bill WHERE partnerId = :partner AND amountUnpaid != 0.00")
    LiveData<List<Bill>> getClientUnpaidBills(int partner);

    @Query("SELECT * FROM bill WHERE partnerId = :partner AND deliveryStatus != 'full'")
    LiveData<List<Bill>> getClientUnsentBills(int partner);

    @Query("SELECT * FROM client WHERE id = :clientId")
    Client detailClient(int clientId);
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Client client);

    @Update
    void update(Client client);

    @Delete
    void delete(Client client);
}
