package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.Userservice;
import cn.itcast.travel.util.MailUtils;
import cn.itcast.travel.util.UuidUtil;

public class UserserviceImpl implements Userservice {
    @Override
    public boolean regist(User user) {
        UserDao userDaoImpl = new UserDaoImpl();
        User byUsername = userDaoImpl.findByUsername(user.getUsername());
        //判断byUsername是否为null
        //不为空则存在，注册失败
        if (byUsername!=null){
            return false;
        }


        //保存用户前要验证激活
        //2.1 设置唯一激活码 Uuid类
        user.setCode(UuidUtil.getUuid());
        user.setStatus("N");//没有激活
        userDaoImpl.save(user);
        //3. 发送邮件激活
        String text = "<a href='http://localhost/travel/activeUserServlet?code="+user.getCode()+"'>点击激活</a>";
        MailUtils.sendMail(user.getEmail(),text,"点击激活");
        //没有查询到，则用户名可用

        return true;
    }

    @Override
    public boolean active(String code) {
        //根据激活码查询用户对象，如果用户对象存在就返回正确
        UserDao userDao = new UserDaoImpl();
        User user = userDao.findByCode(code);

        //调用Dao修改激活状态的方法
        if(user!=null){
            userDao.updateStatus(user);
            return true;
        }else {
            return false;
        }

    }

}
