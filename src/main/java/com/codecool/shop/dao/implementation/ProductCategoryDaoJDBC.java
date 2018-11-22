package com.codecool.shop.dao.implementation;


import com.codecool.shop.dao.DBConnection.DB;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.model.ProductCategory;

import javax.swing.plaf.nimbus.State;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductCategoryDaoJDBC implements ProductCategoryDao{

    private List<ProductCategory> data = new ArrayList<>();
    private static ProductCategoryDaoJDBC instance = null;
    private DB db = new DB();

    /* A private Constructor prevents any other class from instantiating.
     */
    public ProductCategoryDaoJDBC() {
    }

    public static ProductCategoryDaoJDBC getInstance() {
        if (instance == null) {
            instance = new ProductCategoryDaoJDBC();
        }
        return instance;
    }

    @Override
    public void add(ProductCategory category) {
        db.openConnection();
        String sql = "insert into productcategory values (?, ?, ?, ?)";
        try {
            System.out.println("GOAL");
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, 6);
            preparedStatement.setString(2, category.getName());
            preparedStatement.setString(3, category.getName());
            preparedStatement.setString(4, category.getName());
            preparedStatement.execute();
            db.closeConnection();
        }catch (SQLException ex){
            System.out.println("itt nem jo" + ex);
        }

    }

    @Override
    public ProductCategory find(int id) {
/*
        db.openConnection();
        String sql = "SELECT * FROM productcategory WHERE id ='" + id + "'";
        ProductCategory category = null;
        try {
            Statement statement = db.getCreateStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                category = new ProductCategory(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("departement"),
                        resultSet.getString("description"));
            }

            db.closeConnection();

        }catch (SQLException ex){
            System.out.println("product category not found" + ex);
        }


        return category;
    */
        for (ProductCategory category : data) {
            if (category.getId() == id){
                System.out.println(category);
                return category;
            }
        }
        return null;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<ProductCategory> getAll() {
        data.clear();
        db.openConnection();
        String sql = "SELECT * FROM productcategory";
        try {
            Statement statement = db.getCreateStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                data.add(new ProductCategory(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("departement"),
                        resultSet.getString("description")));
            }

            db.closeConnection();

        }catch (SQLException ex){
            System.out.println("product category not found" + ex);
        }
        return data;
    }
}
