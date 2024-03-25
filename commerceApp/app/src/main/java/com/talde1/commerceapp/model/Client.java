package com.talde1.commerceapp.model;


import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "client", indices = @Index(value = {"id"}, unique = true))
public class Client {

    @PrimaryKey(autoGenerate = false)
int id;
String name;
String surname;
String email;
String telephone;
String mobile;
float payedAmount;
String street;
String postalCode;
String city;
int billNum;


    public Client(int id, String name, String surname, String email, String telephone, float payedAmount, int billNum, String street, String postalCode, String city) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.telephone = telephone;
        this.payedAmount = payedAmount;
        this.billNum = billNum;
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
    }

    public Client(int id, String name, String email, String phone, String mobile, String street, String postalCode, String city) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.telephone = phone;
        this.mobile = mobile;
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public float getPayedAmount() {
        return payedAmount;
    }

    public void setPayedAmount(float payedAmount) {
        this.payedAmount = payedAmount;
    }

    public int getBillNum() {
        return billNum;
    }

    public void setBillNum(int billNum) {
        this.billNum = billNum;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", payedAmount=" + payedAmount +
                ", billNum=" + billNum +
                '}';
    }
}
