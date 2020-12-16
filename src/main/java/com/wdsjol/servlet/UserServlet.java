package com.wdsjol.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserServlet",urlPatterns = "/user/user")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phone = request.getParameter("do");
        if ("add".equals(phone)){
            String mima = request.getParameter("mima");
            String username = request.getParameter("username");
            String data = request.getParameter("data");
            PrintWriter out = response.getWriter();
            if (mima.equals("123")){
                out.print(1);
            }else {
                out.print(0);
            }

        }
    }
}
