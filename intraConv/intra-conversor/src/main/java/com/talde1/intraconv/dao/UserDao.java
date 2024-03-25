package com.talde1.intraconv.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.postgresql.core.NativeQuery;

import com.talde1.intraconv.dbAccess.HibernateUtil;
import com.talde1.intraconv.model.User;
import com.talde1.intraconv.model.Users;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import java.util.List;

public class UserDao {

    public static List<User> getUsers() {

        try(Session session = HibernateUtil.getCurrentSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<User> criteria = builder.createQuery(User.class);
            criteria.from(User.class);
            List<User> data = session.createQuery(criteria).getResultList();
            return data;
        } 
    }

    public static void saveUser(Users users) {

        try(Session session = HibernateUtil.getCurrentSession()) {
            for(int i = 0; i < users.getUsers().size(); i++){
                User user = users.getUsers().get(i);
                Transaction transaction = session.beginTransaction();
                session.persist(user);
                transaction.commit();
            }
            
        }
    }

    public static void updateUser(User user) {

        try(Session session = HibernateUtil.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            //user.setName(user.getName() + " has been updated.");
            session.merge(user);
            transaction.commit();
        }
    }

    public static void deleteUser(User user) {
        try(Session session = HibernateUtil.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(user);
            transaction.commit();
        }
    }
}
