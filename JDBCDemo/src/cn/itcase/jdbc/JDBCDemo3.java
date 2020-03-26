package cn.itcase.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo3 {
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        try{
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取数据库链接对象
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","admin");
            //3.生成sql语句
            String sql = "update account set balance = 2000 where id = 1";
            //4.获取sql执行对象
            statement = connection.createStatement();
            //5.执行sql语句
            int result = statement.executeUpdate(sql);
            if(result > 0)
                System.out.println("成功");
            else
                System.out.println("失败");
        } catch (ClassNotFoundException exception){
            exception.printStackTrace();
        } catch (SQLException sqlexception){
            sqlexception.printStackTrace();
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
