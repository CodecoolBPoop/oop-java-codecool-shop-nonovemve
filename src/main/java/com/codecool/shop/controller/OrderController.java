package com.codecool.shop.controller;

import com.codecool.shop.config.Basket;
import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/order"})
public class OrderController extends HttpServlet{

    private String firstName = "";
    private String lastName = "";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request, response, request.getServletContext());

        engine.process("/product/order.html", context, response.getWriter());

        this.firstName = request.getParameter("firstName");
        this.lastName = request.getParameter("lastName");
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        if (firstName.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Names cant contain numbers");
        }
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Names cant contain numbers");
        }
        this.lastName = lastName;
    }


}