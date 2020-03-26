package my.UserInformation.Web.Servlet;

import my.UserInformation.Domain.User;
import my.UserInformation.Service.Impl.UserServiceImpl;
import my.UserInformation.Service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/addUserServlet")
public class addUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 设置编码
        request.setCharacterEncoding("utf-8");
//        2. 获取参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        //3. 封装对象
        User user = new User();
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //4. 调用Service保存
        UserService userService = new UserServiceImpl();
        userService.addUser(user);

        //跳转到userListServlet;
        response.sendRedirect(request.getContextPath()+"/userlistServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}