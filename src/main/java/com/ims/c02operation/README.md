# jdbcStudy
操作数据库
    1.操作类
        Statement和PreparedStatement
        PreparedStatement效率高
    2.操作
        .executeUpdate(sql 增删改)
        .executeQuery(sql 查询)
    3.结果集
        ResultSet
    4.元数据
        描述数据库和表
    5.事务实现
        取消数据库自动提交
        con.setAutoCommit(false);
        发生异常则回滚
        con.rollback();
        没有异常则手动提交
        con.commit();