package Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RequestDemo4")
public class RequestDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取user-agent,用于判断浏览器的版本
        String header = request.getHeader("referer");
        System.out.println(header);
        if(header != null){
            if(header.contains("/Servlet"))
                System.out.println("/Servlet");
            else
                System.out.println("无");
        }


    }
}
