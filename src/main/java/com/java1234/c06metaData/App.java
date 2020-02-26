package com.java1234.c06metaData;

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

            // 获取元数据：描述数据库
            DatabaseMetaData dmd = con.getMetaData();
            System.out.println("数据库名称：" + dmd.getDatabaseProductName());
            System.out.println("数据库版本：" + dmd.getDriverMajorVersion() + "." + dmd.getDriverMinorVersion());
            ResultSet resultSet = dmd.getTables(con.getCatalog(), "%", null, new String[]{"TABLE"});
            while (resultSet.next()) {
                String name = resultSet.getString("TABLE_NAME");
                System.out.println("表名：" + name);
                //System.out.println("name------>" + name);
                //   System.out.println("remark------->" + remark);
            }
            String sql = "select * from t_count";
            PreparedStatement pstmt = con.prepareStatement(sql);
            // 获取元数据：描述表
            ResultSetMetaData rsmd = pstmt.getMetaData();
            System.out.println("共有" + rsmd.getColumnCount() + "列");
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                System.out.println("列：" + rsmd.getColumnName(i) + "," + rsmd.getColumnTypeName(i));
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
