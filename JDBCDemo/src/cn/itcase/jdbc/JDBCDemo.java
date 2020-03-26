package cn.itcase.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDemo {
    public static void main(String[] args) throws Exception {
        //导入jar包
        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获取数据库链接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","admin");
        //定义SQL语句
        String sql = "update stu set sn = 'TES' where sid = 1";
        //获取执行sql的对象
        Statement smt = connection.createStatement();
        //执行sql
        int count = smt.executeUpdate(sql);
        System.out.println(count);
        smt.close();;
        connection.close();
    }
}
