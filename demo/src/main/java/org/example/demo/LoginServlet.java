package org.example.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginService", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        if ("admin".equals(username) && "admin".equals(password)) {
            writer.println("<h1>Welcome!" + username + "to website</h1>");
        } else {
            writer.println("<h1>Login Error</h1>");
        }
        writer.println("</html>");
    }
}
