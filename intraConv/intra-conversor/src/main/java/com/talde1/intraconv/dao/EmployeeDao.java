package com.talde1.intraconv.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.talde1.intraconv.dbAccess.HibernateUtil;
import com.talde1.intraconv.model.Employee;
import com.talde1.intraconv.model.Employees;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import java.util.List;

public class EmployeeDao {

    public static List<Employee> getEmployees() {

        try (Session session = HibernateUtil.getCurrentSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
            criteria.from(Employee.class);
            List<Employee> data = session.createQuery(criteria).getResultList();
            return data;
        }
    }

    public static void saveEmployee(Employees employees) {
        try (Session session = HibernateUtil.getCurrentSession()) {
            for (int i = 0; i < employees.getEmployees().size(); i++) {
                Employee employee = employees.getEmployees().get(i);
                Transaction transaction = session.beginTransaction();
                session.persist(employee);
                transaction.commit();
            }

        }
    }

    public static void updateEmployee(Employee employee) {

        try (Session session = HibernateUtil.getCurrentSession()) {
            Transaction transaction = session.getTransaction();
            // employee.setName(employee.getName() + " has been updated.");
            session.merge(employee);
            transaction.commit();
        }
    }

    public static void deleteEmployee(Employee employee) {

        try (Session session = HibernateUtil.getCurrentSession()) {
            Transaction transaction = session.getTransaction();
            session.remove(employee);
            transaction.commit();
        }
    }
}
