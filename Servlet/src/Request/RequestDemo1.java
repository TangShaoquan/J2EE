package Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RequestDemo1")
public class RequestDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*方法：

        1. 获取请求方式 ：GET   String getMethod()
        2. 获取虚拟目录：String getContextPath()
        3. 获取Servlet路径: String getServletPath()
        4. 获取get方式请求参数：String getQueryString()
        5. 获取请求URI：
        - String getRequestURI()；返回/day/demo
                - StringBuffer getRequestURL(): 返回http://localhost/day14/demo1
        -  URL:统一资源定位符 ：http://localhost/day14/demo1	中华人民共和国
        - URI：统一资源标识符：/day14/demo1			共和国
        6. 获取协议及版本：HTTP/1.1：String getProtocol()
        7. 获取客户机的IP地址：String getRemoteAddr()*/
        String method = request.getMethod();
        System.out.println(method);
        String contextPath = request.getContextPath();
        System.out.println(contextPath);
        String servletPath = request.getServletPath();
        System.out.println(servletPath);
        String queryString = request.getQueryString();
        System.out.println(queryString);
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURL);
        String protocol = request.getProtocol();
        System.out.println(protocol);
        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr);



    }
}
