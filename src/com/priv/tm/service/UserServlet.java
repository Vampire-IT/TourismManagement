package com.priv.tm.service;

import com.priv.tm.active.UserActive;
import com.priv.tm.base.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/UserServlet")
public class UserServlet extends HttpServlet {

    UserActive userActive = new UserActive();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if ("insert".equals(action)) {
            userActive.insertU(new User(
                    request.getParameter("uName"),
                    request.getParameter("password"),
                    request.getParameter("rName"),
                    request.getParameter("userType"),
                    request.getParameter("lock")
            ));
            response.sendRedirect("/UserServlet");
        }
        if ("update".equals(action)) {
            String password = request.getParameter("oldPassword");
            if (request.getParameter("newPassword") != "") {
                password = request.getParameter("newPassword");
            }
            userActive.updateU(new User(
                    request.getParameter("uName"),
                    password,
                    request.getParameter("rName"),
                    request.getParameter("userType"),
                    request.getParameter("lock")
            ));
            response.sendRedirect("/UserServlet");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/xml");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        if ((action == null) || ("select".equals(action))) {
            List<User> userList = new ArrayList<User>();
            String realName = null;
            String userType = null;
            String lock = null;
            if (request.getParameter("realName") != "") {
                realName = request.getParameter("realName");
            }
            if (request.getParameter("userType") != "") {
                userType = request.getParameter("userType");
            }
            if (request.getParameter("lock") != "") {
                lock = request.getParameter("lock");
            }
            userList = userActive.findU(realName,userType,lock);
            request.setAttribute("userList", userList);
            request.setAttribute("realName", realName);
            request.setAttribute("userType", userType);
            request.setAttribute("lock", lock);
            request.getRequestDispatcher("/system/user_manage.jsp").forward(request, response);
        }
        if ("delete".equals(action)) {
            userActive.deleteU(request.getParameter("username"));
            response.sendRedirect("/UserServlet");
        }

        if ("lock".equals(action)) {
            String userLock = request.getParameter("userLock");
            if("1".equals(userLock)){
                userActive.upLookU(new User(request.getParameter("username"),"0"));
            }
            if("0".equals(userLock)){
                userActive.upLookU(new User(request.getParameter("username"),"1"));
            }
            response.sendRedirect("/UserServlet");
        }
        if ("query".equals(action)) {
            String username = request.getParameter("username");
            String page = request.getParameter("page");
            Boolean update = true;
            Boolean temp = false;
            if ("a".equals(page)){
                temp = true;
            }
            User user = userActive.queryU(username);
            request.setAttribute("user", user);
            request.setAttribute("update", update);
            request.setAttribute("temp", temp);
            request.getRequestDispatcher("system/user_add_edit.jsp").forward(request, response);
        }
    }
}
