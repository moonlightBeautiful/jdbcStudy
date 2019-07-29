package com.java1234.c01connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        //加载数据库驱动
        String jdbcName = "com.mysql.jdbc.Driver";
        try {
            Class.forName(jdbcName);
            System.out.println("加载驱动成功！");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("加载驱动失败！");
        }

        // 数据库地址
        String dbUrl = "jdbc:mysql://47.244.180.90:3306/db_book";
        // 用户名
        String dbUserName = "root";
        // 密码
        String dbPassword = "root";
        // 驱动名称
        Connection con = null;
        try {
            // 获取数据库连接
            con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
            System.out.println("获取数据库连接成功！");
            System.out.println("进行数据库操作！");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
