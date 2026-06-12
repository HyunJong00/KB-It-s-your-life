package org.scoula.ex3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
// 요청에서 파라미터 얻기
        String userid = req.getParameter("userid");
        String passwd = req.getParameter("passwd");
// 응답 내보내기
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print("<html><body>");
        out.print("아이디값: " +  userid +"<br>");
        out.print("비밀번호값: " +  passwd +"<br>");
        out.print("</body></html>");
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
        req.setCharacterEncoding("UTF-8"); // 한글깨짐방지-있을때와없을때결과확인!!!
        doGet(req, resp);
    }
}