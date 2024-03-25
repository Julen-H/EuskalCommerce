package com.talde1.intraconv.modifiers;

import java.util.List;
import java.util.Scanner;

import com.talde1.intraconv.model.Client;
import com.talde1.intraconv.model.Employee;
import com.talde1.intraconv.model.Product;
import com.talde1.intraconv.model.User;

public class Modifiers {

    private static int selection = 0;
    
    public static User modifyAUser(List<User> users) {

        Scanner us = new Scanner(System.in);
        User user = null;
        
        int newId;
        String newName, newPhone, newEmail; 
        System.out.println("");
        System.out.println("You have selected MODIFY A client");
        System.out.println("---------------------------------------------------------");

        for (int i = 1; i < users.size(); i++) {
            System.out.println(i + "- " + users.get(i));
        }

        System.out.print("Enter which client you want to modify: ");
        selection = us.nextInt();
        System.out.println("");

        try{
        for (int i = 1; i < users.size(); i++) {
            if (i == selection) {
                user = users.get(i);
                System.out.print("Enter a new id: ");
                newId = us.nextInt();
                System.out.println("Enter a new clientname: ");
                us.nextLine();
                newName = us.nextLine();
                System.out.println("Enter a new phone: ");
                newPhone = us.nextLine();
                System.out.println("Enter a new email: ");
                newEmail = us.nextLine();
                user.setId(newId);
                user.setName(newName);
                user.setPhone(newPhone);
            }
        }
    } catch(Exception e){
        e.printStackTrace();
    }
    return user;
    }

    public static Client modifyAClient(List<Client> clients) {

        Scanner cl = new Scanner(System.in);
        Client client = null;

        int newId;
        String newName, newPhone, newEmail;
        System.out.println("");
        System.out.println("You have selected MODIFY A CLIENT");
        System.out.println("---------------------------------------------------------");

        for (int i = 1; i < clients.size(); i++) {
            System.out.println(i + "- " + clients.get(i));
        }

        System.out.print("Enter which client you want to modify: ");
        selection = cl.nextInt();
        System.out.println();

        for (int i = 1; i < clients.size(); i++) {
            if (i == selection) {
                client = clients.get(i);
                System.out.print("Enter a new id: ");
                newId = cl.nextInt();
                System.out.println("Enter a new clientname: ");
                cl.nextLine();
                newName = cl.nextLine();
                System.out.println("Enter a new phone: ");
                newPhone = cl.nextLine();
                System.out.println("Enter a new email: ");
                newEmail = cl.nextLine();
                client.setId(newId);
                client.setName(newName);
                client.setPhone(newPhone);
                client.setEmail(newEmail);
            }
        }
        return client;
    }

    public static Employee modifyAEmployee(List<Employee> employees) {

        Scanner em = new Scanner(System.in);
        Employee employee = null;

        int newId;
        String newName, newJobTitle, newWorkPhone, newMobilePhone, newEmployeeType, newDepartment;

        System.out.println("");
        System.out.println("You have selected MODIFY A EMPLOYEE");
        System.out.println("---------------------------------------------------------");

        for (int i = 1; i < employees.size(); i++) {
            System.out.println(i + "- " + employees.get(i));
        }

        System.out.print("Enter which employee you want to modify: ");
        selection = em.nextInt();
        System.out.println();

        for (int i = 1; i < employees.size(); i++) {
            if (i == selection) {
                employee = employees.get(i);
                System.out.println("Enter a new Id: ");
                newId = em.nextInt();
                System.out.println("Enter a new Name: ");
                em.nextLine();
                newName = em.nextLine();
                System.out.println("Enter a new Job Title: ");
                newJobTitle = em.nextLine();
                System.out.println("Enter a new Work Phone: ");
                newWorkPhone = em.nextLine();
                System.out.println("Enter a new Mobile Phone: ");
                newMobilePhone = em.nextLine();
                System.out.println("Enter a new Employee Type: ");
                newEmployeeType = em.nextLine();
                System.out.println("Enter a new Department: ");
                newDepartment = em.nextLine();

                employee.setId(newId);
                employee.setName(newName);
                employee.setJob_title(newJobTitle);
                employee.setWork_phone(newWorkPhone);
                employee.setMobile_phone(newMobilePhone);
                employee.setEmployee_type(newEmployeeType);
                employee.setDepartment(newDepartment);
            }
        }
        return employee;
    }

    public static Product modifyAProduct(List<Product> products) {

        Scanner pr = new Scanner(System.in);
        Product product = null;

        int newId;
        String newEngName, newEspName;
        float newPrice;

        System.out.println("");
        System.out.println("You have selected MODIFY A PRODUCT");
        System.out.println("---------------------------------------------------------");

        for (int i = 1; i < products.size(); i++) {
            product = products.get(i);
            System.out.println(i + "- " + product.toString());
        }

        System.out.print("Enter which client you want to modify: ");
        selection = pr.nextInt();
        System.out.println();

        for (int i = 1; i < products.size(); i++) {
            if (i == selection) {
                product = products.get(i);
                System.out.print("Enter a new id: ");
                newId = pr.nextInt();
                System.out.println("Enter a new spanish name: ");
                pr.nextLine();
                newEspName = pr.nextLine();
                System.out.println("Enter a new english name: ");
                newEngName = pr.nextLine();
                System.out.println("Enter a new price: ");
                newPrice = pr.nextFloat();
                product.setId(newId);
                product.setNameEnglish(newEngName);
                product.setNameSpanish(newEspName);
                product.setProduct_price(newPrice);
                /* 
                String[] names = new String[2];
                names[0] = newEngName;
                names[1] = newEspName;
                product.setProductName(names);
                */
            }
        }
        return product;

    }
}
