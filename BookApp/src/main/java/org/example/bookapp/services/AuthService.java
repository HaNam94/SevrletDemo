package org.example.bookapp.services;

import org.example.bookapp.entity.User;
import org.example.bookapp.models.UserModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthService {
    private UserModel userModel;
    public AuthService(){
        this.userModel = new UserModel();
    }
    public void renderPageLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher out = request.getRequestDispatcher("/views/auth/login.jsp");
        out.forward(request, response);
    }
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User userLogin = this.userModel.findUserByAccount(username, password);
        if (userLogin != null){
            HttpSession session = request.getSession();
            session.setAttribute("userLogin", userLogin.getUsername());

            response.sendRedirect("/books/list");

        } else {
            response.sendRedirect("/auth/login");
        }
    }
}
