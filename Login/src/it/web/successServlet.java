package it.web;

import it.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/successServlet")
public class successServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取对象
        User user = (User) request.getAttribute("user");
        String username = user.getUsername();
        //给页面写一句话
        //设置编码
        response.setCharacterEncoding("utf-8");
        //输出
        response.getWriter().write("Success!"+username+",Welcom you!");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
