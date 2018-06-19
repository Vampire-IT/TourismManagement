package com.priv.tm.service;

import com.priv.tm.active.PerfActive;
import com.priv.tm.base.Hotel;
import com.priv.tm.base.Performance;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/PerfServlet")
public class PerfServlet extends HttpServlet {

    PerfActive perfActive = new PerfActive();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if ("insert".equals(action)) {
            perfActive.insertP(new Performance(
                    request.getParameter("pName"),
                    request.getParameter("pPrice"),
                    request.getParameter("pTel"),
                    request.getParameter("pAddr"),
                    request.getParameter("pBusRoute"),
                    request.getParameter("pOpening"),
                    request.getParameter("pDesc")
            ));
            response.sendRedirect("/PerfServlet");
        }
        if ("update".equals(action)) {
            perfActive.updateP(new Performance(Integer.parseInt(request.getParameter("pId")),
                    request.getParameter("pName"),
                    request.getParameter("pPrice"),
                    request.getParameter("pTel"),
                    request.getParameter("pAddr"),
                    request.getParameter("pBusRoute"),
                    request.getParameter("pOpening"),
                    request.getParameter("pDesc")
            ));
            response.sendRedirect("/PerfServlet");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/xml");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        if ((action == null) || ("select".equals(action))) {
            List<Performance> performanceList = new ArrayList<Performance>();
            String pAddr = null;
            String pName = null;
            if (request.getParameter("pAddr") != "") {
                pAddr = request.getParameter("pAddr");
            }
            if (request.getParameter("pName") != "") {
                pName = request.getParameter("pName");
            }
            performanceList = perfActive.findP(pAddr,pName);
            request.setAttribute("performanceList", performanceList);
            request.setAttribute("pAddr", pAddr);
            request.setAttribute("pName", pName);
            request.getRequestDispatcher("consult/performance.jsp").forward(request, response);
        }
        if ("delete".equals(action)) {
            perfActive.deleteP(request.getParameter("pId"));
            response.sendRedirect("/PerfServlet");
        }
        if ("query".equals(action)) {
            String pId = request.getParameter("pId");
            Boolean update = true;
            Performance performance = perfActive.queryP(pId);
            request.setAttribute("performance", performance);
            request.setAttribute("update", update);
            request.getRequestDispatcher("consult/performance_add_edit.jsp").forward(request, response);
        }
        if ("show".equals(action)) {
            String pId = request.getParameter("pId");
            Performance performance = perfActive.queryP(pId);
            request.setAttribute("performance", performance);
            request.getRequestDispatcher("consult/performance_info.jsp").forward(request, response);
        }
    }
}
