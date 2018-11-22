package com.codecool.shop.dao.implementation;


import com.codecool.shop.dao.DBConnection.DB;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.model.ProductCategory;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductCategoryDaoJDBC implements ProductCategoryDao{

    //private List<ProductCategory> data = new ArrayList<>();
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
        return null;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<ProductCategory> getAll() {
        return null;
    }
}
