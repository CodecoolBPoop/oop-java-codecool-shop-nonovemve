package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.DBConnection.DB;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SupplierDaoJDBC implements SupplierDao {

    private List<Supplier> data = new ArrayList<>();
    private static SupplierDaoJDBC instance = null;
    DB db = new DB();

    /* A private Constructor prevents any other class from instantiating.
     */
    private SupplierDaoJDBC() {
    }

    public static SupplierDaoJDBC getInstance() {
        if (instance == null) {
            instance = new SupplierDaoJDBC();
        }
        return instance;
    }

    @Override
    public void add(Supplier supplier) {
        supplier.setId(data.size() + 1);
        data.add(supplier);
    }

    @Override
    public Supplier find(int id) {
        for (Supplier category : data) {
            if (category.getId() == id){
                System.out.println(category);
                return category;
            }
        }
        return null;
    }

    @Override
    public void remove(int id) {
        data.remove(find(id));
    }

    @Override
    public List<Supplier> getAll() {
        data.clear();
        db.openConnection();
        String sql = "SELECT * FROM suppliers";
        try {
            Statement statement = db.getCreateStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                data.add(new Supplier(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description")));
            }

            db.closeConnection();

        }catch (SQLException ex){
            System.out.println("product category not found" + ex);
        }
        return data;
    }
}
