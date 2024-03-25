package com.talde1.intraconv.model;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Employees")
@XmlSeeAlso({Employee.class})
public class Employees {
    List<Employee> employee;

    public List<Employee> getEmployees() {
        return employee;
    }

    public void setEmployees(List<Employee> employees) {
        this.employee = employees;
    }
}
