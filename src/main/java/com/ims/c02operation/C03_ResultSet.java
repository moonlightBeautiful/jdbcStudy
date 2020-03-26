package com.ims.c02operation;

import java.sql.*;

public class C03_ResultSet {
    public static void main(String[] args) throws Exception {
        // 连接对象
        Connection con = DbUtil.getConn();
        //获取PreparedStatement
        PreparedStatement pstmt = null;
        //执行sql 查询 resultSet
        String sql = "select * from t_count";
        pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            int userId = rs.getInt("userId");
            int money = rs.getInt("money");
            System.out.println(userId + ":" + money);
        }
        DbUtil.closeConn(con);

    }
}
