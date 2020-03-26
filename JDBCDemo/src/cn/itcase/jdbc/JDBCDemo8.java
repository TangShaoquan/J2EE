package cn.itcase.jdbc;

import cn.itcase.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCDemo8 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement1 = null;
        PreparedStatement statement2 = null;
        try{
            //1.获取连接对象
            connection = JDBCUtils.getConnection();


            //开启事务
            connection.setAutoCommit(false);


            //2定义sql对象
            /*
            张三-500
             */
            String sql1 = "update account set balance = balance -? where id =?";
            String sql2 = "update account set balance = balance +? where id =?";
            //3.获取sql执行对象
            statement1 = connection.prepareStatement(sql1);
            statement2 = connection.prepareStatement(sql2);
            //4.设置张三
            statement1.setDouble(1,500);
            statement1.setInt(2,1);

            statement2.setDouble(1,500);
            statement2.setInt(2,2);
            //5.修改
            statement1.executeUpdate();
            statement2.executeUpdate();

            //提交事务
            connection.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if(connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }finally {
            JDBCUtils.close(statement1,connection);
            JDBCUtils.close(statement2,null);
        }
    }
}
