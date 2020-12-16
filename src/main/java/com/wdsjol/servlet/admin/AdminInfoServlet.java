package com.wdsjol.servlet.admin;

import com.wdsjol.config.SpringConfig;

import com.wdsjol.service.AdminInfoService;

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
 *  admin主页信息
 *  翔哥 2020-12-3
 */
@WebServlet(name = "AdminInfoServlet",urlPatterns = "/admin/home/info")
public class AdminInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfig.class);
        AdminInfoService adminInfo = app.getBean(AdminInfoService.class);
        PrintWriter out = response.getWriter();
        out.print(adminInfo.getInfo());
    }
            }
