package it.web;

import it.Dao.UserDao;
import it.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        /*//获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //封装user对象
        User loginuser = new User();
        loginuser.setUsername(username);
        loginuser.setPassword(password);*/

        //一次性获取所有的请求参数，使用工具类来封装
        Map<String,String[]> map = request.getParameterMap();
        //创建User对象
        User loginuser = new User();
        //使用BeanUtils工具类封装
        try {
            BeanUtils.populate(loginuser,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        System.out.println("LoginServlet测试："+loginuser);

            //调用login方法
            UserDao userDao = new UserDao();
            User user = userDao.login(loginuser);

            //判断
            if(user != null){
                //登录成功
                //存储数据并转发
                request.setAttribute("user",user);
                request.getRequestDispatcher("/successServlet").forward(request,response);

            }else {
            //失败
            request.getRequestDispatcher("/failServlet").forward(request,response);
        }
    }
}
