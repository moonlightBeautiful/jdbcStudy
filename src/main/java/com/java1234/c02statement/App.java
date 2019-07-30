package com.java1234.c02statement;

import com.java1234.c02statement.util.DbUtil;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {

        DbUtil dbUtil = new DbUtil();
        Connection con = dbUtil.getConn(); //获取数据连接

        //插入insert
        /*Book book=new Book("Java牛牛2", 1212, "牛哥2", 2);
        String sql="insert into t_book values(null,'"+book.getBookName()+"',"+book.getPrice()+",'"+book.getAuthor()+"',"+book.getBookTypeId()+")";
        Statement stmt = con.createStatement();
        int result = stmt.executeUpdate(sql);
        System.out.println("操作的结果：" + result + "数据");*/

        //更新update
        /*Book book = new Book(3, "Java牛牛2222", 121, "牛哥222", 1);
        String sql = "update t_book set bookName='" + book.getBookName()
                + "',price=" + book.getPrice() + ",author='" + book.getAuthor()
                + "',bookTypeId=" + book.getBookTypeId() + " where id="
                + book.getId();
        Statement stmt = con.createStatement();
        int result = stmt.executeUpdate(sql);
        System.out.println("操作的结果：" + result + "数据");*/

        //删除delete
        int id = 3;
        String sql = "delete from t_book where id=" + id;
        Statement stmt = con.createStatement();
        int result = stmt.executeUpdate(sql);
        if (result == 1) {
            System.out.println("删除成功！");
        } else {
            System.out.println("删除失败！");
        }
        stmt.close();  // 关闭statement
        con.close();   // 关闭连接
    }
}
