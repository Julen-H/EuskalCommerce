package com.talde1.intraconv.model;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Clients")
@XmlSeeAlso({User.class})
public class Clients {
    List<Client> client;

    public List<Client> getClients() {
        return client;
    }

    public void setClients(List<Client> clients) {
        this.client = clients;
    }
}
