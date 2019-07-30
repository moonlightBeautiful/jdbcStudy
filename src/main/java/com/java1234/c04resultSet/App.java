package com.java1234.c04resultSet;

import com.java1234.c02statement.util.DbUtil;
import com.java1234.c04resultSet.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {

        DbUtil dbUtil = new DbUtil();
        //获取数据连接
        Connection con = dbUtil.getConn();

        List<Book> bookList = new ArrayList<Book>();
        String sql = "select * from t_book";
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id"); // 获取第一个列的值 编号id
            String bookName = rs.getString("bookName"); // 获取第二个列的值 图书名称 bookName
            float price = rs.getFloat("price"); // 获取第三列的值 图书价格 price
            String author = rs.getString("author"); // 获取第四列的值 图书作者 author
            int bookTypeId = rs.getInt("bookTypeId"); // 获取第五列的值 图书类别id
            Book book = new Book(id, bookName, price, author, bookTypeId);
            bookList.add(book);
        }
        for (Book book : bookList) {
            System.out.println(book);
        }

        //关闭数据库连接
        dbUtil.closeConn(pstmt, con);
    }
}
