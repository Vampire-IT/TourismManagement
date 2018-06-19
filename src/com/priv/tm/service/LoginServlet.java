package com.priv.tm.service;

import com.priv.tm.active.UserActive;
import com.priv.tm.base.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    UserActive userActive = new UserActive();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/xml");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        //接收参数
        String userName = request.getParameter("loginUser");
        String userPwd = request.getParameter("loginPwd");

        User user = userActive.queryU(userName);
        if (user.getUsername() == null){
            String userMassage = "用户不存在！";
            request.setAttribute("userName", userName);
            request.setAttribute("userMassage", userMassage);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            if (userPwd.equals(user.getPassword())){
                if ("1".equals(user.getLock())){
                    //创建session对象
                    HttpSession session = request.getSession();
                    //把用户数据保存在session域对象中
                    session.setAttribute("loginName", userName);
                    session.setAttribute("loginType", user.getUserType());


                    if ("系统管理员".equals(user.getUserType())){
                        response.sendRedirect("admin.jsp");
                    }else if ("服务人员".equals(user.getUserType())){
                        response.sendRedirect("customer_service.jsp");
                    }else if ("投诉处理".equals(user.getUserType())){
                        response.sendRedirect("complaint_handling.jsp");
                    }
                }else {
                    String lockMassage = "用户被锁定，请联系系统管理员！";
                    request.setAttribute("userName", userName);
                    request.setAttribute("lockMassage", lockMassage);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            }else {
                String pwdMassage = "密码错误！";
                request.setAttribute("userName", userName);
                request.setAttribute("pwdMassage", pwdMassage);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
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
                    request.getParameter("1")
            ));

                response.sendRedirect("/system/blank.jsp");

        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/xml");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if ("show".equals(action)) {
            String loginName = request.getParameter("loginName");
            User user = userActive.queryU(loginName);
            request.setAttribute("user", user);
            request.getRequestDispatcher("system/personal_info.jsp").forward(request, response);
        }
        if ("exit".equals(action)){
            HttpSession session = request.getSession(false);
            session.invalidate();
            response.sendRedirect("login.jsp");
        }
        if ("query".equals(action)) {
            String username = request.getParameter("username");
            User user = userActive.queryU(username);
            request.setAttribute("user", user);
            request.getRequestDispatcher("system/personal_info_edit.jsp").forward(request, response);
        }
    }
}
