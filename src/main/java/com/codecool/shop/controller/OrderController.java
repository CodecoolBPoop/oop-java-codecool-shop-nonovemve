package com.codecool.shop.controller;

import com.codecool.shop.config.Basket;
import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.UserDaoJDBC;
import com.codecool.shop.model.User;
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

    UserDaoJDBC save = new UserDaoJDBC();

    private String firstName = "";
    private String lastName = "";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request, response, request.getServletContext());
        String userName = request.getParameter("uname");
        String password = request.getParameter("psw");
        User userDetails = new User(userName, password);
        if (userDetails.loginCheck(userDetails)) {
            //System.out.println("Sikeres login");
            engine.process("/product/order.html", context, response.getWriter());
        }else {
            //System.out.println("Sikertelen login");
            engine.process("/product/login.html", context, response.getWriter());
        }
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