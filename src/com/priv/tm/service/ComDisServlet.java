package com.priv.tm.service;

import com.priv.tm.active.AssignActive;
import com.priv.tm.active.ComActive;
import com.priv.tm.active.DisposeActive;
import com.priv.tm.active.FeedbackActive;
import com.priv.tm.base.Assign;
import com.priv.tm.base.Complain;
import com.priv.tm.base.Dispose;
import com.priv.tm.base.Feedback;
import com.priv.tm.dao.DisposeDAO;
import com.priv.tm.dao.FeedbackDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/ComDisServlet")
public class ComDisServlet extends HttpServlet {

    AssignActive assignActive = new AssignActive();
    ComActive comActive = new ComActive();
    DisposeActive disposeActive = new DisposeActive();
    FeedbackActive feedbackActive = new FeedbackActive();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if ("insertD".equals(action)) {
            disposeActive.insertD(new Dispose(
                    Integer.parseInt(request.getParameter("comId")),
                    request.getParameter("dName"),
                    request.getParameter("dFinish"),
                    request.getParameter("dCont")
            ));
            if("1".equals(request.getParameter("dFinish"))){
                assignActive.updateResult("1",request.getParameter("cId"));
            }
            if("0".equals(request.getParameter("dFinish"))){
                assignActive.updateResult("0",request.getParameter("cId"));
            }
            response.sendRedirect("/ComDisServlet");
        }
        if ("updateD".equals(action)) {
            disposeActive.updateD(new Dispose(
                    Integer.parseInt(request.getParameter("cId")),
                    request.getParameter("dName"),
                    request.getParameter("dFinish"),
                    request.getParameter("dCont")
            ));
            if("1".equals(request.getParameter("dFinish"))){
                assignActive.updateResult("1",request.getParameter("cId"));
            }
            if("0".equals(request.getParameter("dFinish"))){
                assignActive.updateResult("0",request.getParameter("cId"));
            }
            response.sendRedirect("/ComDisServlet");
        }

        if ("insertF".equals(action)) {
            feedbackActive.insertF(new Feedback(
                    Integer.parseInt(request.getParameter("cId")),
                    request.getParameter("fName"),
                    request.getParameter("fCont")
            ));
            response.sendRedirect("/ComDisServlet");
        }
        if ("updateF".equals(action)) {
            feedbackActive.insertF(new Feedback(
                    Integer.parseInt(request.getParameter("cId")),
                    request.getParameter("fName"),
                    request.getParameter("fCont")
            ));
            response.sendRedirect("/ComDisServlet");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/xml");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        String loginName = request.getParameter("loginName");
        if ((action == null) || ("select".equals(action))) {
            List<Assign> assignList = new ArrayList<Assign>();
            String cTarget = null;
            String cName = null;
            if (request.getParameter("cTarget") != "") {
                cTarget = request.getParameter("cTarget");
            }
            if (request.getParameter("cName") != "") {
                cName = request.getParameter("cName");
            }
            assignList = assignActive.findA(loginName,cTarget,cName);
            request.setAttribute("assignList", assignList);
            request.setAttribute("cTarget", cTarget);
            request.setAttribute("cName", cName);
            request.getRequestDispatcher("complain/com_dis_manage.jsp").forward(request, response);
        }
        if ("dispose".equals(action)) {
            String cId = request.getParameter("cId");
            Dispose dispose = null;
            dispose = disposeActive.queryD(cId);
            request.setAttribute("dispose", dispose);
            request.setAttribute("cId", cId);
            if (dispose.getdName() != null){
                Boolean update = true;
                request.setAttribute("update", update);
            }
            request.getRequestDispatcher("/complain/com_info_dis.jsp").forward(request, response);
        }
        if ("feedback".equals(action)) {
            String cId = request.getParameter("cId");
            Feedback feedback = null;
            feedback = feedbackActive.queryF(cId);
            request.setAttribute("feedback", feedback);
            request.setAttribute("cId", cId);
            if (feedback.getfName() != null){
                Boolean update = true;
                request.setAttribute("update", update);
            }
            request.getRequestDispatcher("/complain/com_info_fb.jsp").forward(request, response);
        }
        if ("show".equals(action)) {
            Boolean temp = false;
            String cId = request.getParameter("cId");
            String flag = request.getParameter("flag");
            if ("a".equals(flag)){
                temp = true;
            }
            Complain complain = comActive.queryC(cId);
            Dispose dispose = disposeActive.queryD(cId);
            Feedback feedback = feedbackActive.queryF(cId);
            request.setAttribute("complain", complain);
            request.setAttribute("dispose", dispose);
            request.setAttribute("feedback", feedback);
            request.setAttribute("temp", temp);
            request.getRequestDispatcher("complain/com_info.jsp").forward(request, response);
        }
    }
}
