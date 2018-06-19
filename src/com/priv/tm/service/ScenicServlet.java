package com.priv.tm.service;

import com.priv.tm.active.ScenicActive;
import com.priv.tm.base.Scenic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/ScenicServlet")
public class ScenicServlet extends HttpServlet {

    ScenicActive scenicActive = new ScenicActive();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if ("insert".equals(action)) {
            scenicActive.insertS(new Scenic(
                    request.getParameter("sName"),
                    request.getParameter("sType"),
                    request.getParameter("sStanPrice"),
                    request.getParameter("sDiscPrice"),
                    request.getParameter("sTel"),
                    request.getParameter("sUrl"),
                    request.getParameter("sBusRoute"),
                    request.getParameter("sParkSpace"),
                    request.getParameter("sOpening"),
                    request.getParameter("sAddr"),
                    request.getParameter("pDesc")
            ));
            response.sendRedirect("/ScenicServlet");
        }
        if ("update".equals(action)) {
            scenicActive.updateS(new Scenic(Integer.parseInt(request.getParameter("sId")),
                    request.getParameter("sName"),
                    request.getParameter("sType"),
                    request.getParameter("sStanPrice"),
                    request.getParameter("sDiscPrice"),
                    request.getParameter("sTel"),
                    request.getParameter("sUrl"),
                    request.getParameter("sBusRoute"),
                    request.getParameter("sParkSpace"),
                    request.getParameter("sOpening"),
                    request.getParameter("sAddr"),
                    request.getParameter("pDesc")
            ));
            response.sendRedirect("/ScenicServlet");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/xml");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        if ((action == null) || ("select".equals(action))) {
            List<Scenic> scenicList = new ArrayList<Scenic>();
            String sAddr = null;
            String sName = null;
            if (request.getParameter("sAddr") != "") {
                sAddr = request.getParameter("sAddr");
            }
            if (request.getParameter("sName") != "") {
                sName = request.getParameter("sName");
            }
            scenicList = scenicActive.findS(sAddr,sName);
            request.setAttribute("scenicList", scenicList);
            request.setAttribute("sAddr", sAddr);
            request.setAttribute("sName", sName);
            request.getRequestDispatcher("consult/scenic.jsp").forward(request, response);
        }
        if ("delete".equals(action)) {
            scenicActive.deleteS(request.getParameter("sId"));
            response.sendRedirect("/ScenicServlet");
        }
        if ("query".equals(action)) {
            String sId = request.getParameter("sId");
            Boolean update = true;
            Scenic scenic = scenicActive.queryS(sId);
            request.setAttribute("scenic", scenic);
            request.setAttribute("update", update);
            request.getRequestDispatcher("consult/scenic_add_edit.jsp").forward(request, response);
        }
        if ("show".equals(action)) {
            String sId = request.getParameter("sId");
            Scenic scenic = scenicActive.queryS(sId);
            request.setAttribute("scenic", scenic);
            request.getRequestDispatcher("consult/scenic_info.jsp").forward(request, response);
        }
    }
}
