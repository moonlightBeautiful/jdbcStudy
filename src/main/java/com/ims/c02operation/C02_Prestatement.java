package com.ims.c02operation;

import java.sql.*;

public class C02_Prestatement {
    public static void main(String[] args) throws Exception {
        // 连接对象
        Connection con = DbUtil.getConn();
        //获取PreparedStatement
        PreparedStatement pstmt = null;
        //执行sql和Statement，区别就是使用?占位和效率高
        String sql = "insert into t_count values(null,?,null,null)";
        pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, 222);
        int result = pstmt.executeUpdate();
        System.out.println("插入了：" + result + "数据");

        DbUtil.closeConn(con);
    }
}


