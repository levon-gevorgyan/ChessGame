package servlets;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Levon on 2/5/2016, 10:29 PM
 */
@javax.servlet.annotation.WebServlet(name = "SimpleServlet",urlPatterns = "/test")
public class SimpleServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        PrintWriter printWriter=response.getWriter();
        printWriter.println("<h1>yes</h1>");
    }
}
