package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.DBConnection.DB;
import com.codecool.shop.model.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDaoJDBC {
    private static UserDaoJDBC instance = null;
    private DB db = new DB();
    private boolean DEBUG = false;

    public UserDaoJDBC() {
    }

    public static UserDaoJDBC getInstance() {
        if (instance == null) {
            instance = new UserDaoJDBC();
        }
        return instance;
    }

    public void add(User details) {
        db.openConnection();
        if (DEBUG) {
            System.out.println("Details check");
            System.out.println("id: " + details.getNextId());
            System.out.println("username: " + details.getUserName());
            System.out.println("email: " + details.getEmail());
            System.out.println("password: " + details.getPassword());
            System.out.println("mobile: " + details.getMobile());
            System.out.println("billing: " + details.getBilling_address());
            System.out.println("shipping: " + details.getShipping_address());
        }
        String sql = "insert into users values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, details.getNextId());
            preparedStatement.setString(2, details.getUserName());
            preparedStatement.setString(3, details.getEmail());
            preparedStatement.setString(4, details.getPassword());
            preparedStatement.setInt(5, Integer.parseInt(details.getMobile()));
            preparedStatement.setString(6, details.getBilling_address());
            preparedStatement.setString(7, details.getShipping_address());
            preparedStatement.execute();
            db.closeConnection();
        }catch (SQLException ex){
            System.out.println("something gone wrong" + ex);
        }
    }
}
