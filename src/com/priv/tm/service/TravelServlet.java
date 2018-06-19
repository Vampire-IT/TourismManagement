package com.priv.tm.service;

import com.priv.tm.active.TravelActive;
import com.priv.tm.base.Travel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/TravelServlet")
public class TravelServlet extends HttpServlet {

    TravelActive travelActive = new TravelActive();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if ("insert".equals(action)) {
            travelActive.insertT(new Travel(
                    request.getParameter("tName"),
                    request.getParameter("tLinkman"),
                    request.getParameter("tTel"),
                    request.getParameter("tFax"),
                    request.getParameter("tQq"),
                    request.getParameter("tEmail"),
                    request.getParameter("tAddr"),
                    request.getParameter("tDesc")
            ));
            response.sendRedirect("/TravelServlet");
        }
        if ("update".equals(action)) {
            travelActive.updateT(new Travel(Integer.parseInt(request.getParameter("tId")),
                    request.getParameter("tName"),
                    request.getParameter("tLinkman"),
                    request.getParameter("tTel"),
                    request.getParameter("tFax"),
                    request.getParameter("tQq"),
                    request.getParameter("tEmail"),
                    request.getParameter("tAddr"),
                    request.getParameter("tDesc")
            ));
            response.sendRedirect("/TravelServlet");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/xml");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        if ((action == null) || ("select".equals(action))) {
            List<Travel> travelList = new ArrayList<Travel>();
            String tName = null;
            if (request.getParameter("tName") != "") {
                tName = request.getParameter("tName");
            }
            travelList = travelActive.findT(tName);
            request.setAttribute("travelList", travelList);
            request.setAttribute("tName", tName);
            request.getRequestDispatcher("consult/travel.jsp").forward(request, response);
        }
        if ("delete".equals(action)) {
            travelActive.deleteT(request.getParameter("tId"));
            response.sendRedirect("/TravelServlet");
        }
        if ("query".equals(action)) {
            String tId = request.getParameter("tId");
            Boolean update = true;
            Travel travel = travelActive.queryT(tId);
            request.setAttribute("travel", travel);
            request.setAttribute("update", update);
            request.getRequestDispatcher("consult/travel_add_edit.jsp").forward(request, response);
        }
        if ("show".equals(action)) {
            String tId = request.getParameter("tId");
            Travel travel = travelActive.queryT(tId);
            request.setAttribute("travel", travel);
            request.getRequestDispatcher("consult/travel_info.jsp").forward(request, response);
        }
    }
}
