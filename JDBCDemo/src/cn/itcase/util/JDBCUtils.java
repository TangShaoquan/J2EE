package cn.itcase.util;


import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {


    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    static {
        //读取资源文件,获取值
        //1.创建Properties集合类
        Properties properties = new Properties();
        //2.加载文件

        /*
        //获取src路径下的文件的方式-->Classloader加载器。可以加载字节码文件进内存
        ClassLoader classLoader = JDBCUtils.class.getClassLoader();
        URL res = classLoader.getResource("jdbc.properties");//获取该文件的统一资源定位符
        String path = res.getPath();//动态获取绝对路径
        System.out.println(path);
        try {
            //路径会有问题，需要处理
            properties.load(new FileReader(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
         */

           try {
            //路径会有问题，需要处理
            properties.load(new FileReader("src/jdbc.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //3. 获取数据
        url = properties.getProperty("url");
        user = properties.getProperty("user");
        password = properties.getProperty("password");
        driver = properties.getProperty("driver");

        //注册驱动
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    /*
     *只需要读取一次配置文件，使用静态代码块
     */
    /*
     *获取链接
     * @return 连接对象
     */
    public static Connection getConnection() throws SQLException {
        return (Connection) DriverManager.getConnection(url, user, password);
    }

    /*
     * 释放资源,关闭statement和connection
     */
    public static void close(Statement statement, Connection connection){
        if(statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(ResultSet resultSet,Statement statement, Connection connection){

        if(resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



}
