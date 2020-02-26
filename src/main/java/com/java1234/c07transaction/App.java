package com.java1234.c07transaction;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //1.加载数据库驱动
        String jdbcName = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(jdbcName);
            System.out.println("加载驱动成功！");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("加载驱动失败！");
        }

        //连接数据库
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
            System.out.println("连接数据库成功！");
            con.setAutoCommit(false);


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            try {
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                con.commit();
                con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}
