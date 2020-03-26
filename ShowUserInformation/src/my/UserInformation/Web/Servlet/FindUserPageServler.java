package my.UserInformation.Web.Servlet;

import my.UserInformation.Domain.PageBean;
import my.UserInformation.Domain.User;
import my.UserInformation.Service.Impl.UserServiceImpl;
import my.UserInformation.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/FindUserPageServler")
public class FindUserPageServler extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");

        if(currentPage == null || "".equals((rows)) || Integer.parseInt(currentPage)<=1){//后面是防止点<<时出错
            currentPage = "1";
        }
        if(rows == null || "".equals(rows)){
            rows ="8";
        }

        //获取条件查询的参数

        Map<String, String[]> parameterMap = request.getParameterMap();
        
        System.out.println("map.size()"+parameterMap.size());
        UserService userService = new UserServiceImpl();
        PageBean<User> userByPage = userService.findUserByPage(Integer.parseInt(currentPage), Integer.parseInt(rows),parameterMap);//Map是条件查询的参数




        System.out.println(currentPage+rows);
        System.out.println(userByPage);
        request.setAttribute("page",userByPage);
        request.setAttribute("parameterMap",parameterMap);

        request.getRequestDispatcher("/list.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
