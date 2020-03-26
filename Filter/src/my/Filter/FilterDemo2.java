package my.Filter;

import javax.servlet.*;
import java.io.IOException;

public class FilterDemo2 implements Filter{
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("FilterDemo2被执行了");
        //放行
        chain.doFilter(req,resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
