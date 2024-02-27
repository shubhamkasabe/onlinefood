package com.online.helper;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
    
    public static Connection con;
    
    public static Connection getConnection() {
        try {
            if (con == null) {
                // Driver Class Load
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                // Create Connection
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinefood", "root", "root@123");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
