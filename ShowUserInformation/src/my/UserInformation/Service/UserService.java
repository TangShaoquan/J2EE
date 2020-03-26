package my.UserInformation.Service;

import my.UserInformation.Domain.PageBean;
import my.UserInformation.Domain.User;

import java.util.List;
import java.util.Map;

/*用户管理的业务接口*/
public interface UserService {
    /*
    查询所有用户信息
    @return
     */
    public List<User> findAll();
    public boolean login(User user);
    public void addUser(User user);
    public User findUserById(String id);
    public void update(User user);
    public void delSelecte(String[] ids);
    //分页查询，分页条件查询
    public PageBean<User> findUserByPage(int current, int rows, Map<String, String[]> parameterMap);
}
