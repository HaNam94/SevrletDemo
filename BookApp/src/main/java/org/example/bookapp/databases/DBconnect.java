package org.example.bookapp.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.Callable;

public class DBconnect {
    private static final String url = "jdbc:mySQl://localhost:3306/QlSV";
    private static final String user = "root";
    private static final String password = "nambee";

    public DBconnect() {
    }
    public Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connect database successfully");
        } catch ( SQLException | ClassNotFoundException e ) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
