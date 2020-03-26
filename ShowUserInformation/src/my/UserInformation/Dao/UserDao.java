package my.UserInformation.Dao;

import my.UserInformation.Domain.User;

import java.util.List;
import java.util.Map;

/*
用户操作的Dao
 */
public interface UserDao {

    public List<User> findAll();
    public User login(User user);
    public void add(User user);
    public void delete(String id);
    public User findUserById(int id);
    public void update(User user);
    public List findByPage(int currentPage,int rows,Map<String, String[]> parameterMap);
    public int findTotalcount(Map<String, String[]> parameterMap);
}
