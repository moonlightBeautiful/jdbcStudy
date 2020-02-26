package com.java1234.c02statement;

import java.sql.*;

/**
 * Hello world!
 */
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
            //获取statement
            Statement stmt = con.createStatement();
            String sql = "";
            int result = 0;
            //执行sql 插入
           /* String sql = "insert into t_count values(null,100)";
            int result = stmt.executeUpdate(sql);
            System.out.println("插入了：" + result + "数据");*/
            //执行sql 更新
           /* sql = "update t_count set money = 0 where userId = 4";
            result = stmt.executeUpdate(sql);
            System.out.println("更新了：" + result + "数据");*/
            //执行sql 删除
           /* sql = "delete from t_count where userId=4";
            result = stmt.executeUpdate(sql);
            System.out.println("删除了：" + result + "数据");*/
            //执行sql 创建表
            /*sql = "create table student(id int not null primary key,name varchar(50),age int)";
            int row = stmt.executeUpdate(sql);*/
            //执行sql 查询所有表
            /*sql = "select * from information_schema.tables where table_schema ='db_bank'";
            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println("表名：" + resultSet.getString("TABLE_NAME"));
            }*/
            //执行sql 修改表1，修改表名
          /*  sql = " alter table student rename student2";
            int row = stmt.executeUpdate(sql);*/
            //执行sql 修改表2，添加字段
           /* sql = " alter table student2 add ii varchar(255) not null first";
            int row = stmt.executeUpdate(sql);*/
            //执行sql 修改表3，修改字段
            /*sql = " alter table student2 change ii iii2 varchar(244) not null first";
            int row = stmt.executeUpdate(sql);*/
            //执行sql 修改表4，删除字段
            sql = " alter table student2 drop iii2";
            int row = stmt.executeUpdate(sql);
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
