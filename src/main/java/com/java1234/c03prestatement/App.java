package com.java1234.c03prestatement;

import com.java1234.c02statement.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {

        DbUtil dbUtil = new DbUtil();
        Connection con = dbUtil.getConn(); //获取数据连接

        //插入insert
        /*Book book = new Book("Java叉叉2", 1, "叉叉", 1);
        String sql = "insert into t_book values(null,?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, book.getBookName());
        pstmt.setFloat(2, book.getPrice());
        pstmt.setString(3, book.getAuthor());
        pstmt.setInt(4, book.getBookTypeId());
        int result = pstmt.executeUpdate();
        if (result == 1) {
            System.out.println("添加成功！");
        } else {
            System.out.println("添加失败！");
        }*/

        //更新update
        /*Book book = new Book(4, "K2", 2, "K", 2);
        String sql = "update t_book set bookName=?,price=?,author=?,bookTypeId=? where id=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, book.getBookName());
        pstmt.setFloat(2, book.getPrice());
        pstmt.setString(3, book.getAuthor());
        pstmt.setInt(4, book.getBookTypeId());
        pstmt.setInt(5, book.getId());
        int result = pstmt.executeUpdate();
        if (result == 1) {
            System.out.println("更新成功！");
        } else {
            System.out.println("更新失败！");
        }*/

        //删除delete
        String sql = "delete from t_book where id=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, 1);
        int result = pstmt.executeUpdate();
        if (result == 1) {
            System.out.println("删除成功！");
        } else {
            System.out.println("删除失败！");
        }

        //关闭数据库连接
        dbUtil.closeConn(pstmt, con);
    }
}
