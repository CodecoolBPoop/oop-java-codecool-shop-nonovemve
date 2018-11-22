package com.codecool.shop.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Supplier extends BaseModel {
    private List<Product> products;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return Objects.equals(name, supplier.name) &&
                Objects.equals(description, supplier.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products);
    }

    public Supplier(int id, String name, String description) {
        super(name);
        this.products = new ArrayList<>();
        this.description = description;
        this.id = id;
    }

    public Supplier(String name, String description) {
        super(name);
        this.products = new ArrayList<>();
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public String toString() {
        return String.format("id: %1$d, " +
                        "name: %2$s, " +
                        "description: %3$s",
                this.id,
                this.name,
                this.description
        );
    }
}