package org.scoula.travel.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
    private static final Properties props = new Properties();
    private static Connection conn = null;

    static {
        try (InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("application.properties")) {
            props.load(is);
            Class.forName(props.getProperty("driver"));
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(
                        props.getProperty("url"),
                        props.getProperty("id"),
                        props.getProperty("password")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    public static void close() {
        if (conn != null) {
            try {
                conn.close();
                conn = null;
            } catch (SQLException ignored) {}
        }
    }
}
