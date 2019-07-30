package com.java1234.c04resultSet.util;

import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DbUtil {

    // 数据库地址
    private static String dbUrl = "jdbc:mysql://47.244.180.90:3306/db_book?useUnicode=true&characterEncoding=UTF-8";
    // 用户名
    private static String dbUserName = "root";
    // 密码
    private static String dbPassword = "root";
    // 驱动名称
    private static String jdbcName = "com.mysql.jdbc.Driver";

    /**
     * 获取数据库连接
     *
     * @return
     * @throws Exception
     */
    public Connection getConn() throws Exception {
        Class.forName(jdbcName);
        Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
        return con;
    }

    /**
     * 关闭连接
     *
     * @param con
     * @throws Exception
     */
    public void closeConn(Statement stmt, Connection con) throws Exception {
        if (stmt != null) {
            stmt.close();
            if (con != null) {
                con.close();
            }
        }
    }

    /**
     * 关闭连接
     *
     * @param con
     * @throws Exception
     */
    public void closeConn(PreparedStatement pstmt, Connection con) throws Exception {
        if (pstmt != null) {
            pstmt.close();
            if (con != null) {
                con.close();
            }
        }
    }
}
