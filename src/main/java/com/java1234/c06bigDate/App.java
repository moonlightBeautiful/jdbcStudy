package com.java1234.c06bigDate;

import com.java1234.c02statement.util.DbUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {

        DbUtil dbUtil = new DbUtil();
        //获取数据连接
        Connection conn = dbUtil.getConn();

        //插入
        /*File context = new File("c:/helloWorld.txt");
        File pic = new File("c:/pic1.jpg");
        Book book = new Book("helloWorld", 100, "小锋", 1, context, pic);
        String sql = "insert into t_book values(null,?,?,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, book.getBookName());
        pstmt.setFloat(2, book.getPrice());
        pstmt.setString(3, book.getAuthor());
        pstmt.setInt(4, book.getBookTypeId());
        //clob
        InputStream inputStream = new FileInputStream(book.getContext());
        pstmt.setAsciiStream(5, inputStream, context.length());
        //blob
        InputStream inputStream2 = new FileInputStream(book.getPic());
        pstmt.setBinaryStream(6, inputStream2, pic.length());
        int result = pstmt.executeUpdate();
        if (result == 1) {
            System.out.println("添加成功！");
        } else {
            System.out.println("添加失败！");
        }*/

        //获取
        String sql = "select * from t_book where id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, 6);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            String bookName = rs.getString("bookName");
            float price = rs.getFloat("price");
            String author = rs.getString("author");
            int bookTypeId = rs.getInt("bookTypeId");
            //clob
            Clob c = rs.getClob("context");
            String context = c.getSubString(1, (int) c.length());
            //blob
            Blob b = rs.getBlob("pic");
            FileOutputStream out = new FileOutputStream(new File("c:/pic2.jpg"));
            out.write(b.getBytes(1, (int) b.length()));
            out.close();
            System.out.println("图书名称：" + bookName);
            System.out.println("图书价格:" + price);
            System.out.println("图书作者：" + author);
            System.out.println("图书类型ID：" + bookTypeId);
            System.out.println("图书内容：" + context);
        }


        dbUtil.closeConn(pstmt, conn);


    }
}
