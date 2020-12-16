package com.wdsjol.servlet;

import com.wdsjol.config.SpringConfig;
import com.wdsjol.service.impl.ZyCzServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ZyCzServlet",urlPatterns = "/admin/user/user/zycz")
public class ZyCzServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfig.class);
        ZyCzServiceImpl zyCz = app.getBean(ZyCzServiceImpl.class);
        String cz = request.getParameter("cz");
        if ("getinfo".equals(cz)){
            out.print(zyCz.getZyInfo());
        }

    }
}
