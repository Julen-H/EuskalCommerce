package com.talde1.intraconv.conversors;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonStructure;
import javax.json.JsonWriter;

import com.talde1.intraconv.App;
import com.talde1.intraconv.model.Client;
import com.talde1.intraconv.model.Clients;
import com.talde1.intraconv.model.Employee;
import com.talde1.intraconv.model.Employees;
import com.talde1.intraconv.model.Product;
import com.talde1.intraconv.model.Products;
import com.talde1.intraconv.model.User;
import com.talde1.intraconv.model.Users;

public class JsonConversor {

    /*
    private String strFileIn;
    private String strFileOut;

    public JsonConversor(String fileIn) {
        this.strFileIn = "data/" + fileIn;
    }

    public JsonConversor(String fileIn, String fileOut) {
        this.strFileIn = "data/" + fileIn;
        this.strFileOut = "data/" + fileOut;
    }

    public void readFromFile() {
        JsonObject jObj = null;
        try {
            JsonReader reader = Json.createReader(new FileReader(strFileIn));
            JsonStructure jStructure = reader.read();
            JsonArray jArray = jStructure.asJsonArray();
            for (int i = 0; i > jArray.size(); i++) {
                jObj = jArray.getJsonObject(i);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    */
    
/*

    //Mendien lista bat eman(Mendiak objetu forman) eta json dokumentu bat eraiki.
    public int writeToFile(Mendiak mendiak) {
        int i = 0;
        List<Mendia> mendiakList = mendiak.getMendiak();
        Mendia mendia = null;
        JsonArray mendiakArray = null;
        JsonArrayBuilder builder = Json.createArrayBuilder();
        try {
            for (i = 0; i < mendiakList.size(); i++) {
                mendia = mendiakList.get(i);
                JsonObject model = Json.createObjectBuilder()
                        .add("id", mendia.getId())
                        .add("izena", mendia.getMendia())
                        .add("altuera", mendia.getAltuera())
                        .add("probintzia", mendia.getProbintzia())
                        .build();
                builder.add(model);
            }
            mendiakArray = builder.build();
            JsonWriter writer = Json.createWriter(new FileOutputStream(strFileOut));
            writer.writeArray(mendiakArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }
    */

    public static void convertClientsToJson(List<Client> clients) {
        
        Client client = null;
        JsonArray clientsArray = null;
        JsonArrayBuilder builder = Json.createArrayBuilder();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a name for the JSON file please: ");
        String fileName = sc.nextLine();
        fileName = "intra-conversor/data/" + fileName + ".json";

        try{
            for (int i = 0; i < clients.size(); i++) {
                client = clients.get(i);
                JsonObject model = Json.createObjectBuilder()
                    .add("id", client.getId())
                    .add("name", client.getName())
                    .add("phone", client.getPhone())
                    .add("email", client.getEmail())
                    .build();
                builder.add(model);
            }
            clientsArray = builder.build();
            JsonWriter writer = Json.createWriter(new FileOutputStream(fileName));
            writer.writeArray(clientsArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void convertEmployeesToJson(List<Employee> employees) {
        
        Employee employee = null;
        JsonArray employeesArray = null;
        JsonArrayBuilder builder = Json.createArrayBuilder();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a name for the JSON file please: ");
        String fileName = sc.nextLine();
        fileName = "intra-conversor/data/" + fileName + ".json";

        try{
            for (int i = 0; i < employees.size(); i++) {
                employee = employees.get(i);
                JsonObject model = Json.createObjectBuilder()
                    .add("id", employee.getId())
                    .add("name", employee.getName())
                    .add("job_title", employee.getJob_title())
                    .add("work_phone", employee.getWork_phone())
                    .add("mobile_phone", employee.getMobile_phone())
                    .add("employee_type", employee.getEmployee_type())
                    .add("department", employee.getDepartment())
                    .build();
                builder.add(model);
            }
            employeesArray = builder.build();
            JsonWriter writer = Json.createWriter(new FileOutputStream(fileName));
            writer.writeArray(employeesArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void convertProductsToJson(List<Product> products) {
        
        Product product = null;
        JsonArray productsArray = null;
        JsonArrayBuilder builder = Json.createArrayBuilder();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a name for the JSON file please: ");
        String fileName = sc.nextLine();
        fileName = "intra-conversor/data/" + fileName + ".json";

        try{
            for (int i = 0; i < products.size(); i++) {
                product = products.get(i);
                JsonObject model = Json.createObjectBuilder()
                    .add("id", product.getId())
                    .add("name", product.getProduct_name())
                    .add("product_price", product.getProduct_price())
                    .build();
                builder.add(model);
            }
            productsArray = builder.build();
            JsonWriter writer = Json.createWriter(new FileOutputStream(fileName));
            writer.writeArray(productsArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void convertUsersToJson(List<User> users) {
        
        User user = null;
        JsonArray usersArray = null;
        JsonArrayBuilder builder = Json.createArrayBuilder();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a name for the JSON file please: ");
        String fileName = sc.nextLine();
        fileName = "intra-conversor/data/" + fileName + ".json";

        try{
            for (int i = 0; i < users.size(); i++) {
                user = users.get(i);
                JsonObject model = Json.createObjectBuilder()
                    .add("id", user.getId())
                    .add("username", user.getName())
                    .add("phone", user.getPhone())
                    .add("email", user.getEmail())
                    .add("login", user.getLogin())
                    .build();
                builder.add(model);
            }
            usersArray = builder.build();
            JsonWriter writer = Json.createWriter(new FileOutputStream(fileName));
            writer.writeArray(usersArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }






    //READERS FOR JSON FILES
    public static Users readJsonUserFile(String fileIn) throws FileNotFoundException{
        Users users = new Users();
        List<User> userList = new ArrayList<>();
        JsonObject userJObj = null;
        try {
            JsonReader reader = Json.createReader(new FileReader(fileIn));
            JsonStructure jStruct = reader.read();
            JsonArray jArray = jStruct.asJsonArray();
            for(int i = 0; i < jArray.size(); i++){
                userJObj = jArray.getJsonObject(i);
                User user = new User(userJObj.getInt("id"), userJObj.getString("username"), userJObj.getString("phone"), userJObj.getString("email"), userJObj.getString("login"));
                userList.add(user);
            }
        } catch (FileNotFoundException e) {
            System.out.println("\nWARNING: File not found. Please try again");
            App.openReadSubMenu();
        } catch(Exception e){
            e.printStackTrace();
        }
        users.setUsers(userList);
        return users;
    }

    public static Clients readJsonClientFile(String fileIn) throws FileNotFoundException{
        Clients clients = new Clients();
        List<Client> clientList = new ArrayList<>();
        JsonObject clientJObj = null;
        try {
            JsonReader reader = Json.createReader(new FileReader(fileIn));
            JsonStructure jStruct = reader.read();
            JsonArray jArray = jStruct.asJsonArray();
            for(int i = 0; i < jArray.size(); i++){
                clientJObj = jArray.getJsonObject(i);
                Client client = new Client(clientJObj.getInt("id"), clientJObj.getString("name"), clientJObj.getString("phone"), clientJObj.getString("email"));
                clientList.add(client);
            }
        } catch (FileNotFoundException e) {
            System.out.println("\nWARNING: File not found. Please try again");
            App.openReadSubMenu();
        } catch(Exception e){
            e.printStackTrace();
        }
        clients.setClients(clientList);
        return clients;
    }

    public static Employees readJsonEmployeeFile(String fileIn) throws FileNotFoundException{
        Employees employees = new Employees();
        List<Employee> employeeList = new ArrayList<>();
        JsonObject employeeObj = null;
        try {
            JsonReader reader = Json.createReader(new FileReader(fileIn));
            JsonStructure jStruct = reader.read();
            JsonArray jArray = jStruct.asJsonArray();
            for(int i = 0; i < jArray.size(); i++){
                employeeObj = jArray.getJsonObject(i);
                Employee employee = new Employee(employeeObj.getInt("id"), employeeObj.getString("name"), employeeObj.getString("job_title"), employeeObj.getString("work_phone"), employeeObj.getString("mobile_phone"), employeeObj.getString("employee_type"), employeeObj.getString("department"));
                employeeList.add(employee);
            }
        } catch (FileNotFoundException e) {
            System.out.println("\nWARNING: File not found. Please try again");
            App.openReadSubMenu();
        } catch(Exception e){
            e.printStackTrace();
        }
        employees.setEmployees(employeeList);
        return employees;
    }

    public static Products readJsonProductFile(String fileIn) throws FileNotFoundException{
        Products products = new Products();
        List<Product> productList = new ArrayList<>();
        JsonObject productObj = null;
        try {
            JsonReader reader = Json.createReader(new FileReader(fileIn));
            JsonStructure jStruct = reader.read();
            JsonArray jArray = jStruct.asJsonArray();
            for(int i = 0; i < jArray.size(); i++){
                productObj = jArray.getJsonObject(i);
                JsonNumber price = productObj.getJsonNumber("product_price");
                double priceDouble = price.doubleValue();
                float priceFloat = (float) priceDouble;
                Product product = new Product(productObj.getInt("id"), productObj.getString("name"), priceFloat);
                productList.add(product);
            }
        } catch (FileNotFoundException e) {
            System.out.println("\nWARNING: File not found. Please try again");
            App.openReadSubMenu();
        } catch(Exception e){
            e.printStackTrace();
        }
        products.setProducts(productList);
        return products;
    }
}

