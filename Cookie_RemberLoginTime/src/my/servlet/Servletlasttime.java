package my.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
1. 需求：
		1. 访问一个Servlet，如果是第一次访问，则提示：您好，欢迎您首次访问。
		2. 如果不是第一次访问，则提示：欢迎回来，您上次访问时间为:显示时间字符串

	2. 分析：
		1. 可以采用Cookie来完成
		2. 在服务器中的Servlet判断是否有一个名为lastTime的cookie
			1. 有：不是第一次访问
				1. 响应数据：欢迎回来，您上次访问时间为:2018年6月10日11:50:20
				2. 写回Cookie：lastTime=2018年6月10日11:50:01
			2. 没有：是第一次访问
				1. 响应数据：您好，欢迎您首次访问
				2. 写回Cookie：lastTime=2018年6月10日11:50:01
 */
@WebServlet("/Servletlasttime")
public class Servletlasttime extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/htnl;charset=utf-8");

        //1. 获取所有ccokie
        Cookie[] cookies = request.getCookies();

        //flag false表示没有cookie为lasttime
        boolean flag = false;
        if(cookies != null && cookies.length >0){
            for (Cookie cookie: cookies
                 ) {
                //3. 获取cookie的名称
                String name = cookie.getName();
                if("lasttime".equals(name)){


                    //响应数据
                    //获取Cookie的响应数据value，即事件.获取的是上一次的cookie
                    String value = cookie.getValue();
                    System.out.println("解码前："+value);
                    //解码
                    value = URLDecoder.decode(value,"utf-8");
                    System.out.println("解码后："+value);
                    response.getWriter().write("<h1>欢迎回来，您上次访问时间为："+value+"!<h1>");




                    //有该Cookie，不是第一次访问
                    flag = true;

                    //设置Cookie的Value
                    //获取当前事件的字符串，重新设置Cookie的值，重新发送Cookie
                    Date date = new Date();//美国时间
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");//设置成中国时间
                    //解析时间格式
                    String format = sdf.format(date);

                    System.out.println("编码前："+format);
                    //URL 编码
                    format = URLEncoder.encode(format,"utf-8");
                    System.out.println("编码后："+format);


                    //设置Cookie的时间,存活一个月
                    cookie.setMaxAge(60*60*24*30);
                    //设置Cookie
                    cookie.setValue(format);
                    response.addCookie(cookie);//发送Cookie


                    break;
                }
            }
        }
        if(cookies == null || cookies.length ==0 || flag == false){

            //设置Cookie的Value
            //获取当前事件的字符串，重新设置Cookie的值，重新发送Cookie
            Date date = new Date();//美国时间
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");//设置成中国时间
            //解析时间格式
            String format = sdf.format(date);
            System.out.println("编码前："+format);
            //URL 编码
            format = URLEncoder.encode(format,"utf-8");
            System.out.println("编码后："+format);



            //设置Cookie
            Cookie cookie = new Cookie("lasttime",format);
            //设置Cookie的时间,存活一个月
            cookie.setMaxAge(60*60*24*30);
            response.addCookie(cookie);//发送Cookie

            response.getWriter().write("<h1>欢迎访问，这是您第一次访问！<h1>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
