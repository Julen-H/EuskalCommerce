package com.talde1.intraconv.dbAccess;

import java.util.Properties;
import java.sql.*;

public class DbCon {
    public static String url = "jdbc:postgresql://192.168.122.14:5432/odoodb";
    
    public static Connection connect(){
        Connection con = null;
        Properties props = new Properties();
        props.setProperty("user", "odoo");
        props.setProperty("password", "123");
        props.setProperty("ssl", "false");

        try{
            con = DriverManager.getConnection(DbCon.url, props);
        } catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
