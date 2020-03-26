package it.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

//工具类
public class JDBCUtils {
    private static DataSource dataSource;

    static {
        //加载配置文件
        Properties properties = new Properties();
        //使用Classloader获取字节输入流
        InputStream resourceAsStream = JDBCUtils.class.getClassLoader().getResourceAsStream("durid.properties");
        try {
            properties.load(resourceAsStream);
            //初始化连接池对象
            dataSource = DruidDataSourceFactory.createDataSource(properties);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /*
    获取连接池对象
     */
    public static DataSource getDataSource(){
        return dataSource;
    }

    /*
    获取Connection对象
     */

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
