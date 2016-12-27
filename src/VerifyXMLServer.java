package com.hc.ajax;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/xmlServer")
public class VerifyXMLServer extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/xml;charset=utf-8");//设置响应的Content-Type是text/xml
            PrintWriter out = response.getWriter();
            String name = request.getParameter("name");
            StringBuilder builder = new StringBuilder();
            builder.append("<message>");
            if (name == null || name.length() == 0) {
                builder.append("用户名不能为空").append("</message>");
            } else {
                if (name.equals("hc")) {
                    builder.append("用户名[" + name + "]已经存在，请使用其他用户名").append("</message>");
                } else {
                    builder.append("用户名[" + name + "]尚未存在,可以使用该用户名").append("</message>");
                }
            }
            out.println(builder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
