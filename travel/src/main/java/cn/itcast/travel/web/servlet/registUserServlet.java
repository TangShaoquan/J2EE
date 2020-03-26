package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.Userservice;
import cn.itcast.travel.service.impl.UserserviceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/registUserServlet")
public class registUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //验证验证码
        String checkcode_client = request.getParameter("check");

        //从Httpsession获取验证码
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");//为了保证验证码只能使用一次


        System.out.println("cs:"+checkcode_server+"-cc:"+checkcode_client);


        if(checkcode_server == null || !checkcode_server.equalsIgnoreCase(checkcode_client)){
            //验证码错误
            //注册失败
            ResultInfo resultInfo = new ResultInfo();
            response.setContentType("application/json;charset=utf-8");
            ObjectMapper mapper = new ObjectMapper();
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("验证码错误");

            String json = mapper.writeValueAsString(resultInfo);
            response.getWriter().write(json);
            System.out.println("json1"+json);
            return;
        }


        //获取数据
        Map<String, String[]> parameterMap = request.getParameterMap();
        //封装对象
        User user = new User();

        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(user.toString());
        //调用UserServiceImp完成注册

        Userservice userservice = new UserserviceImpl();
        boolean flag = userservice.regist(user);


        ResultInfo resultInfo = new ResultInfo();
        //响应
        if(flag){
            //注册成功
            resultInfo.setFlag(true);
        }else{
            //注册失败
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("注册失败！");
        }
        //将info对象序列化，写入客户端
        //要进行设置contentType
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(resultInfo);

        response.getWriter().write(json);
        System.out.println("json2"+json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
