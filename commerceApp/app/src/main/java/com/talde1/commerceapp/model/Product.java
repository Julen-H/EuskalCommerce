package com.talde1.commerceapp.model;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "product", indices = @Index(value = {"id"}, unique = true))
public class Product {

    @PrimaryKey(autoGenerate = false)
int id;
int stock;
String name;
double sale_price;
double sale_delay;

    public Product(int id, int stock, String name, double sale_price, double sale_delay) {
        this.id = id;
        this.stock = stock;
        this.name = name;
        this.sale_price = sale_price;
        this.sale_delay = sale_delay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public double getSale_price() {
        return sale_price;
    }

    public void setSale_price(float sale_price) {
        this.sale_price = sale_price;
    }

    public void setSale_price(double sale_price) {
        this.sale_price = sale_price;
    }

    public double getSale_delay() {
        return sale_delay;
    }

    public void setSale_delay(float sale_delay) {
        this.sale_delay = sale_delay;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", stock=" + stock +
                ", name='" + name + '\'' +
                ", sale_price=" + sale_price +
                '}';
    }
}
