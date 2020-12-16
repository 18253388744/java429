package com.wdsjol.servlet;

import com.wdsjol.config.SpringConfig;
import com.wdsjol.service.StuCzService;
import com.wdsjol.service.StudentListService;
import com.wdsjol.service.impl.StuCzServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
/**
 *  学生增删改
 *  翔哥 2020-12-6
 */
@WebServlet(name = "StuCzServlet",urlPatterns = "/admin/user/user/stucz")
public class StuCzServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String cz = request.getParameter("cz");
        PrintWriter out = response.getWriter();
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfig.class);
        StuCzService stuCz = app.getBean(StuCzServiceImpl.class);
        if ("del".equals(cz)&request.getParameter("id")!=null){
            int id = Integer.parseInt(request.getParameter("id"));
            out.print(stuCz.del(id));
        }else if("add".equals(cz)&request.getParameter("name")!=null&request.getParameter("sexid")!=null&request.getParameter("classid")!=null&request.getParameter("birthday")!=null&request.getParameter("zyid")!=null&request.getParameter("tel")!=null&request.getParameter("text")!=null){
           String name = request.getParameter("name");
           String birthday = request.getParameter("birthday");
           String tel = request.getParameter("tel");
           String text = request.getParameter("text");
           Integer classid = Integer.parseInt(request.getParameter("classid"));
           Integer sexid = Integer.parseInt(request.getParameter("sexid"));
           Integer zyid = Integer.parseInt(request.getParameter("zyid"));
           //cz=add&name=xiangge&classid=1&zyid=1&tel=18253388744&sexid=1&birthday=201925040422&text=%E5%95%8A%E5%95%8A%E5%95%8A%E5%95%8A%E5%95%8A%E5%95%8A
            out.print(stuCz.add(name,classid,birthday,sexid,zyid,tel,text));
        }else if("update".equals(cz)){
            out.print(0);
        }else{
            out.print(0);
        }
    }
}
