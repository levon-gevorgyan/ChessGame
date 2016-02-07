package servlets;

import javax.servlet.http.HttpSession;
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
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        /*String userName=request.getParameter("name");
        HttpSession session=request.getSession();
        if(userName!="" && userName!=null) {
            session.setAttribute("savedName", userName);
        }
        out.println("get " + userName+"<br>");
        out.println("Session get "+(String)session.getAttribute("savedName"));*/
        out.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <script src=\"scripts/DragAndDrop.js\"></script>\n" +
                "    <script src=\"scripts/jquery-1.12.0.js\"></script>\n" +
                "\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Chess on Web</title>\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\n" +
                "</head>\n" +
                "<body>\n" +
                "<script>\n" +
                "    $(document).ready(function(){\n" +
                "        $(\"#start\").click(function(){\n" +
                "            $.get(\"test\");\n" +
                "        });\n" +
                "    });\n" +
                "</script>\n" +
                "<button id=\"start\">Start!</button>\n" +
                "<br>\n" +
                "<br>\n" +
                "<table cellpadding=\"0\" cellspacing=\"0\">\n" +
                "  <tr>\n" +
                "      <td><img id=\"a8\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"true\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"b8\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"c8\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"d8\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"e8\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"f8\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"g8\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"h8\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "      <td><img id=\"a7\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"b7\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"c7\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"d7\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"e7\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"f7\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"g7\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"h7\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "      <td><img id=\"a6\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"b6\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"c6\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"d6\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"e6\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"f6\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"g6\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"h6\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "      <td><img id=\"a5\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"b5\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"c5\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"d5\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"e5\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"f5\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"g5\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"h5\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "      <td><img id=\"a4\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"b4\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"c4\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"d4\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"e4\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"f4\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"g4\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"h4\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "      <td><img id=\"a3\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"b3\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"c3\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"d3\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"e3\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"f3\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"g3\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"h3\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "      <td><img id=\"a2\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"b2\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"c2\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"d2\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"e2\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"f2\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"g2\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"h2\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "      <td><img id=\"a1\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"b1\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"c1\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"d1\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"e1\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"f1\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"g1\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "      <td><img id=\"h1\" src=\"images/items/Empty.png\" ondrop=\"drop(event)\" ondragover=\"allowDrop(event)\" draggable=\"false\" ondragstart=\"drag(event)\"></td>\n" +
                "  </tr>\n" +
                "</table>\n" +
                "</body>\n" +
                "</html>");
    }
}
