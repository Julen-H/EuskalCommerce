package com.talde1.intraconv.conversors;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import org.hibernate.exception.ConstraintViolationException;

import com.fasterxml.jackson.core.JsonParser;
import com.talde1.intraconv.App;
import com.talde1.intraconv.model.Client;
import com.talde1.intraconv.model.Clients;
import com.talde1.intraconv.model.Employee;
import com.talde1.intraconv.model.Employees;
import com.talde1.intraconv.model.Product;
import com.talde1.intraconv.model.Products;
import com.talde1.intraconv.model.User;
import com.talde1.intraconv.model.Users;

public class CsvConversor {
    
    private static String strFileOut;

    public static void convertClientsToCsv(List<Client> clients) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a name for the CSV file please: ");
        String fileName = sc.nextLine();
        fileName = "intra-conversor/data/" + fileName + ".csv";

        try{
            File convertedFile = new File(fileName);
            convertedFile.createNewFile();

            BufferedWriter outputStream = new BufferedWriter(new FileWriter(convertedFile, false));

            outputStream.write("id" + ";" + "client_name" + ";" + "phone" + ";" +
                    "email" + "\n");
            for (int i = 0; i < clients.size(); i++) {
                outputStream.write(clients.get(i).getId() + ";" + clients.get(i).getName() + ";" + clients.get(i).getPhone() + ";" +
                    clients.get(i).getEmail() + "\n");
            }
            outputStream.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void convertEmployeesToCsv(List<Employee> employees) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a name for the CSV file please: ");
        String fileName = sc.nextLine();
        fileName = "intra-conversor/data/" + fileName + ".csv";

        try{
            File convertedFile = new File(fileName);
            convertedFile.createNewFile();

            BufferedWriter outputStream = new BufferedWriter(new FileWriter(convertedFile, false));

            outputStream.write("id" + ";" +"employee_name" + ";" + "job_title" + ";" +
                    "work_phone" + ";" + "mobile_phone" + ";" + "employee_type" +
                    ";" + "department" + "\n");
            for (int i = 0; i < employees.size(); i++) {
                outputStream.write(employees.get(i).getId() + ";" + employees.get(i).getName() + ";" + employees.get(i).getJob_title() + ";" +
                    employees.get(i).getWork_phone() + ";" + employees.get(i).getMobile_phone() + ";" + employees.get(i).getEmployee_type() +
                    ";" + employees.get(i).getDepartment() + "\n");
            }
            outputStream.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void convertProductsToCsv(List<Product> products) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a name for the CSV file please: ");
        String fileName = sc.nextLine();
        fileName = "intra-conversor/data/" + fileName + ".csv";
        try{
            File convertedFile = new File(fileName);
            convertedFile.createNewFile();

            BufferedWriter outputStream = new BufferedWriter(new FileWriter(convertedFile, false));

            outputStream.write("id" + ";" + "product_name" + ";" + "product_price" + "\n");
            for (int i = 0; i < products.size(); i++) {
                outputStream.write(products.get(i).getId() + ";" + products.get(i).getProduct_name() + ";" + products.get(i).getProduct_price() + "\n");
            }
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void convertUsersToCsv(List<User> users) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a name for the CSV file please: ");
        String fileName = sc.nextLine();
        fileName = "intra-conversor/data/" + fileName + ".csv";

        try{
            File convertedFile = new File(fileName);
            convertedFile.createNewFile();

            BufferedWriter outputStream = new BufferedWriter(new FileWriter(convertedFile, false));
            outputStream.write("id;name;phone;login\n");

            for (int i = 0; i < users.size(); i++) {
                outputStream.append(users.get(i).getId() + ";" + users.get(i).getName() + ";" + 
                users.get(i).getPhone() + ";" + users.get(i).getEmail() +  users.get(i).getLogin() + "\n");
            }
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    //FILE READERS
    public static Clients readCsvFileClient(String fileName) throws FileNotFoundException{
        Clients clients = new Clients();
        List<Client> clientList = new ArrayList<>();

        String line = "";
        int count = 0;
        try(BufferedReader inputStream = new BufferedReader(new FileReader(fileName))){
            while((line = inputStream.readLine()) != null){
                if(count == 0){
                    count++;
                } else{
                    String[] clientStr = line.split(";");
                    Client client = new Client(Integer.parseInt(clientStr[0]), clientStr[1], clientStr[2], clientStr[3]);
                    clientList.add(client);
                    count++;
                }
            }
            clients.setClients(clientList);
        } catch (FileNotFoundException e) {
            System.out.println("\nWARNING: File not found. Please try again");
            App.openReadSubMenu();
        } catch(IOException e){
            e.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
        }
        return clients;
    }

    public static Products readCsvFileProducts(String fileName) throws FileNotFoundException{
        Products products = new Products();
        List<Product> productList = new ArrayList<>();

        String line = "";
        int count = 0;
        try(BufferedReader inputStream = new BufferedReader(new FileReader(fileName))){
            while((line = inputStream.readLine()) != null){
                if(count == 0){
                    count++;
                } else{
                    String[] productStr = line.split(";");
                    Product product = new Product(Integer.parseInt(productStr[0]), productStr[1], Float.parseFloat(productStr[2]));
                    productList.add(product);
                    count++;
                }
            }
                products.setProducts(productList);
        } catch (FileNotFoundException e) {
            System.out.println("\nWARNING: File not found. Please try again");
            App.openReadSubMenu();
        } catch(IOException e){
            e.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
        }
        return products;
    }

    public static Users readCsvFileUsers(String fileIn) throws FileNotFoundException{
        Users users = new Users();
        List<User> userList = new ArrayList<>();

        String line = "";
        int count = 0;
        try(BufferedReader inputStream = new BufferedReader(new FileReader(fileIn))){
            while ((line = inputStream.readLine()) != null) {
                if (count == 0) {
                    count++;
                } else{
                    String[] userStr = line.split(";");
                    User user = new User(Integer.parseInt(userStr[0]), userStr[1], userStr[2], userStr[3], userStr[4]);
                    userList.add(user);
                    count++;
                }
            }
            users.setUsers(userList);
        } catch (FileNotFoundException e) {
            System.out.println("\nWARNING: File not found. Please try again");
            App.openReadSubMenu();
        } catch(IOException e){
            e.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
        }
        return users;
    }

    public static Employees readCsvFileEmployees(String fileIn) throws FileNotFoundException{
        Employees employees = new Employees();
        List<Employee> employeesList = new ArrayList<>();

        String line = "";
        int count = 0;
        try(BufferedReader inputStream = new BufferedReader(new FileReader(fileIn))){
            while((line = inputStream.readLine()) != null){
                if (count == 0) {
                count++;
                } else{
                    String[] employeeStr = line.split(";");
                    Employee employee = new Employee(Integer.parseInt(employeeStr[0]), employeeStr[1], employeeStr[2], employeeStr[3], employeeStr[4], employeeStr[5], employeeStr[6]);
                    employeesList.add(employee);
                    count++;
                }
            }
            employees.setEmployees(employeesList);
        } catch (FileNotFoundException e) {
            System.out.println("\nWARNING: File not found. Please try again");
            App.openReadSubMenu();
        } catch(IOException e){
            e.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
        }
        return employees;
    }
}
