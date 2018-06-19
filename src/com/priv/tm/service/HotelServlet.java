package com.priv.tm.service;

import com.priv.tm.active.HotelActive;
import com.priv.tm.base.Hotel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/HotelServlet")
public class HotelServlet extends HttpServlet {

    HotelActive hotelActive = new HotelActive();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if ("insert".equals(action)) {
            hotelActive.insertH(new Hotel(
                    request.getParameter("hName"),
                    request.getParameter("hRating"),
                    request.getParameter("hStanPrice"),
                    request.getParameter("hDiscPrice"),
                    request.getParameter("hTel"),
                    request.getParameter("hUrl"),
                    request.getParameter("hBusRoute"),
                    request.getParameter("hParkSpace"),
                    request.getParameter("hOpening"),
                    request.getParameter("hAddr"),
                    request.getParameter("hDesc")
            ));
            response.sendRedirect("/HotelServlet");
        }
        if ("update".equals(action)) {
            hotelActive.updateH(new Hotel(Integer.parseInt(request.getParameter("hId")),
                    request.getParameter("hName"),
                    request.getParameter("hRating"),
                    request.getParameter("hStanPrice"),
                    request.getParameter("hDiscPrice"),
                    request.getParameter("hTel"),
                    request.getParameter("hUrl"),
                    request.getParameter("hBusRoute"),
                    request.getParameter("hParkSpace"),
                    request.getParameter("hOpening"),
                    request.getParameter("hAddr"),
                    request.getParameter("hDesc")
            ));
            response.sendRedirect("/HotelServlet");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/xml");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        if ((action == null) || ("select".equals(action))) {
            List<Hotel> hotelList = new ArrayList<Hotel>();
            String hAddr = null;
            String hName = null;
            String hRating = null;
            if (request.getParameter("hAddr") != "") {
                hAddr = request.getParameter("hAddr");
            }
            if (request.getParameter("hName") != "") {
                hName = request.getParameter("hName");
            }
            if (request.getParameter("hRating") != "") {
                hRating = request.getParameter("hRating");
            }
            hotelList = hotelActive.findH(hAddr,hName,hRating);
            request.setAttribute("hotelList", hotelList);
            request.setAttribute("hAddr", hAddr);
            request.setAttribute("hName", hName);
            request.setAttribute("hRating", hRating);
            request.getRequestDispatcher("consult/hotel.jsp").forward(request, response);
        }
        if ("delete".equals(action)) {
            hotelActive.deleteH(request.getParameter("hId"));
            response.sendRedirect("/HotelServlet");
        }
        if ("query".equals(action)) {
            String hId = request.getParameter("hId");
            Boolean update = true;
            Hotel hotel = hotelActive.queryH(hId);
            request.setAttribute("hotel", hotel);
            request.setAttribute("update", update);
            request.getRequestDispatcher("consult/hotel_add_edit.jsp").forward(request, response);
        }

        if ("show".equals(action)) {
            Hotel hotel = hotelActive.queryH(request.getParameter("hId"));
            request.setAttribute("hotel", hotel);
            request.getRequestDispatcher("consult/hotel_info.jsp").forward(request, response);
        }
    }
}
