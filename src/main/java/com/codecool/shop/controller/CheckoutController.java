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

@WebServlet(urlPatterns = {"/checkout"})
public class CheckoutController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request, response, request.getServletContext());
        PrintWriter out = response.getWriter();
        out.println("<html>\n" +
                "<head>" +
                "       <title> Checkout  </title>" +
                "   </head>\n" +

                "<body>\n" +
                "<h1 align = \"center\"> Checkout </h1>\n" +
                "<form align=\"center\" action=\"/order\" method=\"GET\">" +
                    "First name:" + "<br>" +
                    "<input type=\"text\" name=\"firstName\" value=\"Zsida\">" +
                    "<br>" +
                    "Last name:" + "<br>" +
                    "<input type=\"text\" name=\"lastName\" value=\"Kadabra\">" +
                    "<br>" +
                    "Email:" + "<br>" +
                    "<input type=\"text\" name=\"email\" value=\"\">" +
                    "<br>" +
                    "Phone number:" + "<br>" +
                    "<input type=\"text\" name=\"phoneNumber\" value=\"\">" +
                    "<br>" +
                    "<p align=\"center\">Billing Address</p>" +
                    "Country:" + "<br>" +
                    "<input type=\"text\" name=\"country\" value=\"\">" +
                    "<br>" +
                    "City:" + "<br>" +
                    "<input type=\"text\" name=\"city\" value=\"\">" +
                    "<br>" +
                    "Zipcode:" + "<br>" +
                    "<input type=\"text\" name=\"zipCode\" value=\"\">" +
                    "<br>" +
                    "Address:" + "<br>" +
                    "<input type=\"text\" name=\"address\" value=\"\">" +
                    "<br><br>" +
                    "<input type=\"submit\" value=\"Submit & Continue to Order\">" +
                "</form>" +
                "</body></html>"
        );
    }

}
