package com.codecool.shop.controller;

import com.codecool.shop.config.Basket;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = {"/"})
public class ProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();

        String item = req.getParameter("item");

        if(item!= null) {
            int actaulBasketSize = Basket.basket.size();
            int index = Integer.parseInt(item);
            Basket.basket.add(productDataStore.find(index));
            System.out.println((Basket.basket.size() > actaulBasketSize) ? "Done.Item its in the basket" : "Failed to add item to basket");
        }

//        Map params = new HashMap<>();
//        params.put("category", productCategoryDataStore.find(1));
//        params.put("products", productDataStore.getBy(productCategoryDataStore.find(1)));

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
//        context.setVariables(params);


        context.setVariable("basketSize", Basket.basket.size());
        context.setVariable("recipient", "World");
        context.setVariable("allproducts", productCategoryDataStore.getAll());
        context.setVariable("allsuppliers", supplierDataStore.getAll());
        if (req.getParameter("category") != null) {
            context.setVariable("category", productCategoryDataStore.find(Integer.parseInt(req.getParameter("category"))));
            context.setVariable("products", productDataStore.getBy(productCategoryDataStore.find(Integer.parseInt(req.getParameter("category")))));
        } else if (req.getParameter("supplier") != null) {
            context.setVariable("category", supplierDataStore.find(Integer.parseInt(req.getParameter("supplier"))));
            context.setVariable("products", productDataStore.getBy(supplierDataStore.find(Integer.parseInt(req.getParameter("supplier")))));
        } else {
            context.setVariable("allproducts", productCategoryDataStore.getAll());
            context.setVariable("products", productDataStore.getAll());
        }
        engine.process("product/index.html", context, resp.getWriter());
    }

}
