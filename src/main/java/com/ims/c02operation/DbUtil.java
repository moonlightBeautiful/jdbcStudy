package com.ims.c02operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
    private static String jdbcName = "com.mysql.cj.jdbc.Driver";
    private static String dbUrl = "jdbc:mysql://localhost:3306/db_bank?serverTimezone=UTC";
    private static String dbUserName = "root";
    private static String dbPassword = "root";
    private static Connection conn = null;

    public static Connection getConn() {
        try {
            Class.forName(jdbcName);
            System.out.println("加载驱动成功！");
            conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
            System.out.println("获取数据库的连接成功！");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConn(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("关闭数据库的连接成功！");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
