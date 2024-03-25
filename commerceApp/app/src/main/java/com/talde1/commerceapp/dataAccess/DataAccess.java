package com.talde1.commerceapp.dataAccess;



import com.talde1.commerceapp.model.Bill;
import com.talde1.commerceapp.model.Client;
import com.talde1.commerceapp.model.Product;
import com.talde1.commerceapp.viewmodel.ClientViewModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class DataAccess {

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
    private List<Client> clients = new ArrayList<>();
    private List<Product> products = new ArrayList<>();
    private List<Bill> bills = new ArrayList<>();
    ClientViewModel clientViewModel;
    private String clientEndpoint = "http://10.0.2.2:8000/Clients";
    private String productEndpoint = "http://10.0.2.2:8000/Products";
    private String billEndpoint = "http://10.0.2.2:8000/Bills";
    private String user="unai";
    private String password="com123";

    public void setClientEndpoint(String Ip){
    this.clientEndpoint="http://"+Ip+":8000/Clients";
}
    public void setProductEndpoint(String Ip){
        this.productEndpoint="http://"+Ip+":8000/Products";
    }
    public void setBillEndpoint(String Ip){
        this.billEndpoint="http://"+Ip+":8000/Bills";
    }
    public void setUser(String user){
    this.user = user;
}
    public void setPassword(String password){
        this.password = password;
    }

    public List<Client> clientData() throws IOException, JSONException {
        OkHttpClient client = new OkHttpClient();

        RequestBody formBody = new FormBody.Builder()
                .add("user", user)
                .add("password", password)
                .build();

        Request petition = new Request.Builder()
                .url(clientEndpoint)
                .post(formBody)
                .build();

        Response response = client.newCall(petition).execute();
        JSONArray jResponse = new JSONArray(response.body().string());
        if(jResponse != null && jResponse.length() > 0){
            for (int i = 0; i < jResponse.length(); i++){
                JSONObject jsonObj = jResponse.getJSONObject(i);
                int id = jsonObj.getInt("Id");
                String name = jsonObj.getString("Name");
                String email = jsonObj.getString("Email");
                String phone = jsonObj.getString("Phone");
                String mobile = jsonObj.getString("Mobile");
                String street = jsonObj.getString("Street");
                String postalCode = jsonObj.getString("PostalCode");
                String city = jsonObj.getString("City");

                Client inCLient = new Client(id, name, email, phone, mobile, street, postalCode, city);
                clients.add(inCLient);
            }
        }
        return clients;
    }

    public List<Bill> billData() throws IOException, JSONException {
        OkHttpClient client = new OkHttpClient();

        RequestBody formBody = new FormBody.Builder()
                .add("user", user)
                .add("password", password)
                .build();

        Request petition = new Request.Builder()
                .url(billEndpoint)
                .post(formBody)
                .build();

        Response response = client.newCall(petition).execute();
        JSONArray jResponse = new JSONArray(response.body().string());
        if(jResponse != null && jResponse.length() > 0){
            for (int i = 0; i < jResponse.length(); i++){
                JSONObject jsonObj = jResponse.getJSONObject(i);
                int id = jsonObj.getInt("Id");
                int partnerId = jsonObj.getInt("PartnerId");
                String billName = jsonObj.getString("BillName");
                String invoiceStatus = jsonObj.getString("InvoiceStatus");
                Double amountUnpaid = jsonObj.getDouble("AmountUnpaid");
                String deliveryStatus = jsonObj.getString("DeliveryStatus");
                LocalDateTime dateOrder = LocalDateTime.parse(jsonObj.getString("DateOrder"), formatter);
                Double amountUntaxed = jsonObj.getDouble("AmountUntaxed");
                Double amountTax = jsonObj.getDouble("AmountTax");
                String productName = jsonObj.getString("ProductName");
                Double qtyInvoiced = jsonObj.getDouble("QtyInvoiced");

                Bill inBill = new Bill(id, partnerId, billName, invoiceStatus, amountUnpaid, deliveryStatus, dateOrder, amountUntaxed, amountTax, productName, qtyInvoiced);
                bills.add(inBill);
            }
        }
        return bills;
    }

    public List<Product> productData() throws IOException, JSONException {
        OkHttpClient client = new OkHttpClient();

        RequestBody formBody = new FormBody.Builder()
                .add("user", user)
                .add("password", password)
                .build();

        Request petition = new Request.Builder()
                .url(productEndpoint)
                .post(formBody)
                .build();

        Response response = client.newCall(petition).execute();
        JSONArray jResponse = new JSONArray(response.body().string());
        if(jResponse != null && jResponse.length() > 0){
            for (int i = 0; i < jResponse.length(); i++){
                JSONObject jsonObj = jResponse.getJSONObject(i);
                String name = jsonObj.getString("Name");
                double price = jsonObj.getDouble("Price");
                int stock = jsonObj.getInt("Stock");
                int Id = jsonObj.getInt("Id");
                double saleDelay = jsonObj.getDouble("SaleDelay");

                Product inProduct = new Product(Id, stock, name, price, saleDelay);
                products.add(inProduct);
            }
        }
        return products;
    }
}
