package com.codecool.shop.controller;

import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.implementation.ProductCategoryDaoJDBC;
import com.codecool.shop.dao.implementation.UserDaoJDBC;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.User;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/register_step2"})
public class RegisterStep2Controller extends HttpServlet {
    UserDaoJDBC userDao = new UserDaoJDBC();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request, response, request.getServletContext());
        User setDetails = new User(request.getParameter("userName"),
                                   999,
                                   request.getParameter("password"),
                                   request.getParameter("email"),
                                   request.getParameter("mobile"),
                                   request.getParameter("billingAddress"),
                                   request.getParameter("shippingAddress"));
        int newID = setDetails.getNextId();
        setDetails.setId(newID);
        userDao.add(setDetails);


        engine.process("/product/register_step2.html", context, response.getWriter());

    }
}
