package org.scoula.jdbc_ex.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
//    JDBCUtil이 아닌 conn이 singleton
    static Connection conn = null;
//    conn이 싱글톤이므로 생성자 아닌 스태틱 코드블럭 사용
    static {
        // 직접 예외처리?
        try {
            Properties properties = new Properties();
//            컴파일 후 resources, org~ 모두 루트로 처리됨
//            관리만 따로 하는 것
            properties.load(JDBCUtil.class.getResourceAsStream("/application.properties"));
            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            String id = properties.getProperty("id");
            String password = properties.getProperty("password");

            Class.forName(driver);
            conn = DriverManager.getConnection(url, id, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() {
        return conn;
    }
    public static void close() {
        try {
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}