# jdbcStudy
简介：
    jdbc是java连接数据库执行sql语句的标准，接口，数据库厂家需要些具体的实现，叫做驱动。比如mysql、oracle等
原理：
    程序-jdbc接口-jdbc驱动（各个数据库的驱动）-数据库
    多态的一种实现
1.连接数据库
    步骤  
        1.加载驱动  Class.forName(jdbcName);
        2.连接数据库 DriverManager驱动管理类  Connection数据库连接类
        3.操作数据库
        4.关闭数据库连接   最后要释放一下连接资源
2.statement接口增删改查
3.PreparedStatement接口增删改查
    比  statement接口 更效率
4.resultSet结果集
5.处理大数据
    clob：很长的字符串，比如小说  
    blob：二进制，比如照片、电影文件
6.元数据
    描述数据的数据就是元数据
    DatabaseMetaData 描述数据库
    ResultSetMetaData 描述表
7.事务
    jdbc默认是自动提交，修改成不自动提交，然后cache到异常的时候 rollback一下             