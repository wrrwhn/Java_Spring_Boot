package com.yao;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Creator: Yao
 * Date:    2018/10/31
 * For:
 * Other:
 */
@WebServlet(urlPatterns = "/hello", description = "Hello.Servlet")
public class HelloServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        PrintWriter writer = res.getWriter();
        writer.print("Hello");
        writer.flush();
        writer.close();
    }
}
