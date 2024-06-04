package org.example.bookapp.services;

import org.example.bookapp.entity.Group;
import org.example.bookapp.entity.Student;
import org.example.bookapp.models.GroupModel;
import org.example.bookapp.models.StudentModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class StudentService {
    private StudentModel studentModel;
    private GroupModel groupModel;

    public StudentService(){
        this.studentModel = new StudentModel();
        this.groupModel = new GroupModel();
    }

    public void renderPageListStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Student> students = this.studentModel.getAllStudent();
        List<Group> groups = this.groupModel.getAllGroup();
        request.setAttribute("students", students);
        request.setAttribute("groups", groups);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/students/list.jsp");
        requestDispatcher.forward(request,response);
    }

    public void renderPageCreateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Group> groups = this.groupModel.getAllGroup();
        request.setAttribute("groups", groups);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/students/create.jsp");
        requestDispatcher.forward(request,response);
    }

    public void createStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        int group_id = Integer.parseInt(request.getParameter("group_id"));
        // get Group theo id;
        Group group = this.groupModel.findById(group_id);
        Student student = new Student(name, email, group);
        this.studentModel.save(student);
        response.sendRedirect("/students/list");
    }

    public void updateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        int group_id = Integer.parseInt(request.getParameter("group_id"));
        Group group = this.groupModel.findById(group_id);
        Student student = new Student(id, name, email, group);
        this.studentModel.update(student);
        response.sendRedirect("/students/list");
    }

    public void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        this.studentModel.delete(id);
        response.sendRedirect("/students/list");
    }

    public void renderPageClassInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        Group group = this.groupModel.findById(groupId);
        List<Student> students = this.studentModel.findByGroupId(groupId);
        request.setAttribute("group", group);
        request.setAttribute("students", students);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/students/detail.jsp");
        requestDispatcher.forward(request, response);
    }

    public void renderPageUpdateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = this.studentModel.findById(id);
        List<Group> groups = this.groupModel.getAllGroup();
        request.setAttribute("student", student);
        request.setAttribute("groups", groups);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/students/update.jsp");
        requestDispatcher.forward(request,response);
    }
}
