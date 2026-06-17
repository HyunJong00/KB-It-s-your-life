package com.study.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

    @Test
    void testConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
//        192.168.10.86
        String url = "jdbc:mysql://localhost:3306/edu_db";
        String user = "edu";
        String password = "1234";

        Connection conn = DriverManager.getConnection(url,user,password);

    }
}
