package com.priv.tm.service;

import com.priv.tm.active.RestActive;
import com.priv.tm.base.Performance;
import com.priv.tm.base.Restaurant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/RestServlet")
public class RestServlet extends HttpServlet {

    RestActive restActive = new RestActive();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if ("insert".equals(action)) {
            restActive.insertR(new Restaurant(
                    request.getParameter("rName"),
                    request.getParameter("rAvgPrice"),
                    request.getParameter("rTel"),
                    request.getParameter("rUrl"),
                    request.getParameter("rBusRoute"),
                    request.getParameter("rParkSpace"),
                    request.getParameter("rOpening"),
                    request.getParameter("rAddr"),
                    request.getParameter("rDesc")
            ));
            response.sendRedirect("/RestServlet");
        }
        if ("update".equals(action)) {
            restActive.updateR(new Restaurant(Integer.parseInt(request.getParameter("rId")),
                    request.getParameter("rName"),
                    request.getParameter("rAvgPrice"),
                    request.getParameter("rTel"),
                    request.getParameter("rUrl"),
                    request.getParameter("rBusRoute"),
                    request.getParameter("rParkSpace"),
                    request.getParameter("rOpening"),
                    request.getParameter("rAddr"),
                    request.getParameter("rDesc")
            ));
            response.sendRedirect("/RestServlet");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/xml");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        if ((action == null) || ("select".equals(action))) {
            List<Restaurant> restaurantList = new ArrayList<Restaurant>();
            String rAddr = null;
            String rName = null;
            if (request.getParameter("rAddr") != "") {
                rAddr = request.getParameter("rAddr");
            }
            if (request.getParameter("rName") != "") {
                rName = request.getParameter("rName");
            }
            restaurantList = restActive.findR(rAddr,rName);
            request.setAttribute("restaurantList", restaurantList);
            request.setAttribute("rAddr", rAddr);
            request.setAttribute("rName", rName);
            request.getRequestDispatcher("consult/restaurant.jsp").forward(request, response);
        }
        if ("delete".equals(action)) {
            restActive.deleteR(request.getParameter("rId"));
            response.sendRedirect("/RestServlet");
        }
        if ("query".equals(action)) {
            String rId = request.getParameter("rId");
            Boolean update = true;
            Restaurant restaurant = restActive.queryR(rId);
            request.setAttribute("restaurant", restaurant);
            request.setAttribute("update", update);
            request.getRequestDispatcher("consult/restaurant_add_edit.jsp").forward(request, response);
        }
        if ("show".equals(action)) {
            String rId = request.getParameter("rId");
            Restaurant restaurant = restActive.queryR(rId);
            request.setAttribute("restaurant", restaurant);
            request.getRequestDispatcher("consult/restaurant_info.jsp").forward(request, response);
        }
    }
}
