package com.wdsjol.servlet;

import com.wdsjol.config.SpringConfig;
import com.wdsjol.entity.User;
import com.wdsjol.service.StudentListService;
import com.wdsjol.service.impl.UserServiceImpl;
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

@WebServlet(name = "UserServlet",urlPatterns = "/user/user")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserServiceImpl bean = app.getBean(UserServiceImpl.class);
        if ("add".equals(request.getParameter("do"))){
            String phone = request.getParameter("phone");
            String mima = request.getParameter("mima");
            String username = request.getParameter("username");
            String sex = request.getParameter("sex");
            String data = request.getParameter("data");

            out.print(bean.add(phone,mima,username,sex,data));
        }else if ("dl".equals(request.getParameter("do"))){
            String phone = request.getParameter("phone");
            String mima = request.getParameter("mima");
            User user = bean.dl(phone,mima);
            if (user!=null) {
                HttpSession session = request.getSession();
                session.setAttribute("user",user);
                out.print(1);
            }else {
                out.print(0);
            }
        }else if ("exit".equals(request.getParameter("do"))) {
            HttpSession session = request.getSession();
            session.removeAttribute("user");
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath+"/index.html");
        }
    }
}
