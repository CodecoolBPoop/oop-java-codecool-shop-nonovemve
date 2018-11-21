package com.codecool.shop.dao.DBConnection;


import java.sql.*;
import java.util.logging.Logger;

public class DB {

    private static final String DATABASE = "jdbc:postgresql://localhost:5432/codecoolshop";
    private static final String DB_USER = System.getProperty("codecoolshopdb.user");
    private static final String DB_PASSWORD = System.getProperty("codecoolshopdb.pw");

    private Connection connection = null;
    private Statement createStatement = null;

    public DB() {
    }

    public void openConnection(){
        try {
            connection = DriverManager.getConnection(DATABASE,DB_USER,DB_PASSWORD);
            System.out.println("The gate is open and connected to:" + DATABASE);
            createStatement = connection.createStatement();

        }catch (SQLException ex){
            System.out.println("Database probleme:" + ex);
        }
    }

    public Connection getConnection(){
        return connection;
    }


    public void closeConnection(){
        try {
            connection.close();
            System.out.println("The gate is closed");
        }catch (SQLException ex){
            System.out.println("Database probleme:" + ex);
        }
    }

}