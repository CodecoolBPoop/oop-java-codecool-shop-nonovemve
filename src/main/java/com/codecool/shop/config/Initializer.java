package com.codecool.shop.config;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Initializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();

        //setting up a new supplier
        //Supplier allsuppliers = new Supplier("All suppliers", "Everything");
        //supplierDataStore.add(allsuppliers);
        Supplier amazon = new Supplier("Amazon", "Digital content and services");
        supplierDataStore.add(amazon);
        Supplier lenovo = new Supplier("Lenovo", "Computers");
        supplierDataStore.add(lenovo);
        Supplier apple = new Supplier("Apple", "Computers");
        supplierDataStore.add(apple);
        Supplier oneplus = new Supplier("OnePlus", "Phones");
        supplierDataStore.add(oneplus);
        Supplier dji = new Supplier("DJI", "Drones");
        supplierDataStore.add(dji);


        //setting up a new product category
        //ProductCategory allproducts = new ProductCategory("All", "Misc", "All products");
        //productCategoryDataStore.add(allproducts);
        ProductCategory tablet = new ProductCategory("Tablet", "Hardware", "A tablet computer, commonly shortened to tablet, is a thin, flat mobile computer with a touchscreen display.");
        productCategoryDataStore.add(tablet);
        ProductCategory notebook = new ProductCategory("Notebook", "Hardware", "Notebook is a pc that can be moved easily anywhere, anytime.");
        productCategoryDataStore.add(notebook);
        ProductCategory phone = new ProductCategory("Phones", "Hardware", "Phone is a telephone.");
        productCategoryDataStore.add(phone);
        ProductCategory accessories = new ProductCategory("Accessoriess", "Misc", "Stuff");
        productCategoryDataStore.add(accessories);
        ProductCategory drones = new ProductCategory("Drones", "Hardware", "Flying, recording machines");
        productCategoryDataStore.add(drones);


        //setting up products and printing it
        productDataStore.add(new Product("Amazon Fire", 49.9f, "USD", "Fantastic price. Large content ecosystem. Good parental controls. Helpful technical support.", tablet, amazon));
        productDataStore.add(new Product("Lenovo IdeaPad Miix 700", 479, "USD", "Keyboard cover is included. Fanless Core m5 processor. Full-size USB ports. Adjustable kickstand.", tablet, lenovo));
        productDataStore.add(new Product("Amazon Fire HD 8", 89, "USD", "Amazon's latest Fire HD 8 tablet is a great value for media consumption.", tablet, amazon));
        productDataStore.add(new Product("Apple Macbook Pro 2017", 1199, "USD", "Not really fantastic price. Beautiful design. Easy usage. User friendly OS", notebook, apple));
        productDataStore.add(new Product("OnePlus 6", 499, "USD", "Octa-core processor. Top class camera. Oxygen OS. 'NEVER SETTLE'", phone, oneplus));
        productDataStore.add(new Product("Apple New Mac candle", 149, "USD", "The scent you get when you unbox a new Macbook. It's like the new car scent I guess... maybe not", accessories, apple));
        productDataStore.add(new Product("DJI Mavic Pro", 499, "USD", "The drone you always wanted with hi def, wide-angle camera.", drones, dji));
        productDataStore.add(new Product("OnePlus 6 Case", 9.99f, "USD", "Extra protection for your precious phone", accessories, oneplus));
        productDataStore.add(new Product("Apple MagSafe charger", 59.9f, "USD", "Backup charger for your notebook.", accessories, apple));

    }
}
