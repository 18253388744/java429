package com.wdsjol.servlet.home;

import com.wdsjol.config.SpringConfig;
import com.wdsjol.entity.User;
import com.wdsjol.service.impl.HomeInfoServiceImpl;
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

@WebServlet(name = "InfoServlet",urlPatterns = "/home/info")
public class InfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        User user =(User)session.getAttribute("user");
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfig.class);
        HomeInfoServiceImpl info = app.getBean(HomeInfoServiceImpl.class);
        if ("info".equals( request.getParameter("do"))){
            out.print(info.getInfo(user.));
        }else if ("qd".equals( request.getParameter("do"))){

        }
    }
}
