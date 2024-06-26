package org.example.bookapp.models;

import org.example.bookapp.databases.DBconnect;
import org.example.bookapp.entity.Group;
import org.example.bookapp.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentModel {
    private Connection connection;

    public StudentModel() {
        DBconnect dBconnect = new DBconnect();
        this.connection = dBconnect.getConnection();
    }

    public List<Student> getAllStudent() throws SQLException {
        String sql = "SELECT s.*, g.id as groupId, g.name as groupName FROM students s JOIN `groups` g ON s.group_id = g.id";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Student> students = new ArrayList<>();
        while (resultSet.next()) {
            int idStudent = resultSet.getInt("id");
            String nameStudent = resultSet.getString("name");
            String emailStudent = resultSet.getString("email");
            int idGroup = resultSet.getInt("groupId");
            String nameGroup = resultSet.getString("groupName");
            Group group = new Group(idGroup, nameGroup);
            Student student = new Student(idStudent, nameStudent, emailStudent, group);
            students.add(student);
        }
        return students;
    }

    public void save(Student student) throws SQLException {
        String sql = "INSERT INTO `students`(name, email, group_id) VALUE (?, ?, ?)";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setString(1, student.getName());
        preparedStatement.setString(2, student.getEmail());
        preparedStatement.setInt(3, student.getGroup().getId());
        preparedStatement.execute();
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM students WHERE id = ?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
    }

    public void update(Student student) throws SQLException {
        String sql = "UPDATE students SET name = ?, email = ?, group_id = ? WHERE id = ?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setString(1, student.getName());
        preparedStatement.setString(2, student.getEmail());
        preparedStatement.setInt(3, student.getGroup().getId());
        preparedStatement.setInt(4, student.getId());
        preparedStatement.execute();
    }

    public Student findById(int id) throws SQLException {
        String sql = "SELECT s.*, g.id as groupId, g.name as groupName FROM students s JOIN `groups` g ON s.group_id = g.id WHERE s.id = ?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            int idStudent = resultSet.getInt("id");
            String nameStudent = resultSet.getString("name");
            String emailStudent = resultSet.getString("email");
            int idGroup = resultSet.getInt("groupId");
            String nameGroup = resultSet.getString("groupName");
            Group group = new Group(idGroup, nameGroup);
            return new Student(idStudent, nameStudent, emailStudent, group);
        }
        return null;
    }

    public List<Student> findByGroupId(int groupId) throws SQLException {
        String sql = "SELECT s.*, g.id as groupId, g.name as groupName FROM students s JOIN `groups` g ON s.group_id = g.id WHERE s.group_id = ?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1, groupId);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Student> students = new ArrayList<>();
        while (resultSet.next()) {
            int idStudent = resultSet.getInt("id");
            String nameStudent = resultSet.getString("name");
            String emailStudent = resultSet.getString("email");
            int idGroup = resultSet.getInt("groupId");
            String nameGroup = resultSet.getString("groupName");
            Group group = new Group(idGroup, nameGroup);
            Student student = new Student(idStudent, nameStudent, emailStudent, group);
            students.add(student);
        }
        return students;
    }
}
