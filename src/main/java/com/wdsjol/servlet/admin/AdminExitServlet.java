package com.wdsjol.servlet.admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
/**
 *  admin后台退出
 *  翔哥 2020-12-2
 */
@WebServlet(name = "adminExitServlet",urlPatterns = "/admin/exit")
public class AdminExitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("admin");
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath+"/admin/user/login.html");
    }
}
