package com.java1234.c05metaData;

import com.java1234.c02statement.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {

        DbUtil dbUtil = new DbUtil();
        //获取数据连接
        Connection con = dbUtil.getConn();


        // 获取元数据：描述数据库
        /*DatabaseMetaData dmd = con.getMetaData();
        System.out.println("数据库名称：" + dmd.getDatabaseProductName());
        System.out.println("数据库版本：" + dmd.getDriverMajorVersion() + "." + dmd.getDriverMinorVersion());*/

        String sql = "select * from t_book";
        PreparedStatement pstmt = con.prepareStatement(sql);
        // 获取元数据：描述表
        ResultSetMetaData rsmd = pstmt.getMetaData();
        int num = rsmd.getColumnCount();
        System.out.println("共有" + num + "列");
        for (int i = 1; i <= num; i++) {
            System.out.println(rsmd.getColumnName(i) + "," + rsmd.getColumnTypeName(i));
        }
    }
}
