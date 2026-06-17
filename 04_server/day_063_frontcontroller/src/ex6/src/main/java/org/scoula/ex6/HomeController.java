package org.scoula.ex6;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController {
    public String getIndex(HttpServletRequest req, HttpServletResponse res){
        return "index";
    }
}
