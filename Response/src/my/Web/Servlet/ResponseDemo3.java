package my.Web.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ResponseDemo3")
public class ResponseDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码，服务器发送消息的数据如何编码，让浏览器根据编码节码
        response.setHeader("content-type","text/htnl;charset=utf-8");
        //上面的简便形式
       /* response.setContentType("text/htnl;charset=utf-8");*/
        //获取字节输出流
        PrintWriter writer = response.getWriter();
        //输出数据
        writer.write("你好,response");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
