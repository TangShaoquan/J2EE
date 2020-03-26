package it.Dao;

import it.domain.User;
import it.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


/*
操作数据库表的类
 */
public class UserDao {

    //声明一个JDBCTemplate对象公用
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    //登录方法
    //@return 返回的数据包含用户全部数据
    public User login(User loginuser){
        try{
            //定义SQl
            String sql = "select * from user where username = ? and password = ?";
            //使用查询
            User user = jdbcTemplate.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginuser.getUsername(),loginuser.getPassword());
            System.out.println("LoginDao测试："+loginuser);

            return user;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
