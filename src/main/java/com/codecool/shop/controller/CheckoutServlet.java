package com.codecool.shop.controller;

import com.codecool.shop.config.Basket;
import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/checkout"})
public class CheckoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request, response, request.getServletContext());

        Basket basket = Basket.getInstance();
        ProductDao productDataStore = ProductDaoMem.getInstance();

        String item = request.getParameter("item");

        /*
         Add test element
          */

        basket.clear();
        basket.add(productDataStore.find(2));
        basket.add(productDataStore.find(2));
        basket.add(productDataStore.find(3));
        basket.add(productDataStore.find(1));


        if(item!= null) {
            int index = Integer.parseInt(item);
            basket.add(productDataStore.find(index));
        }

        context.setVariable("basketList", basket.getAll());
        engine.process("/product/checkout.html",context, response.getWriter());
    }
}
