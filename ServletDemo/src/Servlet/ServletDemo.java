package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/ServletDemo")
public class ServletDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        System.out.println("post");
        System.out.println(username);
        //获取复选框的名称
        String[] hobbies = request.getParameterValues("hobby");
        for (String hobby:hobbies) {
            System.out.println(hobby);
        }

        //获取所有参数的请求名称
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String s = parameterNames.nextElement();
            System.out.println(s);
            //根据属性名获取值
            String parameter = request.getParameter(s);
            //只能获取一个
            System.out.println(parameter);
        }

        //获取所有参数的map集合
        Map<String, String[]> parameterMap = request.getParameterMap();
        //遍历
        Set<String> KeySet = parameterMap.keySet();
        for (String name: KeySet
             ) {
            //根据键获取值
            String[] strings = parameterMap.get(name);
            for(String value : strings){
                System.out.println(value);
                System.out.println("-------------------------------------------------");
            }

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println("get");
        System.out.println(username);
        this.doPost(request,response);

    }
}
