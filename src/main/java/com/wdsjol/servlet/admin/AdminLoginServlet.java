package com.wdsjol.servlet.admin;

import com.wdsjol.config.SpringConfig;
import com.wdsjol.entity.admin.AdminUser;
import com.wdsjol.service.LoginService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
/**
 *  admin后台登陆
 *  翔哥 2020-12-2
 */
@WebServlet(name = "AdminLogin",urlPatterns = "/admin/user/adminlogin")
public class AdminLoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfig.class);
        LoginService loginService = app.getBean(LoginService.class);
        AdminUser adminUser = loginService.login(request.getParameter("name"),request.getParameter("mima"));
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        if(adminUser!=null){
            session.setAttribute("admin",adminUser);
            out.print(1);
        }else{
            out.print(0);
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
