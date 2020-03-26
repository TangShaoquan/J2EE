package Servlet;

import Dao.Impl.PrivnceDaoImpl;
import Dao.PrivnceDao;
import Service.Impl.PrivnceServiceIpl;
import Service.PrivnceService;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Province;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findProvienceServlet")
public class findProvienceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //1. 调用Service查询
//        PrivnceDao privnceDao = new PrivnceDaoImpl();
//        List<Province> list = privnceDao.findall();
//
//        //序列化结果，设置为JSON
//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(list);
//
//        System.out.println(json);
//        //响应结果
//        response.setContentType("application/json;charset=utf-8");
//        response.getWriter().write(json);
        //直接调用findallFromRedis返回字符串
        response.setContentType("application/json;charset=utf-8");
        PrivnceService privnceServiceIpl = new PrivnceServiceIpl();
        response.getWriter().write(privnceServiceIpl.findallFromRedis());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
