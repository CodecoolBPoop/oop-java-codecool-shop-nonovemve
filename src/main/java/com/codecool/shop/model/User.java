package com.codecool.shop.model;

import com.codecool.shop.dao.DBConnection.DB;

import java.sql.*;

public class User extends BaseModel {

    DB getUserDB = new DB();
    private int id;
    private int nextId;
    private String userName;
    private String password;
    private String email;
    private String mobile;
    private String billing_address;
    private String shipping_address;

    public User(String name, int id, String password, String email, String mobile, String billing_address, String shipping_address) {
        super(name);
        this.userName = name;
        this.id = id;
        this.password = password;
        this.email = email;
        this.mobile = mobile;
        this.billing_address = billing_address;
        this.shipping_address = shipping_address;

    }

    public int getNextId() {
        getUserDB.openConnection();
        String sql = "select count(*) AS rowcount from users";
        try {
            Statement statement = getUserDB.getCreateStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()) {
                int count = result.getInt("rowcount");
                this.nextId = count;
                getUserDB.closeConnection();
            }
            getUserDB.closeConnection();

        }catch (SQLException ex) {
            System.out.println("fail to open db" + ex);
        }
        return nextId;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getBilling_address() {
        return billing_address;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getShipping_address() {
        return shipping_address;
    }

    public String toString() {
        return String.format(
                "name: %1$s, " +
                        "id: %2$d," +
                        "password: %3$s, " +
                        "email: %4$s, " +
                        "mobile: %5$s, " +
                        "billing_address: %6$s, " +
                        "shipping_address: %7$s, " ,
                this.userName,
                this.id,
                this.password,
                this.email,
                this.mobile,
                this.billing_address,
                this.shipping_address);
    }
}
