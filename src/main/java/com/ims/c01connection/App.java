package com.ims.c01connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        /**
         * 1.加载数据库驱动
         */
        String jdbcName = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(jdbcName);
            System.out.println("加载驱动成功！");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        /**
         * 2.获取数据库的连接
         */
        // 数据库地址
        String dbUrl = "jdbc:mysql://localhost:3306/db_bank?serverTimezone=UTC";
        // 数据库用户名
        String dbUserName = "root";
        // 数据库密码
        String dbPassword = "root";
        // 连接对象
        Connection con = null;
        try {
            // 获取数据库连接
            con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
            System.out.println("获取数据库的连接成功！");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            /**
             * 3.关闭数据库的连接
             */
            try {
                con.close();
                System.out.println("关闭数据库的连接成功！");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
