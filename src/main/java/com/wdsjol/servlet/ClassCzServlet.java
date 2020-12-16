package com.wdsjol.servlet;

import com.wdsjol.config.SpringConfig;
import com.wdsjol.service.ClassCzService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ClassCzServlet",urlPatterns = "/admin/user/user/classcz")
public class ClassCzServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfig.class);
        ClassCzService classCzService = app.getBean(ClassCzService.class);
        String cz = request.getParameter("cz");
        if ("getinfo".equals(cz)){
            out.print(classCzService.getInfo());
        }
    }
}
