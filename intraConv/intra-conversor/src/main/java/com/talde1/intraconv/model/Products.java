package com.talde1.intraconv.model;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Product")
@XmlSeeAlso({Product.class})
public class Products {
    List<Product> product;

    public List<Product> getProducts() {
        return product;
    }

    public void setProducts(List<Product> products) {
        this.product = products;
    }
}
