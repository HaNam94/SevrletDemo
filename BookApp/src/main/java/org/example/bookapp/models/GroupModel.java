package org.example.bookapp.models;

import org.example.bookapp.databases.DBconnect;
import org.example.bookapp.entity.Group;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GroupModel {
    private Connection connection;

    public GroupModel() {
        DBconnect dbConnect = new DBconnect();
        this.connection = dbConnect.getConnection();
    }

    public List<Group> getAllGroup() throws SQLException {
        String sql = "SELECT * FROM `groups`";
        PreparedStatement statement = this.connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<Group> groups = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            Group group = new Group(id, name);
            groups.add(group);
        }

        return groups;
    }

    public Group findById(int id) throws SQLException {
        String sql = "SELECT * FROM `groups` WHERE `id` = ?";
        PreparedStatement statement = this.connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        Group group = null;
        while (resultSet.next()) {
            int idGroup = resultSet.getInt("id");
            String name = resultSet.getString("name");
            group = new Group(idGroup, name);
        }
        return group;
    }
}
