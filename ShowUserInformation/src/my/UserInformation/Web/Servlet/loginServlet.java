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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 设置编码
        request.setCharacterEncoding("utf-8");
        //2. 获取数据
        //2.1 获取验证码
        String verifycode = request.getParameter("verifycode");

        //4. 验证码校验
        HttpSession session = request.getSession();
        String checkcode_server = session.getAttribute("CHECKCODE_SERVER").toString();
        session.removeAttribute(verifycode);//确保验证码一次性
        if(! checkcode_server.equals(verifycode)){
            //验证码不正确
            //提示信息
            request.setAttribute("login_msg","验证码不正确");
            request.getRequestDispatcher("login.jsp").forward(request,response);
            return;
        }

        //3. 封装User对象
        Map<String, String[]> parameterMap = request.getParameterMap();

        User user = new User();
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(user);



        //5. 调用Service查询
        UserServiceImpl userService = new UserServiceImpl();
       if(userService.login(user)){
           //成功
           //存入seesion
           session.setAttribute("user",user);
           //跳转页面
           response.sendRedirect(request.getContextPath()+"/index.jsp");

       }
       else {
           //验证码不正确
           //提示信息
           request.setAttribute("login_msg","用户名或密码错误");
           request.getRequestDispatcher("login.jsp").forward(request,response);
       }
        //6. 验证登录是否成功
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
