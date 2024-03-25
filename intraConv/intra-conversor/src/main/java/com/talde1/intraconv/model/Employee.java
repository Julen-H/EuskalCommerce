package com.talde1.intraconv.model;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
@Entity
@Table(name = "hr_employee")
@XmlAccessorType(XmlAccessType.FIELD)
@DynamicUpdate
public class Employee {
    @Id
    @Column(name = "Id")
    private int id;

    @Column(name = "resource_id")
    int resource_id = 1;

    @Column(name = "company_id")
    int company_id = 1;

    @Column(name = "name")
    private String name;

    @Column(name = "job_title")
    private String job_title;

    @Column(name = "work_phone")
    private String work_phone;

    @Column(name = "mobile_phone")
    private String mobile_phone;

    @Column(name = "employee_type")
    private String employee_type;

    /*@Column(name = "create_date")
    private Date create_date;*/

    @Column(name = "department")
    private String department;

    public Employee() {

    }
    
    public Employee(int id, String name, String job_title, String work_phone, String mobile_phone, String employee_type,
            String department) {
        this.id = id;
        this.name = name;
        this.job_title = job_title;
        this.work_phone = work_phone;
        this.mobile_phone = mobile_phone;
        this.employee_type = employee_type;
        //this.create_date = create_date;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        if(this.name != null){
            return name;
        } else{
            return "Null";
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob_title() {
        if(this.job_title != null){
            return job_title;
        } else{
            return "Null";
        }
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public String getWork_phone() {
        if(this.work_phone != null){
            return work_phone;
        } else{
            return "Null";
        }
    }

    public void setWork_phone(String work_phone) {
        this.work_phone = work_phone;
    }

    public String getMobile_phone() {
        if(this.mobile_phone != null){
            return mobile_phone;
        } else{
            return "Null";
        }
    }

    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    public String getEmployee_type() {
        if(this.employee_type != null){
            return employee_type;
        } else{
            return "Null";
        }
    }

    public void setEmployee_type(String employee_type) {
        this.employee_type = employee_type;
    }

    /*public Date getCreate_date() {
        return create_date;
    }*/

    /*public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }*/

    public String getDepartment() {
        if(this.department != null){
            return department;
        } else{
            return "Null";
        }
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", job_title=" + job_title + ", work_phone=" + work_phone
                + ", mobile_phone=" + mobile_phone + ", employee_type=" + employee_type + ", department=" + department + "]";
    }
}
