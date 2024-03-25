package com.talde1.intraconv.model;

import java.util.List;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Users")
@XmlSeeAlso({User.class})
public class Users {
    List<User> user;

    public void setUsers(List<User> user){
        this.user = user;
    }

    public List<User> getUsers() {
        return this.user;
    }
}
