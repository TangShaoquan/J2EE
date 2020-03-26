package my.UserInformation.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/*")
public class SensytiveWordsFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //创建代理对象，增强getParametetr
       /* ServletRequest proxyInstance = (ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //增强getParameter()
                //判断是否是getParameter()
                if(method.equals("getParameter")){
                    //增强返回值
                    //1. 获取返回值。把敏感词获取放到init里就只用加载一次
                    String value = (String) method.invoke(req,args);
                    //判断返回值是否为空
                    if(value!=null){
                        for (String str:
                        list     ) {
                            if(value.contains("str")){
                                value = value.replaceAll(str,"***");
                            }
                        }
                    }
                    return value;

                }
                return method.invoke(req,args);
            }
        });*/

        ServletRequest proxy_req = (ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //增强getParameter方法
                //判断是否是getParameter方法
                if(method.getName().equals("getParameter")){
                    //增强返回值
                    //获取返回值
                    String value = (String) method.invoke(req,args);
                    if(value != null){
                        for (String str : list) {
                            if(value.contains(str)){
                                value = value.replaceAll(str,"***");
                            }
                        }
                    }

                    return  value;
                }

                //判断方法名是否是 getParameterMap

                //判断方法名是否是 getParameterValue

                return method.invoke(req,args);
            }
        });


        // req.getParameter()
        chain.doFilter(proxy_req, resp);
    }

    private List<String> list= new ArrayList<String>();
    public void init(FilterConfig config) throws ServletException {

        try{
            //1. 获取文件真是路径
            ServletContext servletContext = config.getServletContext();
            String realPath = servletContext.getRealPath("/WEB-INF/classes/敏感词汇.txt");

            //读取文件
            BufferedReader bufferedReader = new BufferedReader(new FileReader(realPath));
            //每一行都添加大list中
            String line = null;
            while ((line = bufferedReader.readLine())!=null){
                list.add(line);
            }
            bufferedReader.close();
            System.out.println(list);


        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

}
