package org.scoula.dynamicweb;

import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PersonServlet", value = "/babo")
public class PersonServlet extends HttpServlet {

    String name = "홍길동";
    int age = 20;

    @Override
    public void init(){
        System.out.println("PersonServlet.init");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        System.out.println("PersonServlet.doGet");

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<body>");
        age++;
        out.println("나의 이름은 " + name + "이고, 나의 나이는 " + age + "이다");
        out.println("</body>");
        out.println("</html>");
    }
}
