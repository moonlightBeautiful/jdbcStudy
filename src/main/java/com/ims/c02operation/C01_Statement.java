package com.ims.c02operation;

import java.sql.*;

/**
 * Hello world!
 */
public class C01_Statement {
    public static void main(String[] args) throws Exception {
        // 连接对象
        Connection con = DbUtil.getConn();
        // 获取statement
        Statement stmt = con.createStatement();

        /**
         * 表数据操作
         */
        //1.插入表数据
        /*String sql = "insert into t_count values(null,100,null,null)";
        int result = stmt.executeUpdate(sql);
        System.out.println("插入了：" + result + "数据");*/
        //2.更新表数据
        /*String sql = "update t_count set money = 0 where userId = 12";
        int result = stmt.executeUpdate(sql);
        System.out.println("更新了：" + result + "数据");*/
        //3.删除表数据
        /*String sql = "delete from t_count where userId=12";
        int result = stmt.executeUpdate(sql);
        System.out.println("删除了：" + result + "数据");*/
        //4.查询表数据
        /*String sql = "select * from t_count";
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println("查询了数据"+rs);*/
        /**
         * 表操作
         */
        //1.查询出数据库下所有表
        /*String sql = "select * from information_schema.tables where table_schema ='db_bank'";
        ResultSet resultSet = stmt.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println("表名：" + resultSet.getString("TABLE_NAME"));
        }*/
        //2.创建表，如果已经存在则报错
        /*String sql = "create table student1(id int not null primary key,name varchar(50),age int)";
        int row = stmt.executeUpdate(sql);*/
        //3.1修改表名
        /*String sql = " alter table student rename student2";
        int row = stmt.executeUpdate(sql);*/
        //3.2修改表，添加字段
        /*String sql = " alter table student2 add ii varchar(255) not null first";
        int row = stmt.executeUpdate(sql);*/
        //3.3修改表，修改字段
        /*String sql = " alter table student2 change ii iii2 varchar(244) not null first";
        int row = stmt.executeUpdate(sql);*/
        //3.4修改表，删除字段
        /*String sql = " alter table student2 drop iii2";
        int row = stmt.executeUpdate(sql);*/
        //4.删除表
        /*String sql = "DROP TABLE student2 ";
        int row = stmt.executeUpdate(sql);*/

        DbUtil.closeConn(con);
    }
}
