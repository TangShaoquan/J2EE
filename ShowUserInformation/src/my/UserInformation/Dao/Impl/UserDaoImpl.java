package my.UserInformation.Dao.Impl;

import my.UserInformation.Dao.UserDao;
import my.UserInformation.Domain.User;
import my.UserInformation.Util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<User> findAll() {
        //使用JDBC操作数据库
        //1. 定义sql
        String sql = "select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    @Override
    public User login(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        String sql = "select * from user where username = ? and password = ?";
        User user1 = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
        return user1;
    }

    @Override
    public void add(User user) {
//        1.定义sql
        String sql="insert into user values(null,?,?,?,?,?,?,null,null)";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail());
    }

    @Override
    public void delete(String id) {
        //1. 定义sql
        String sql = "delete from user where id=?";
        template.update(sql,id);
    }

    @Override
    public User findUserById(int id) {
        String sql="select * from user where id=?";
        User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
        return user;
    }

    @Override
    public void update(User user) {
        String sql = "update user set name=?, gender=?,age=?,address=?,qq=?,email=? where id=?";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail(),user.getId());
    }

    @Override
    public List findByPage(int start, int rows,Map<String, String[]> parameterMap) {

        //定义模板参数sql
        String sql = "select * from user where 1=1";
        StringBuilder stringBuilder= new StringBuilder(sql);

        Set<String> strings = parameterMap.keySet();
        //定义参数的集合
        List<Object> pa = new ArrayList<>();
        //2. 便利map
        for (String key: strings
        ) {
            String s = parameterMap.get(key)[0];
            if("".equals(s) || s == null){
                break;
            }
            if(key.equals("currentPage") || key.equals("rows")){
                continue;
            }
            stringBuilder.append(" and "+key+" like ?");//？表示参数，用SpringJDBC来传参
            pa.add("%"+s+"%");
            System.out.println(key+"   "+s);
            System.out.println(stringBuilder.toString());
        }

        System.out.println("终"+stringBuilder.toString());
        System.out.println(pa.toArray());
        for (int i = 0; i <pa.toArray().length  ; i++) {
            System.out.println(pa.toArray()[i]);
        }
        //添加分页查询到sql语句
        stringBuilder.append(" limit ?,?");
        //添加start,rows到参数列表
        pa.add(start);
        pa.add(rows);

        List<User> query = template.query(stringBuilder.toString(), new BeanPropertyRowMapper<User>(User.class), pa.toArray());
        return query;
    }

    @Override
    public int findTotalcount(Map<String, String[]> parameterMap) {
        //定义模板参数sql
        String sql = "select count(*) from user where 1=1";
        StringBuilder stringBuilder= new StringBuilder(sql);

        Set<String> strings = parameterMap.keySet();
        //定义参数的集合
         List<Object> pa = new ArrayList<>();
        //2. 便利map
        for (String key: strings
             ) {
            String s = parameterMap.get(key)[0];
            if("".equals(s) || s == null){
                break;
            }
            if(key.equals("currentPage") || key.equals("rows")){
                continue;
            }
            stringBuilder.append(" and "+key+" like ?");//？表示参数，用SpringJDBC来传参
            pa.add("%"+s+"%");
            System.out.println(key+"   "+s);
            System.out.println(stringBuilder.toString());
        }

        System.out.println("终"+stringBuilder.toString());
        System.out.println(pa.toArray());
        for (int i = 0; i <pa.toArray().length  ; i++) {
            System.out.println(pa.toArray()[i]);
        }

        return template.queryForObject(stringBuilder.toString(),Integer.class,pa.toArray());
    }
}
