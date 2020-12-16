package com.wdsjol.servlet;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import com.wdsjol.config.SpringConfig;
import com.wdsjol.service.StudentListService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "StudentListServlet",urlPatterns = "/admin/user/user/studentList")
public class StudentListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfig.class);
        StudentListService bean = app.getBean(StudentListService.class);
        PrintWriter out = response.getWriter();
        if ("tj".equals(request.getParameter("cx"))){
            //单独搜索
            out.print(bean.getInfoTj(request.getParameter("name"),request.getParameter("zy"),request.getParameter("classname"),request.getParameter("sex")));


        }else {
            out.print(bean.getInfo(0,100000));
        }


    }
}
