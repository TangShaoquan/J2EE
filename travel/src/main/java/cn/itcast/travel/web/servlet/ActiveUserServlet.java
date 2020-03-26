package cn.itcast.travel.web.servlet;

import cn.itcast.travel.service.Userservice;
import cn.itcast.travel.service.impl.UserserviceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/activeUserServlet")
public class ActiveUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取激活码
        String code = request.getParameter("code");
        System.out.println("code:"+code);
        if(code!=null){
            /*
            激活码非空
            调用服务层
            */
            Userservice userservice = new UserserviceImpl();
            //调用函数进行激活
            boolean flag = userservice.active(code);

            //
            String msg = null;
            if(flag){
                //成功
                msg = "激活成功！请<a href='login.html' >登录</a>";
            }else {
                //失败
                msg = "激活失败！请练习管理员！";
            }
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(msg);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
        //以get方式发送的请求，没有这句话就没办法被doPost处理
    }
}
