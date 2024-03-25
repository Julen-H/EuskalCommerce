package com.talde1.intraconv.conversors;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Scanner;

import com.talde1.intraconv.App;
import com.talde1.intraconv.model.Client;
import com.talde1.intraconv.model.Clients;
import com.talde1.intraconv.model.Employee;
import com.talde1.intraconv.model.Employees;
import com.talde1.intraconv.model.Product;
import com.talde1.intraconv.model.Products;
import com.talde1.intraconv.model.User;
import com.talde1.intraconv.model.Users;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class XmlConversor {

    // private String strFileIn;
    private static String strFileOut;

    /*
     * public XmlConversor(String fileIn){
     * this.strFileIn = "data/" + fileIn;
     * }
     * 
     * public XmlConversor(String FileIn, String FileOut){
     * this.strFileIn = "data/" + FileIn;
     * this.strFileOut = "data/" + FileOut;
     * }
     */

    /*
     * public Mendiak readFromFile(){
     * Mendiak mendiak = new Mendiak();
     * 
     * try{
     * File fileIn = new File(strFileIn);
     * JAXBContext jaxbContext = JAXBContext.newInstance(Mendiak.class);
     * 
     * Unmarshaller jaxbUnmar = jaxbContext.createUnmarshaller();
     * mendiak = (Mendiak) jaxbUnmar.unmarshal(fileIn);
     * 
     * } catch(Exception e){
     * e.printStackTrace();
     * }
     * return mendiak;
     * }
     * 
     * public int writeToFile(Mendiak mendiak){
     * try{
     * 
     * JAXBContext jaxbContext = JAXBContext.newInstance(Mendiak.class);
     * Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
     * 
     * new File(strFileOut);
     * OutputStream os = new FileOutputStream(strFileOut);
     * 
     * jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
     * 
     * jaxbMarshaller.marshal(mendiak, os);
     * 
     * } catch(Exception e){
     * e.printStackTrace();
     * }
     * return mendiak.getMendiak().size();
     * }
     */

    /* This function receives a list of clients and converts it to a XML file */
    public static void convertClientsToXml(List<Client> clients) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a name for the XML file please: ");
        String fileName = sc.nextLine();
        fileName = "intra-conversor/data/" + fileName + ".xml";

        Clients clientList = new Clients();
        clientList.setClients(clients);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Clients.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            new File(fileName);
            OutputStream os = new FileOutputStream(fileName);

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(clientList, os);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void convertProductsToXml(List<Product> products) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a name for the XML file please: ");
        String fileName = sc.nextLine();
        fileName = "intra-conversor/data/" + fileName + ".xml";

        Products productList = new Products();
        productList.setProducts(products);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Products.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            new File(fileName);
            OutputStream os = new FileOutputStream(fileName);

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(productList, os);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void convertEmployeesToXml(List<Employee> employees) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a name for the XML file please: ");
        String fileName = sc.nextLine();
        fileName = "intra-conversor/data/" + fileName + ".xml";

        Employees employeeList = new Employees();
        employeeList.setEmployees(employees);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            new File(fileName);
            OutputStream os = new FileOutputStream(fileName);

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(employeeList, os);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void convertUsersToXml(List<User> users) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a name for the XML file please: ");
        String fileName = sc.nextLine();
        fileName = "intra-conversor/data/" + fileName + ".xml";
        Users userList = new Users();
        userList.setUsers(users);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            new File(fileName);
            OutputStream os = new FileOutputStream(fileName);

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(userList, os);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // XML FILE READERS
    public static Clients readXmlClientFile(String fileIn) throws FileNotFoundException {
        Clients clients = new Clients();
        try {
            File file = new File(fileIn);
            JAXBContext jaxbContext = JAXBContext.newInstance(Clients.class);

            Unmarshaller jaxbUnmar = jaxbContext.createUnmarshaller();
            clients = (Clients) jaxbUnmar.unmarshal(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clients;
    }

    public static Products readXmlProductFile(String fileIn) throws FileNotFoundException {
        Products products = new Products();
        File file = new File(fileIn);
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Products.class);
            Unmarshaller jaxbUnmar = jaxbContext.createUnmarshaller();
            products = (Products) jaxbUnmar.unmarshal(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    public static Employees readXmlEmployeeFile(String fileIn) throws FileNotFoundException {
        Employees employees = new Employees();
        File file = new File(fileIn);
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
            Unmarshaller jaxbUnmar = jaxbContext.createUnmarshaller();
            employees = (Employees) jaxbUnmar.unmarshal(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employees;
    }

    public static Users readXmlUserFile(String fileIn) throws FileNotFoundException {
        Users users = new Users();
        File file = new File(fileIn);
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
            Unmarshaller jaxbUnmar = jaxbContext.createUnmarshaller();
            users = (Users) jaxbUnmar.unmarshal(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
}
