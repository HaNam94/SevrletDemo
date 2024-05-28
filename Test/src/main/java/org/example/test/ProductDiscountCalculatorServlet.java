package org.example.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProductDiscountCalculatorServlet", urlPatterns = "/calculate")
public class ProductDiscountCalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productDescription = request.getParameter("description");
        Double productPrice = Double.parseDouble(request.getParameter("price"));
        Double discount = Double.parseDouble(request.getParameter("discount"));

        double discountAmount = productPrice*discount/100;
        double discountPrice = productPrice - discountAmount;

        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html>");
        printWriter.println("<h3>Product Description: " + productDescription + "</h3>");
        printWriter.println("<h3>List Price: " + productPrice + "</h3>");
        printWriter.println("<h3>Discount: " + discount + "</h3>");
        printWriter.println("<h3>Discount Amount: " + discountAmount + "</h3>");
        printWriter.println("<h3>Discount Price: " + discountPrice + "</h3>");
        printWriter.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
