package com.java1234.c03prestatement;

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
            String sql = "";
            int result = 0;
            PreparedStatement pstmt = null;
            //执行sql 插入
           /* sql = "insert into t_count values(null,?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, 222);
            result = pstmt.executeUpdate();
            System.out.println("插入了：" + result + "数据");*/

            //执行sql 更新
            /*sql = "update t_count set money = ? where userId = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, 0);
            pstmt.setInt(2, 5);
            result = pstmt.executeUpdate();
            System.out.println("更新了：" + result + "数据");*/


            //执行sql 删除
            sql = "delete from t_count where userId=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, 5);
            result = pstmt.executeUpdate();
            System.out.println("删除了：" + result + "数据");

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


   /* //删除delete
    String sql = "delete from t_book where id=?";
    PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, 1);
                int result = pstmt.executeUpdate();
                if (result == 1) {
                System.out.println("删除成功！");
                } else {
                System.out.println("删除失败！");
                }*/