package my.UserInformation.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpRequest;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        //1. 强制转换req
        HttpServletRequest request = (HttpServletRequest) req;
        //2. 获取资源请求路径
        String requestURL = request.getRequestURI();
        //3. 判断是否包含登录相关资源路径,要注意排除css/js/图片/验证码等资源
        if(requestURL.contains("/login.jsp") || requestURL.contains("/loginServlet") || requestURL.contains("/css/") || requestURL.contains("/js") || requestURL.contains("/fonts") || requestURL.contains("/CheckCodeServlet")){
            //证明想要登录，直接放行
            chain.doFilter(req, resp);
        }
        else {
            //不包含，需要验证用户是否登录。从session获取用户信息
            Object user = request.getSession().getAttribute("user");
            if(user!=null){
                //不为空
                chain.doFilter(req, resp);
            }
            else{
                request.setAttribute("login_msg","您尚未登录，请登录！");
                request.getRequestDispatcher("/login.jsp").forward(request,(HttpServletResponse)resp);
            }
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
