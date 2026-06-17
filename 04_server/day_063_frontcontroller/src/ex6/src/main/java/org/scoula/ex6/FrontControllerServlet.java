package org.scoula.ex6;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServlet", value = "/")
public class FrontControllerServlet extends HttpServlet {
    Map<String, Command> getMap;
    Map<String, Command> postMap;
    String prefix = "/WEB-INF/views/";
    String suffix = ".jsp;";
    HomeController homeController = new HomeController();
    public void init(){
        getMap = new HashMap<>();
        postMap = new HashMap<>();

        getMap.put("/", homeController::getIndex);
    }
    private String getCommandName(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        return requestURI.substring(contextPath.length());
    }
    private Command getCommand(HttpServletRequest req){
        String commandName = getCommandName(req);

        Command command;
        if (req.getMethod().equalsIgnoreCase("GET")) {
            command = getMap.get(commandName);
            } else{
            command = postMap.get(commandName);
        }
        return command;
    }

    // controller 에 해당하는 command 객체
    public void execute(Command command, HttpServletRequest req, HttpServletResponse res)
        throws IOException, ServletException{
        String viewName = command.execute(req,res); // JSP의 경로
        if (viewName.startsWith("redirect:")) {
            res.sendRedirect(viewName.substring("redirect:".length()));
            } else {
            String view = prefix + viewName + suffix;
            RequestDispatcher dis = req.getRequestDispatcher(view);
            dis.forward(req,res);
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {
        Command command = getCommand(req);
        if(command !=null){
            execute(command, req, res);
        }else{
            // 404 에러처리
            String view = prefix + "404" + suffix;
            RequestDispatcher dis = req.getRequestDispatcher(view);
            dis.forward(req,res);
        }
    }
}


