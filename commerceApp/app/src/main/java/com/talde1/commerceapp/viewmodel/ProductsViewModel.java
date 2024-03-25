package com.talde1.commerceapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.talde1.commerceapp.model.Product;

import com.talde1.commerceapp.repos.ProductsRepo;

import java.util.List;

public class ProductsViewModel extends AndroidViewModel {
    ProductsRepo productsRepo;
    //MutableLiveData<List<Client>> listClientsMutableLiveData = new MutableLiveData<>();
    MutableLiveData<Product> productSelected = new MutableLiveData<>();

    public ProductsViewModel(@NonNull Application application){
        super(application);
        productsRepo = new ProductsRepo(application);
    }

    public LiveData<List<Product>> get(){ return productsRepo.get(); }

    public void add(Product product) {
        productsRepo.insert(product);
    }

    void delete(Product product) {
        productsRepo.delete(product);
    }

    void update(Product product) {
        productsRepo.update(product);
    }

    void select(Product product) {
        productSelected.setValue(product);
    }

    MutableLiveData<Product> selected() {
        return productSelected;
    }
}