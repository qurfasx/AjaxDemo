package com.hc.ajax;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

@WebServlet("/verifyServer")
public class VerifyServer extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String old = request.getParameter("name");

        if (old == null || old.length() == 0) {
            out.println("用户名不能为空");
        } else {
            String name = URLDecoder.decode(old,"UTF-8");
            if (name.equals("hc")) {
                out.println("用户名[" + name + "]已经存在，请使用其他用户名");
            } else {
                out.println("用户名[" + name + "]尚未存在,可以使用该用户名");
            }
        }
    }
}

