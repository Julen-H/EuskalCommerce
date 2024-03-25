package com.talde1.intraconv.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.talde1.intraconv.dbAccess.HibernateUtil;
import com.talde1.intraconv.model.Client;
import com.talde1.intraconv.model.Clients;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import java.util.List;

public class ClientDao {

    public static List<Client> getClients() {

        try(Session session = HibernateUtil.getCurrentSession()) {

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Client> criteria = builder.createQuery(Client.class);
            criteria.from(Client.class);
            List<Client> data = session.createQuery(criteria).getResultList();
            return data;
        }
    }

    public static void saveClient(Clients clients) {

        try(Session session = HibernateUtil.getCurrentSession()) {
            for(int i = 0; i < clients.getClients().size(); i++){
                Client client = clients.getClients().get(i);
                Transaction transaction = session.beginTransaction();
                session.persist(client);
                transaction.commit();
            }
            
        }
    }

    public static void updateClient(Client client) {

        try(Session session = HibernateUtil.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            client.setName(client.getName());
            session.merge(client);
            transaction.commit();
        }
    }

    public static void deleteClient(Client client) {

        try(Session session = HibernateUtil.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(client);
            transaction.commit();
        }
    }
}
