package com.talde1.intraconv.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.talde1.intraconv.dbAccess.HibernateUtil;
import com.talde1.intraconv.model.Product;
import com.talde1.intraconv.model.Products;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import java.util.List;

public class ProductDao {

    public static List<Product> getProducts() {

        try (Session session = HibernateUtil.getCurrentSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Product> criteria = builder.createQuery(Product.class);
            criteria.from(Product.class);
            List<Product> data = session.createQuery(criteria).getResultList();
            return data;
        }
    }

    public static void saveProduct(Products products) {

        try (Session session = HibernateUtil.getCurrentSession()) {
            for (int i = 0; i < products.getProducts().size(); i++) {
                Product product = products.getProducts().get(i);
                Transaction transaction = session.beginTransaction();
                session.persist(product);
                transaction.commit();
            }

        }
    }

    public static void updateProduct(Product product) {

        try (Session session = HibernateUtil.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            // product.setProduct_name(product.getProduct_name() + " has been updated.");
            // product.setProduct_name((product.getProduct_name()).toString() + " has been
            // updated");
            session.merge(product);
            transaction.commit();
        }
    }

    public static void deleteProduct(Product product) {

        try (Session session = HibernateUtil.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(product);
            transaction.commit();
        }
    }
}
