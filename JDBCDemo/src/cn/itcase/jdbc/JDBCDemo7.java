package cn.itcase.jdbc;

import cn.itcase.util.JDBCUtils;
import com.sun.source.tree.BreakTree;

import javax.sound.midi.Soundbank;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/*
 *练习
 *  需求：
 *      1. 通过键盘录入用户名和密码
 *      2. 判断用户是否登录成功
 */
public class JDBCDemo7 {
    public static void main(String[] args) {
        //键盘录入，接受用户名和密码
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = sc.nextLine();
        System.out.println("请输入密码：");
        String password = sc.nextLine();
        //调用方法
        boolean flag = new JDBCDemo7().login(username,password);
        //判断是否登录
        if(flag)
            System.out.println("成功");
        else
            System.out.println("失败");
    }
    public boolean login(String username , String password){
        if(username == null || password == null)
            return false;

        //连接数据库判断登录是否成功
        //1.获取连接
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            //定义SQL
            String sql = "select * from user where username = ? and password = ?";
            //获取执行sql的对象
            statement = connection.prepareStatement(sql);
            //赋值
            statement.setString(1,username);
            statement.setString(2,password);
            //执行
            resultSet = statement.executeQuery();
            //判断。如果有一行就说明登录了
            return resultSet.next();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.close(resultSet,statement,connection);
        }
        return false;
    }
}
