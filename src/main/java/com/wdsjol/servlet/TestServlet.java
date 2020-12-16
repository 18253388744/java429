package com.wdsjol.servlet;
import com.wdsjol.config.SpringConfig;
import com.wdsjol.dao.impl.UserTypeDaoImpl;
import com.wdsjol.entity.UserType;
import com.wdsjol.service.TestService;
import com.wdsjol.service.impl.TestServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servlet" )
public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfig.class);
        TestService testService = (TestService)app.getBean(TestService.class);
        testService.test();
    }
}