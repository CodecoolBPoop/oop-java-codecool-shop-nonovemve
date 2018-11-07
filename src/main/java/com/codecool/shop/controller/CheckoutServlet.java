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
        ProductDao productDataStore = ProductDaoMem.getInstance();


        String item = request.getParameter("item");

        if(item != null){
            int index = Integer.parseInt(item);
            for(int i = 0;i<Basket.basket.size();i++){
                if(Basket.basket.get(i).equals(productDataStore.find(index))){
                    Basket.basket.remove(i);
                    System.out.println("Find it");
                    break;
                }
            }
        }


        context.setVariable("basketList", Basket.basket);
        engine.process("/product/checkout.html",context, response.getWriter());
    }
}
