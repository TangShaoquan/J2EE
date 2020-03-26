package cn.itcase.jdbc;

import java.sql.*;

public class JDBCDemo4 {
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取数据库链接对象
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","admin");
            //3.生成sql语句
            String sql = "select * from account";
            //4.获取sql执行对象
            statement = connection.createStatement();
            //5.执行sql语句
            resultSet = statement.executeQuery(sql);
            //6.处理结果
            //6.1 让游标下移动一行
            while (resultSet.next()){
                    //6.2获取数据
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString("na");
                    int balance = resultSet.getInt(3);

                    System.out.println(id + "---"+name+"---"+balance);
            }



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
