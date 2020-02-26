package com.java1234.c04resultSet;

import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
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

            //获取PreparedStatement
            PreparedStatement pstmt = null;
            //执行sql 查询 resultSet
            String sql = "select * from t_count";
            pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int userId = rs.getInt("userId");
                int money = rs.getInt("money");
                System.out.println(userId + ":" + money);
            }
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
