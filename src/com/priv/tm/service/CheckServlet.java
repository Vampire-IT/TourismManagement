package com.priv.tm.service;

import com.priv.tm.active.UserActive;
import com.priv.tm.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(value = "/CheckServlet")
public class CheckServlet extends HttpServlet {
    UserActive userActive = new UserActive();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/xml");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String action = request.getParameter("action");
        if ("add".equals(action)){
            request.getRequestDispatcher("system/user_add_edit.jsp").forward(request, response);
        }
        String responseContext = "true";
            String username = request.getParameter("username");
            if(username != null) {
                List<String> check = userActive.findUsername();
                for (String s : check) {
                    if (username.equals(s)) {
                        responseContext = "false";
                        break;
                    }
                }
            }
        out.println(responseContext);
        out.flush();
        out.close();
    }
}
