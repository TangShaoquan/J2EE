package my.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class FilterDemo3 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //req可以对请求参数进行操作
        System.out.println("filterDemo3放行了");

        chain.doFilter(req, resp);

        System.out.println("filterDemo3回来了");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
