package com.wdsjol.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
/**
 *  admin后台登陆拦截器
 *  翔哥 2020-11-27
 */
@WebFilter(filterName = "AdminFilter",urlPatterns = "/admin/*")
public class AdminFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest servletRequest = (HttpServletRequest) req;
        HttpServletResponse servletResponse = (HttpServletResponse) resp;
        String requestUri = servletRequest.getRequestURI();
        HttpSession session = servletRequest.getSession();
        String contextPath = servletRequest.getContextPath();
        String url = requestUri.substring(contextPath.length());
        if (session.getAttribute("admin")!= null){
            chain.doFilter(req, resp);
        }else{
            if (url.indexOf("/admin/user/") > -1){
                chain.doFilter(req, resp);
            }else {
                servletResponse.sendRedirect(contextPath+"/admin/user/login.html" );
            }

        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
