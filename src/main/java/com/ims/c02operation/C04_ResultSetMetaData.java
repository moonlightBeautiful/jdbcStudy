package com.ims.c02operation;

import java.sql.*;

public class C04_ResultSetMetaData {
    public static void main(String[] args) throws Exception {
        // 连接对象
        Connection con = DbUtil.getConn();

        // 获取元数据：描述数据库
        DatabaseMetaData dbmd = con.getMetaData();
        System.out.println("数据库名称：" + dbmd.getDatabaseProductName());
        System.out.println("数据库版本：" + dbmd.getDriverMajorVersion() + "." + dbmd.getDriverMinorVersion());
        ResultSet resultSet = dbmd.getTables(con.getCatalog(), "%", null, new String[]{"TABLE"});
        while (resultSet.next()) {
            String name = resultSet.getString("TABLE_NAME");
            System.out.println("表名：" + name);
            String sql = "select * from " + name;
            PreparedStatement pstmt = con.prepareStatement(sql);
            // 获取元数据：描述表
            ResultSetMetaData rsmd = pstmt.getMetaData();
            System.out.println("   共有" + rsmd.getColumnCount() + "列");
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                System.out.println("   列名：" + rsmd.getColumnName(i) + ",类型：" + rsmd.getColumnTypeName(i));
            }
        }
        DbUtil.closeConn(con);

    }
}
