package com.wdsjol.servlet.admin;

import com.wdsjol.config.SpringConfig;
import com.wdsjol.entity.admin.AdminUser;
import com.wdsjol.service.SetPasswordService;
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
 *  admin后台修改密码
 *  翔哥 2020-12-3
 */
@WebServlet(name = "AdminSetPasswordServlet",urlPatterns = "/admin/set/user/setpassword")
public class AdminSetPasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String mima = request.getParameter("mima");
        HttpSession session = request.getSession();
        AdminUser adminUser = (AdminUser) session.getAttribute("admin");
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfig.class);
        SetPasswordService setPasswordService = app.getBean(SetPasswordService.class);
        PrintWriter out = response.getWriter();
        out.print(setPasswordService.setPassworld(adminUser,name,mima));
    }

}
