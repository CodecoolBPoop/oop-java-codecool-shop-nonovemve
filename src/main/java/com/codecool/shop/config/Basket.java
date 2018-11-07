package com.codecool.shop.config;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.model.Product;

import java.util.ArrayList;

public class Basket {
    private ArrayList<Product> basket = new ArrayList<Product>();
    private static Basket instance = null;

    public static Basket getInstance() {
        if (instance == null) {
            instance = new Basket();
        }
        return instance;
    }

    public void add(Product product) {
        basket.add(product);
    }

    public Product find(int id) {
        return basket.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }


    public void remove(int id) {
        basket.remove(find(id));
    }


    public ArrayList<Product> getAll() {
        return basket;
    }

    public void clear(){
        basket.clear();
    }
}
