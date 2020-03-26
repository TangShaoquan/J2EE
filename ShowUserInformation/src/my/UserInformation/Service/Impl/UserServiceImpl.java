package my.UserInformation.Service.Impl;

import my.UserInformation.Dao.Impl.UserDaoImpl;
import my.UserInformation.Dao.UserDao;
import my.UserInformation.Domain.PageBean;
import my.UserInformation.Domain.User;
import my.UserInformation.Service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();
    @Override
    public List<User> findAll() {
        /*调用Dao进行查询*/
        return dao.findAll();
    }

    @Override
    public boolean login(User user) {

        if(dao.login(user)!=null)
            return true;
        else
            return false;
    }

    @Override
    public void addUser(User user) {
        dao.add(user);
    }

    public void delete(String id) {
        dao.delete(id);
    }

    public User findUserById(String id){
        return dao.findUserById(Integer.parseInt(id));
    }

    public void update(User user){
        dao.update(user);
    }

    @Override
    public void delSelecte(String[] ids) {
        for (String id:ids
             ) {
            dao.delete(id);
        }
    }

    @Override
    public PageBean<User> findUserByPage(int current, int rows, Map<String, String[]> parameterMap) {


        //1. 创建空的PageBean对象
        PageBean<User> userPageBean = new PageBean<>();
        //设置参数
        userPageBean.setCurrentPage(current);
        userPageBean.setRows(rows);

        //查询总数
        userPageBean.setTotalCount(dao.findTotalcount( parameterMap));//传的参数是体哦傲剑

        //开始索引
        int start = (current-1) * rows;
        List byPage = dao.findByPage(start, rows,parameterMap);

        //设置list
        userPageBean.setList(byPage);

        //设置总页数
        userPageBean.setTotalPage((dao.findTotalcount(parameterMap) % rows == 0) ? (dao.findTotalcount(parameterMap) / rows) : (dao.findTotalcount(parameterMap) / rows +1));

        return userPageBean;
    }
}
