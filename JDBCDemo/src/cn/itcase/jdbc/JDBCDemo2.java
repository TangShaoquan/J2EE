package cn.itcase.jdbc;

import org.w3c.dom.ls.LSOutput;

import java.sql.*;

public class JDBCDemo2 {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement stmt = null;
        try{
            //1. 注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取数据库连接对象
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","admin");
            //3.生成sql语句
            String sql = "insert into account values(2,'唐绍权',1500)";
            //4.获取执行的对象
            stmt = connection.createStatement();
            //执行
            int  result =  stmt.executeUpdate(sql);
            //处理结果
            System.out.println(result);
            if(result>0)
                System.out.println("成功");
            else
                System.out.println("失败");

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.getErrorCode();
        }finally {
            if(stmt != null)
                stmt.close();
            if (connection != null)
                connection.close();
        }

    }
}
