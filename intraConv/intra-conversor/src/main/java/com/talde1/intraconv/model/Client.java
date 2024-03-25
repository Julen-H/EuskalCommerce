package com.talde1.intraconv.model;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@Table(name = "res_partner")
@DynamicUpdate
public class Client {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id; 
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;

    //tablas odoo: res_users, hr_employee, sale_order, sale_order_line_invoice, account_move_line, product_product, 
    // product_template, res_partners, hr_department
    public Client() {

    }
    
    public Client(int id, String name, String phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        if (this.name != null) {
            return name;
        } else{
            return "Null";
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        if (this.phone != null) {
            return phone;
        } else{
            return "Null";
        }
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        if (this.email != null) {
            return email;
        } else{
            return "Null";
        }
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + "]";
    }
}
