package org.example.bookapp.controllers;

import org.example.bookapp.services.StudentService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
@WebServlet(name = "StudentServlet", urlPatterns = {"/students/*"})
public class StudentServlet extends HttpServlet {
    private StudentService studentService;
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.studentService = new StudentService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        req.setCharacterEncoding("UTF-8");
        try {
            switch (url) {
                case "/list":
                    this.studentService.renderPageListStudent(req, resp);
                    break;
                case "/create":
                    this.studentService.renderPageCreateStudent(req, resp);
                    break;
                case "/update":
                    this.studentService.renderPageUpdateStudent(req, resp);
                    break;
                case "/delete":
                    this.studentService.deleteStudent(req, resp);
                    break;

                default:
                    resp.sendError(HttpServletResponse.SC_NOT_FOUND);
                    break;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        req.setCharacterEncoding("UTF-8");
        try {
            switch (url) {
                case "/create":
                    this.studentService.createStudent(req, resp);
                    break;
                case "/update":
                    this.studentService.updateStudent(req, resp);
                    break;
                case "/classInfo":
                    this.studentService.renderPageClassInfo(req, resp);
                    break;
                default:
                    resp.sendError(HttpServletResponse.SC_NOT_FOUND);
                    break;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
