package com.talde1.intraconv;

import java.io.FileNotFoundException;
import java.util.Scanner;

import org.hibernate.Hibernate;
import org.hibernate.exception.ConstraintViolationException;

import com.talde1.intraconv.conversors.*;
import com.talde1.intraconv.dao.*;
import com.talde1.intraconv.dbAccess.HibernateUtil;
import com.talde1.intraconv.model.Clients;
import com.talde1.intraconv.model.Employees;
import com.talde1.intraconv.model.Products;
import com.talde1.intraconv.model.Users;
import com.talde1.intraconv.modifiers.Modifiers;
import com.talde1.intraconv.webPageOpener.WebPageOpener;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        try {
            HibernateUtil.getCurrentSession();
            System.out.println("\n\nSuccess connecting to the database\n\n");
            openMainMenu();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An error ocurred, check the connection");
        }
    }

    public static void openMainMenu() {
        int selection = 0;
        Scanner in = new Scanner(System.in);

        System.out.println("");
        System.out.println("IntraConv Conversion Software 2023, \u00aEEuskal Commerce SL");
        System.out.println("---------------------------------------------------------");
        System.out.println("");
        System.out.println("                    EUSKAL COMMERCE");
        System.out.println("");
        System.out.println("                    |\\          /|");
        System.out.println("                    | \\        / |");
        System.out.println("                    |  \\      /  |");
        System.out.println("                    |   \\    /   |");
        System.out.println("                    |    \\  /    |");
        System.out.println("                    |     \\/     |");
        System.out.println("                    |            |");
        System.out.println("                    |____________|");
        System.out.println("");
        System.out.println("---------------------------------------------------------");
        System.out.println("WELCOME BACK! WHAT DO YOU WANT TO DO?");
        System.out.println("---------------------------------------------------------");
        System.out.println("1- Read data from file");
        System.out.println("2- Convert data to a file");
        System.out.println("3- Open Odoo");
        System.out.println("---------------------------------------------------------");
        System.out.println("Enter your selection: ");
        selection = in.nextInt();

        switch (selection) {
            case 1:
                openReadSubMenu();
                break;

            case 2:
                openConversorSubMenu();
                break;

            case 3:
                try {
                    Thread webOpener = new Thread(() -> {
                        try {
                            WebPageOpener.openWebPage();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
                    webOpener.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                openMainMenu();
                break;

            default:
                break;
        }
    }

    /* Conversors sub menu */
    public static void openConversorSubMenu() {

        Scanner z = new Scanner(System.in);
        Scanner sub = new Scanner(System.in);
        int subSelection = 0;
        String subSelect;

        do {

            System.out.println("");
            System.out.println("IntraConv Conversion Software 2023, \u00aEEuskal Commerce SL");
            System.out.println("---------------------------------------------------------");
            System.out.println("You have Selected CONVERT DATA TO A FILE");
            System.out.println();
            System.out.println("1- Convert to CSV");
            System.out.println("2- Convert to XML");
            System.out.println("3- Convert to JSON");
            System.out.println("4- Back to Main Menu");
            System.out.println("");
            System.out.println("---------------------------------------------------------");
            System.out.println("Enter your selection => ");
            subSelection = z.nextInt();

            switch (subSelection) {
                case 1:
                    System.out.println("");
                    System.out.println("You have selected CONVERT TO CSV");
                    System.out.println("---------------------------------------------------------");
                    System.out.println(
                            "Enter what type of data you want to convert (Users, Products, Employees or Clients)");
                    System.out.println("");
                    subSelect = sub.nextLine();

                    if (subSelect.equalsIgnoreCase("Users") || subSelect.equalsIgnoreCase("User")) {
                        CsvConversor.convertUsersToCsv(UserDao.getUsers());

                    } else if (subSelect.equalsIgnoreCase("Clients") || subSelect.equalsIgnoreCase("Client")) {
                        CsvConversor.convertClientsToCsv(ClientDao.getClients());

                    } else if (subSelect.equalsIgnoreCase("Products") || subSelect.equalsIgnoreCase("Product")) {
                        CsvConversor.convertProductsToCsv(ProductDao.getProducts());

                    } else if (subSelect.equalsIgnoreCase("Employees") || subSelect.equalsIgnoreCase("Employee")) {
                        CsvConversor.convertEmployeesToCsv(EmployeeDao.getEmployees());

                    } else {
                        System.out.println("It has occurred an error, please try again");
                    }

                    break;

                case 2:

                    System.out.println("");
                    System.out.println("You have selected CONVERT TO XML");
                    System.out.println("---------------------------------------------------------");
                    System.out.println(
                            "Enter what type of data you want to convert (Users, Products, Employees or Clients)");
                    System.out.println("");
                    subSelect = sub.nextLine();

                    if (subSelect.equalsIgnoreCase("User") || subSelect.equalsIgnoreCase("Users")) {
                        XmlConversor.convertUsersToXml(UserDao.getUsers());

                    } else if (subSelect.equalsIgnoreCase("Clients") || subSelect.equalsIgnoreCase("Client")) {
                        XmlConversor.convertClientsToXml(ClientDao.getClients());

                    } else if (subSelect.equalsIgnoreCase("Employees") || subSelect.equalsIgnoreCase("Employee")) {
                        XmlConversor.convertEmployeesToXml(EmployeeDao.getEmployees());

                    } else if (subSelect.equalsIgnoreCase("Products") || subSelect.equalsIgnoreCase("Product")) {
                        XmlConversor.convertProductsToXml(ProductDao.getProducts());

                    } else {
                        System.out.println("It has occurred an error, please try again");
                    }

                    break;

                case 3:

                    System.out.println("");
                    System.out.println("You have selected CONVERT TO JSON");
                    System.out.println("---------------------------------------------------------");
                    System.out.println(
                            "Enter what type of data you want to convert (Users, Products, Employees or Clients)");
                    System.out.println("");
                    subSelect = sub.nextLine();

                    if (subSelect.equalsIgnoreCase("Users") || subSelect.equalsIgnoreCase("User")) {
                        JsonConversor.convertUsersToJson(UserDao.getUsers());

                    } else if (subSelect.equalsIgnoreCase("Clients") || subSelect.equalsIgnoreCase("Client")) {
                        JsonConversor.convertClientsToJson(ClientDao.getClients());

                    } else if (subSelect.equalsIgnoreCase("Employees") || subSelect.equalsIgnoreCase("Employee")) {
                        JsonConversor.convertEmployeesToJson(EmployeeDao.getEmployees());

                    } else if (subSelect.equalsIgnoreCase("Products") || subSelect.equalsIgnoreCase("Product")) {
                        JsonConversor.convertProductsToJson(ProductDao.getProducts());
                    }

                    break;

                case 4:
                    openMainMenu();
                    break;
                default:
                    break;
            }
        } while (subSelection != 4);

    }

    /* Modify sub menu */
    public static void openReadSubMenu() {

        Scanner ex = new Scanner(System.in);
        int subSelection = 0;
        do {
            System.out.println("");
            System.out.println("IntraConv Conversion Software 2023, \u00aEEuskal Commerce SL");
            System.out.println("---------------------------------------------------------");
            System.out.println("You have Selected READ DATA FROM FILE");
            System.out.println();
            System.out.println("1- Read from CSV");
            System.out.println("2- Read from XML");
            System.out.println("3- Read from JSON");
            System.out.println("4- Back to Main Menu");
            System.out.println("");
            System.out.println("---------------------------------------------------------");
            System.out.println("Enter your selection => ");
            subSelection = ex.nextInt();

            switch (subSelection) {
                case 1:
                    String subSelect;
                    Scanner subSel = new Scanner(System.in);
                    System.out.println("");
                    System.out.println("You have selected READ FROM CSV");
                    System.out.println("---------------------------------------------------------");
                    System.out.println(
                            "Enter what type of data you want to insert (Users, Products, Employees or Clients)");
                    System.out.println("");
                    subSelect = subSel.nextLine();

                    if (subSelect.equalsIgnoreCase("Users") || subSelect.equalsIgnoreCase("User")) {
                        System.out.println("WARNING: THE FILE MUST BE LOCATED IN DIR AND BE SPELT CORRECTLY");
                        System.out.println("Enter the name of the file(without extension):");

                        Scanner fileScan = new Scanner(System.in);
                        String fileName = fileScan.nextLine();
                        fileName = "intra-conversor/data/" + fileName + ".csv";
                        try {
                            Users users = CsvConversor.readCsvFileUsers(fileName);

                            UserDao.saveUser(users);
                        } catch (ConstraintViolationException e) {
                            openReadSubMenu();
                        } catch (FileNotFoundException e) {
                            System.out.println("\nWARNING: File not found. Please try again");
                            openReadSubMenu();
                        }

                    } else if (subSelect.equalsIgnoreCase("Clients") || subSelect.equalsIgnoreCase("Client")) {
                        // TODO: cambiar DIR por el directorio donde vamos a leer.
                        System.out.println("WARNING: THE FILE MUST BE LOCATED IN DIR AND BE SPELT CORRECTLY");
                        System.out.println("Enter the name of the file(without extension):");

                        Scanner fileScan = new Scanner(System.in);
                        String fileName = fileScan.nextLine();
                        fileName = "intra-conversor/data/" + fileName + ".csv";
                        try {
                            Clients clientList = CsvConversor.readCsvFileClient(fileName);

                            ClientDao.saveClient(clientList);
                        } catch (ConstraintViolationException e) {
                            openReadSubMenu();
                        } catch (FileNotFoundException e) {
                            System.out.println("\nWARNING: File not found. Please try again");
                            openReadSubMenu();
                        }

                    } else if (subSelect.equalsIgnoreCase("Employees") || subSelect.equalsIgnoreCase("Employee")) {
                        // TODO: cambiar DIR por el directorio donde vamos a leer.
                        System.out.println("WARNING: THE FILE MUST BE LOCATED IN DIR AND BE SPELT CORRECTLY");
                        System.out.println("Enter the name of the file(without extension):");

                        Scanner fileScan = new Scanner(System.in);
                        String fileName = fileScan.nextLine();
                        fileName = "intra-conversor/data/" + fileName + ".csv";
                        try {
                            Employees employees = CsvConversor.readCsvFileEmployees(fileName);

                            EmployeeDao.saveEmployee(employees);
                        } catch (ConstraintViolationException e) {
                            // TODO: handle exception
                            openReadSubMenu();
                        } catch (FileNotFoundException e) {
                            System.out.println("\nWARNING: File not found. Please try again");
                            openReadSubMenu();
                        }

                    } else if (subSelect.equalsIgnoreCase("Products") || subSelect.equalsIgnoreCase("Product")) {
                        // TODO: cambiar DIR por el directorio donde vamos a leer.
                        System.out.println("WARNING: THE FILE MUST BE LOCATED IN DIR AND BE SPELT CORRECTLY");
                        System.out.println("Enter the name of the file(without extension):");

                        Scanner fileScan = new Scanner(System.in);
                        String fileName = fileScan.nextLine();
                        fileName = "intra-conversor/data/" + fileName + ".csv";
                        try {
                            Products productList = CsvConversor.readCsvFileProducts(fileName);

                            ProductDao.saveProduct(productList);
                        } catch (ConstraintViolationException e) {
                            openReadSubMenu();
                        } catch (FileNotFoundException e) {
                            System.out.println("\nWARNING: File not found. Please try again");
                            openReadSubMenu();
                        }

                    }
                    break;
                case 2:
                    String subSelectXml;
                    Scanner subSelXml = new Scanner(System.in);
                    System.out.println("");
                    System.out.println("You have selected READ FROM XML");
                    System.out.println("---------------------------------------------------------");
                    System.out.println(
                            "Enter what type of data you want to insert (Users, Products, Employees or Clients)");
                    System.out.println("");
                    subSelectXml = subSelXml.nextLine();

                    if (subSelectXml.equalsIgnoreCase("Client") || subSelectXml.equalsIgnoreCase("Clients")) {
                        System.out.println("WARNING: THE FILE MUST BE LOCATED IN DIR AND BE SPELT CORRECTLY");
                        System.out.println("Enter the name of the file(without extension):");

                        Scanner fileScan = new Scanner(System.in);
                        String fileName = fileScan.nextLine();
                        fileName = "intra-conversor/data/" + fileName + ".xml";
                        try {
                            Clients clients = XmlConversor.readXmlClientFile(fileName);

                            ClientDao.saveClient(clients);
                        } catch (ConstraintViolationException e) {
                            openReadSubMenu();
                        } catch (FileNotFoundException e) {
                            System.out.println("\nWARNING: File not found. Please try again");
                            openReadSubMenu();
                        }

                    } else if (subSelectXml.equalsIgnoreCase("User") || subSelectXml.equalsIgnoreCase("Users")) {
                        // TODO: cambiar DIR por el directorio donde vamos a leer.
                        System.out.println("WARNING: THE FILE MUST BE LOCATED IN DIR AND BE SPELT CORRECTLY");
                        System.out.println("Enter the name of the file(without extension):");

                        Scanner fileScan = new Scanner(System.in);
                        String fileName = fileScan.nextLine();
                        fileName = "intra-conversor/data/" + fileName + ".xml";
                        try {
                            Users userList = XmlConversor.readXmlUserFile(fileName);

                            UserDao.saveUser(userList);
                        } catch (ConstraintViolationException e) {
                            openReadSubMenu();
                        } catch (FileNotFoundException e) {
                            System.out.println("\nWARNING: File not found. Please try again");
                            openReadSubMenu();
                        }

                    } else if (subSelectXml.equalsIgnoreCase("Employees")
                            || subSelectXml.equalsIgnoreCase("Employee")) {
                        // TODO: cambiar DIR por el directorio donde vamos a leer.
                        System.out.println("WARNING: THE FILE MUST BE LOCATED IN DIR AND BE SPELT CORRECTLY");
                        System.out.println("Enter the name of the file(without extension):");

                        Scanner fileScan = new Scanner(System.in);
                        String fileName = fileScan.nextLine();
                        fileName = "intra-conversor/data/" + fileName + ".xml";
                        try {
                            Employees employees = XmlConversor.readXmlEmployeeFile(fileName);

                            EmployeeDao.saveEmployee(employees);
                        } catch (ConstraintViolationException e) {
                            // TODO: handle exception
                            openReadSubMenu();
                        } catch (FileNotFoundException e) {
                            System.out.println("\nWARNING: File not found. Please try again");
                            openReadSubMenu();
                        }

                    } else if (subSelectXml.equalsIgnoreCase("Products") || subSelectXml.equalsIgnoreCase("Product")) {
                        // TODO: cambiar DIR por el directorio donde vamos a leer.
                        System.out.println("WARNING: THE FILE MUST BE LOCATED IN DIR AND BE SPELT CORRECTLY");
                        System.out.println("Enter the name of the file(without extension):");

                        Scanner fileScan = new Scanner(System.in);
                        String fileName = fileScan.nextLine();
                        fileName = "intra-conversor/data/" + fileName + ".xml";
                        try {
                            Products productList = XmlConversor.readXmlProductFile(fileName);

                            ProductDao.saveProduct(productList);
                        } catch (ConstraintViolationException e) {
                            openReadSubMenu();
                        } catch (FileNotFoundException e) {
                            System.out.println("\nWARNING: File not found. Please try again");
                            openReadSubMenu();
                        }

                    }
                    break;

                case 3:
                    String subSelectJson;
                    Scanner subSelJson = new Scanner(System.in);
                    System.out.println("");
                    System.out.println("You have selected READ FROM JSON");
                    System.out.println("---------------------------------------------------------");
                    System.out.println(
                            "Enter what type of data you want to insert (Users, Products, Employees or Clients)");
                    System.out.println("");
                    subSelectJson = subSelJson.nextLine();

                    if (subSelectJson.equalsIgnoreCase("Client") || subSelectJson.equalsIgnoreCase("Clients")) {
                        System.out.println("WARNING: THE FILE MUST BE LOCATED IN DIR AND BE SPELT CORRECTLY");
                        System.out.println("Enter the name of the file(without extension):");

                        Scanner fileScan = new Scanner(System.in);
                        String fileName = fileScan.nextLine();
                        fileName = "intra-conversor/data/" + fileName + ".json";
                        try {
                            Clients clients = JsonConversor.readJsonClientFile(fileName);

                            ClientDao.saveClient(clients);
                        } catch (ConstraintViolationException e) {
                            openReadSubMenu();
                        } catch (FileNotFoundException e) {
                            System.out.println("\nWARNING: File not found. Please try again");
                            openReadSubMenu();
                        }

                    } else if (subSelectJson.equalsIgnoreCase("User") || subSelectJson.equalsIgnoreCase("Users")) {
                        // TODO: cambiar DIR por el directorio donde vamos a leer.
                        System.out.println("WARNING: THE FILE MUST BE LOCATED IN DIR AND BE SPELT CORRECTLY");
                        System.out.println("Enter the name of the file(without extension):");

                        Scanner fileScan = new Scanner(System.in);
                        String fileName = fileScan.nextLine();
                        fileName = "intra-conversor/data/" + fileName + ".json";
                        try {
                            Users userList = JsonConversor.readJsonUserFile(fileName);

                            UserDao.saveUser(userList);
                        } catch (ConstraintViolationException e) {
                            openReadSubMenu();
                        } catch (FileNotFoundException e) {
                            System.out.println("\nWARNING: File not found. Please try again");
                            openReadSubMenu();
                        }

                    } else if (subSelectJson.equalsIgnoreCase("Employees")
                            || subSelectJson.equalsIgnoreCase("Employee")) {
                        // TODO: cambiar DIR por el directorio donde vamos a leer.
                        System.out.println("WARNING: THE FILE MUST BE LOCATED IN DIR AND BE SPELT CORRECTLY");
                        System.out.println("Enter the name of the file(without extension):");

                        Scanner fileScan = new Scanner(System.in);
                        String fileName = fileScan.nextLine();
                        fileName = "intra-conversor/data/" + fileName + ".json";
                        try {
                            Employees employees = JsonConversor.readJsonEmployeeFile(fileName);

                            EmployeeDao.saveEmployee(employees);
                        } catch (ConstraintViolationException e) {
                            // TODO: handle exception
                            openReadSubMenu();
                        } catch (FileNotFoundException e) {
                            System.out.println("\nWARNING: File not found. Please try again");
                            openReadSubMenu();
                        }

                    } else if (subSelectJson.equalsIgnoreCase("Products")
                            || subSelectJson.equalsIgnoreCase("Product")) {
                        // TODO: cambiar DIR por el directorio donde vamos a leer.
                        System.out.println("WARNING: THE FILE MUST BE LOCATED IN DIR AND BE SPELT CORRECTLY");
                        System.out.println("Enter the name of the file(without extension):");

                        Scanner fileScan = new Scanner(System.in);
                        String fileName = fileScan.nextLine();
                        fileName = "intra-conversor/data/" + fileName + ".json";
                        try {
                            Products productList = JsonConversor.readJsonProductFile(fileName);
                            ProductDao.saveProduct(productList);
                        } catch (ConstraintViolationException e) {
                            openReadSubMenu();
                        } catch (FileNotFoundException e) {
                            System.out.println("\nWARNING: File not found. Please try again");
                            openReadSubMenu();
                        }

                    }
                    break;

                case 4:
                    openMainMenu();
                    break;

                default:
                    break;
            }
        } while (subSelection != 5);
        ex.close();
    }
}
