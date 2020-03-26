package my.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(value = "/index.jsp",dispatcherTypes = DispatcherType.FORWARD)//转发访问时才拦截
public class FilterDemo7 implements Filter {

    /*在服务器正常关闭后销毁filter对象，调用destroy()对象，执行一次*/
    public void destroy() {
        System.out.println("destory……");
    }

    /*每请求一次拦截url就被执行一次*/
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //req可以对请求参数进行操作
        System.out.println("FilterDemo7放行了");

        chain.doFilter(req, resp);

        System.out.println("FilterDemo7回来了");
    }

    /*在服务器启动后创建filter对象，调用init对象，执行一次*/
    public void init(FilterConfig config) throws ServletException {
        System.out.println("init……");
    }

}
