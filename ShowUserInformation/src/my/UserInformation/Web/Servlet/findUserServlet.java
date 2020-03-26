package my.UserInformation.Web.Servlet;

import my.UserInformation.Dao.Impl.UserDaoImpl;
import my.UserInformation.Domain.User;
import my.UserInformation.Service.Impl.UserServiceImpl;
import my.UserInformation.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findUserServlet")
public class findUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取id
        String id = request.getParameter("id");
        //根据id查询
        System.out.println(id);
        UserService userService = new UserServiceImpl();
        User userById = userService.findUserById(id);
        //存user
        request.setAttribute("user",userById);
        //转发到update.jsp页面
        request.getRequestDispatcher("/update.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
