package com.talde1.intraconv.dbAccess;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.talde1.intraconv.model.*;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static Session session;

    /*public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            try{
                Configuration config = new Configuration();

                Properties settings = new Properties();
                //settings.put(Environment.JAKARTA_JDBC_DRIVER, "com");
                settings.put(Environment.JAKARTA_JDBC_URL, "jdbc:postgresql://127.0.0.1:5432/JulenH");
                settings.put(Environment.JAKARTA_JDBC_USER, "julen");
                settings.put(Environment.JAKARTA_JDBC_PASSWORD, "Darkform");
                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                settings.put(Environment.HBM2DDL_AUTO, "create-drop");

                config.setProperties(settings);

                config.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(config.getProperties()).build();

                sessionFactory = config.buildSessionFactory(serviceRegistry);
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }*/

    public static SessionFactory buildSessionFactory() {

        Configuration configuration = new Configuration();
        configuration.configure();

        configuration.addAnnotatedClass(Client.class);
        configuration.addAnnotatedClass(Employee.class);
        configuration.addAnnotatedClass(Product.class);
        configuration.addAnnotatedClass(User.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        return sessionFactory;
    }

    public static Session openSession() {
        session = sessionFactory.openSession();
        return session;
    }

    public static Session getCurrentSession() {
        if ((session == null) || (!session.isOpen())){
            sessionFactory = buildSessionFactory();
            session = sessionFactory.openSession();
        } else{
            session = openSession();
        }
        return session;
    }

    public static void closeSessionFactory() {
    if (session != null)
        session.close();
    if (sessionFactory != null)
        sessionFactory.close();
    }

}
