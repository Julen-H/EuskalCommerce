package com.talde1.commerceapp.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.talde1.commerceapp.model.Product;

import java.util.List;

@Dao
public interface ProductDAO {

    @Query("SELECT * FROM product")
    LiveData<List<Product>> getProducts();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Product product);

    @Update
    void update(Product product);

    @Delete
    void delete(Product product);
}

