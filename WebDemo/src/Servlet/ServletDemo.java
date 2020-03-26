package Servlet;

import javax.servlet.*;
import java.io.IOException;

public class ServletDemo implements Servlet {
    /*
    初始化方法
    在创建时执行，只执行一次
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init....");
    }

   /* 获取servlet配置对象*/
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    //提供服务的方法
    /*每次访问都会执行*/
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Hello Servlet");
    }

    /*获取servlet的信息，版本、作者之类的*/
    @Override
    public String getServletInfo() {
        return null;
    }

    //servlet被杀死时执行。
    @Override
    public void destroy() {
        System.out.println("des......");

    }
}
