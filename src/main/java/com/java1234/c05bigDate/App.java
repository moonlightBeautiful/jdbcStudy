package com.java1234.c05bigDate;


import java.io.*;
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
            String sql = "";
            int result = 0;
            //插入clob
           /* sql = "insert into t_count values(null,500,?,null)";
            pstmt = con.prepareStatement(sql);
            File note = new File("helloWorld.txt");
            InputStream inputStream = new FileInputStream(note);
            pstmt.setAsciiStream(1, inputStream, note.length());
            result = pstmt.executeUpdate();
            System.out.println("插入了" + result + "条clob类型数据！");*/

            //插入blob 图片
            /*sql = "insert into t_count values(null,5001,null,?)";
            pstmt = con.prepareStatement(sql);
            File pic = new File("liuyifei.jpg");
            InputStream inputStream = new FileInputStream(pic);
            pstmt.setBinaryStream(1, inputStream, pic.length());
            result = pstmt.executeUpdate();
            System.out.println("插入了" + result + "条blob类型数据！");*/

            //插入blob txt文件
            /*sql = "insert into t_count values(null,5001,null,?)";
            pstmt = con.prepareStatement(sql);
            File pic = new File("helloWorld.txt");
            InputStream inputStream = new FileInputStream(pic);
            pstmt.setBinaryStream(1, inputStream, pic.length());
            result = pstmt.executeUpdate();
            System.out.println("插入了" + result + "条blob类型数据！");*/

            //获取clob
            /*sql = "select * from t_count where userId=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, 8);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            Clob note = rs.getClob("note");
            String noteStr = note.getSubString(1, (int) note.length());
            System.out.println("查询到的clob：" + noteStr);*/

            //获取blob
            sql = "select * from t_count where userId=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, 10);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            Blob b = rs.getBlob("pic");
            FileOutputStream out = new FileOutputStream(new File("liuyifei2.jpg"));
            out.write(b.getBytes(1, (int) b.length()));  //b.getBytes(1, (int) b.length()) blob转byte[]
            out.close();
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

