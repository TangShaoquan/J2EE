package my.Servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/findServlet")
public class findServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String username = request.getParameter("username");

        System.out.println(username);

        //response.setContentType("application/json;charset=utf-8");
        Map<String, Object> map = new HashMap<String, Object>();


        if("tom".equals(username)){
            map.put("userexits",true);
            map.put("msg","用户名太受欢迎，请更换一个");
        }else {
            map.put("userexits",false);
            map.put("msg","用户名可用");
        }
        System.out.println(map);
        //map转json对象

//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.writeValue(response.getWriter(),objectMapper);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(response.getWriter(),map);




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
