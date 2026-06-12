package org.scoula.dynamicweb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="AddServlet", value = "/add")
public class AddServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int a = 25;
        int b = 36;
        int result = a+b;

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println(a + "+" + b + "=" + result);
        out.println("<br></br>");
        out.println("<input type = 'button' value='메인화면' onclick = location.href='http://localhost:8080/'>");
        out.println("</body>");
        out.println("</html>");
    }

}
