package com.priv.tm.service;

import com.priv.tm.active.ComActive;
import com.priv.tm.base.Complain;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/ComServlet")
public class ComServlet extends HttpServlet {

    ComActive comActive = new ComActive();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if ("insert".equals(action)) {
            comActive.insertC(new Complain(
                    request.getParameter("cName"),
                    request.getParameter("cTel"),
                    request.getParameter("cTargetType"),
                    request.getParameter("cTarget"),
                    Integer.parseInt(request.getParameter("cType")),
                    request.getParameter("cCont"),
                    request.getParameter("cRecorder"),
                    request.getParameter("cRemark")
            ));
            response.sendRedirect("/ComServlet");
        }
        if ("update".equals(action)) {
            comActive.updateC(new Complain(Integer.parseInt(request.getParameter("cId")),
                    request.getParameter("cName"),
                    request.getParameter("cTel"),
                    request.getParameter("cTargetType"),
                    request.getParameter("cTarget"),
                    Integer.parseInt(request.getParameter("cType")),
                    request.getParameter("cCont"),
                    request.getParameter("cRecorder"),
                    request.getParameter("cRemark")
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
            List<Complain> complainList = new ArrayList<Complain>();
            String cTarget = null;
            String cName = null;
            if (request.getParameter("cTarget") != "") {
                cTarget = request.getParameter("cTarget");
            }
            if (request.getParameter("cName") != "") {
                cName = request.getParameter("cName");
            }
            complainList = comActive.findC(cTarget,cName,"0");
            request.setAttribute("complainList", complainList);
            request.setAttribute("cTarget", cTarget);
            request.setAttribute("cName", cName);
            request.getRequestDispatcher("complain/com_manage.jsp").forward(request, response);
        }
        if ("delete".equals(action)) {
            comActive.deleteC(request.getParameter("cId"));
            response.sendRedirect("/ComServlet");
        }
        if ("query".equals(action)) {
            String cId = request.getParameter("cId");
            Boolean update = true;
            Complain complain = comActive.queryC(cId);
            request.setAttribute("complain", complain);
            request.setAttribute("update", update);
            request.getRequestDispatcher("complain/com_add_edit.jsp").forward(request, response);
        }
    }
}
