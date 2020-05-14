package edu.miu.cs.cs544.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cs544", "ea", "ea123");

        } catch (Exception e) {

            System.out.println(e);
        }
        return con;
    }

}
