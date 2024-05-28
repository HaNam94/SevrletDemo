package org.example.demo;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class First  implements Servlet {
    ServletConfig config = null;

    public void init(ServletConfig config){
        this.config=config;
        System.out.println("servlet is initialized");
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.print("");
        out.print("hello simple servlet");
        out.print("");
    }

    @Override
    public String getServletInfo() {
        return "copyright";
    }

    @Override
    public void destroy() {
        System.out.println("servlet is destroyed");
    }
}
