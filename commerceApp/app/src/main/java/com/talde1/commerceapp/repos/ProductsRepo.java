package com.talde1.commerceapp.repos;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.talde1.commerceapp.dao.ClientDAO;
import com.talde1.commerceapp.dao.DBAccess;
import com.talde1.commerceapp.dao.ProductDAO;
import com.talde1.commerceapp.model.Client;
import com.talde1.commerceapp.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ProductsRepo {
    ProductDAO productDAO;

    Executor executor = Executors.newSingleThreadExecutor();


    public ProductsRepo(Application application){
        productDAO = DBAccess.obtainInstance(application).getProductDAO();
    }

    public LiveData<List<Product>> get(){ return productDAO.getProducts(); }

    public void insert(Product product) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                productDAO.insert(product);
            }
        });
    }

    public void delete(Product product) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                productDAO.delete(product);
            }
        });
    }

    public void update(Product product) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                productDAO.update(product);
            }
        });
    }
}
