package com.ims.c03bigDate;


import com.ims.c02operation.DbUtil;

import java.io.*;
import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        // 连接对象
        Connection con = DbUtil.getConn();
        //获取PreparedStatement
        PreparedStatement pstmt = null;
        String sql = "";
        int result = 0;

        /**
         * 向数据库插入大数据
         */
        //1.插入clob，即插入文本文件，例如txt文件
        /*sql = "insert into t_count values(null,500,?,null)";
        pstmt = con.prepareStatement(sql);
        File note = new File("helloWorld.txt");
        InputStream inputStream = new FileInputStream(note);
        pstmt.setAsciiStream(1, inputStream, note.length());
        result = pstmt.executeUpdate();
        System.out.println("插入了" + result + "条clob类型数据！");*/

        //2.插入clob， 即插入非文本文件，例如图片文件
        /*sql = "insert into t_count values(null,5001,null,?)";
        pstmt = con.prepareStatement(sql);
        File pic = new File("liuyifei.jpg");
        InputStream inputStream = new FileInputStream(pic);
        pstmt.setBinaryStream(1, inputStream, pic.length());
        result = pstmt.executeUpdate();
        System.out.println("插入了" + result + "条blob类型数据！");*/

        /**
         * 向数据库获取大数据
         */
        //获取clob，即获取文本文件，例如txt文件
        /*sql = "select * from t_count where userId=?";
        pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, 14);
        ResultSet rs = pstmt.executeQuery();
        rs.next();
        Clob note = rs.getClob("note");
        String noteStr = note.getSubString(1, (int) note.length());
        System.out.println("查询到的clob：\n" + noteStr);*/

        //获取blob， 即获取非文本文件，例如图片文件
        sql = "select * from t_count where userId=?";
        pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, 15);
        ResultSet rs = pstmt.executeQuery();
        rs.next();
        Blob b = rs.getBlob("pic");
        byte[] bs = b.getBytes(1, (int) b.length());
        FileOutputStream out = new FileOutputStream(new File("liuyifei2.jpg"));
        out.write(bs);
        out.close();


        DbUtil.closeConn(con);


    }
}

