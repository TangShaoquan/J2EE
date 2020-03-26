package my.Web.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
重定向
 */
@WebServlet("/ResponseDemo1")
public class ResponseDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* //访问ResponseDemo1会自动跳转到Response Demo2
        System.out.println("ResponseDemo1被访问了");
        //设置状态码为302
        response.setStatus(302);
        //设置响应头为location
        response.setHeader("location","/Response/ResponseDemo2");
*/
        /*有一种简单的重定向方法：*/
        response.sendRedirect("https://www.baidu.com");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
