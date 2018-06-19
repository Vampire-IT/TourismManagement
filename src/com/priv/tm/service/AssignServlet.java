package com.priv.tm.service;

import com.priv.tm.active.AssignActive;
import com.priv.tm.active.ComActive;
import com.priv.tm.active.UserActive;
import com.priv.tm.base.Assign;
import com.priv.tm.base.Complain;
import com.priv.tm.base.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/AssignServlet")
public class AssignServlet extends HttpServlet {

    AssignActive assignActive = new AssignActive();
    ComActive comActive = new ComActive();
    UserActive userActive = new UserActive();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if ("insert".equals(action)) {
            assignActive.insertA(new Assign(
                    Integer.parseInt(request.getParameter("cId")),
                    request.getParameter("uName")
            ));
            response.sendRedirect("/ComServlet");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/xml");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if ((action == null) || ("select".equals(action))) {
            List<Assign> assignList = new ArrayList<Assign>();
            String uName = null;
            if (request.getParameter("uName") != "") {
                uName = request.getParameter("uName");
            }
            assignList = assignActive.findA(uName,null,null);
            request.setAttribute("assignList", assignList);
            request.setAttribute("uName", uName);
            request.getRequestDispatcher("complain/com_assign_info.jsp").forward(request, response);
        }
        if ("assign".equals(action)) {
            String cId = request.getParameter("cId");
            List<User> userList = new ArrayList<User>();
            userList = userActive.findU(null,"投诉处理","1");
            Complain complain = comActive.queryC(cId);
            comActive.updateMack(cId);
            request.setAttribute("complain", complain);
            request.setAttribute("userList", userList);
            request.getRequestDispatcher("complain/com_assign.jsp").forward(request, response);
        }
    }
}
