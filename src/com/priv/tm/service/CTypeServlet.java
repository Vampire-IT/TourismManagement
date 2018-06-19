package com.priv.tm.service;

import com.priv.tm.active.CTypeActive;
import com.priv.tm.base.CType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/CTypeServlet")
public class CTypeServlet extends HttpServlet {

    CTypeActive cTypeActive = new CTypeActive();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if ("insert".equals(action)) {
            cTypeActive.insertCT(new CType(
                    request.getParameter("cTName"),
                    request.getParameter("cTDesc"),
                    "1"
            ));
            response.sendRedirect("/CTypeServlet");
        }
        if ("update".equals(action)) {
            cTypeActive.updateCT(new CType(Integer.parseInt(request.getParameter("cTId")),
                    request.getParameter("cTName"),
                    request.getParameter("cTDesc")
            ));
            response.sendRedirect("/CTypeServlet");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/xml");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        if ((action == null) || ("select".equals(action))) {
            List<CType> cTypeList = new ArrayList<CType>();
            String cTName = null;
            String cTState = null;
            if (request.getParameter("cTName") != "") {
                cTName = request.getParameter("cTName");
            }
            if (request.getParameter("cTState") != "") {
                cTState = request.getParameter("cTState");
            }
            cTypeList = cTypeActive.findCT(cTName,cTState);
            request.setAttribute("cTypeList", cTypeList);
            request.setAttribute("cTName", cTName);
            request.setAttribute("cTState", cTState);
            request.getRequestDispatcher("system/type_manage.jsp").forward(request, response);
        }
        if ("delete".equals(action)) {
            cTypeActive.deleteCT(request.getParameter("cTId"));
            response.sendRedirect("/CTypeServlet");
        }
        if ("state".equals(action)) {
            String cTState = request.getParameter("cTState");
            if("1".equals(cTState)){
                cTypeActive.upStateCT(new CType(Integer.parseInt(request.getParameter("cTId")),"0"));
            }
            if("0".equals(cTState)){
                cTypeActive.upStateCT(new CType(Integer.parseInt(request.getParameter("cTId")),"1"));
            }
            response.sendRedirect("/CTypeServlet");
        }
        if ("query".equals(action)) {
            String cTId = request.getParameter("cTId");
            Boolean update = true;
            CType CType = cTypeActive.queryCT(cTId);
            request.setAttribute("CType", CType);
            request.setAttribute("update", update);
            request.getRequestDispatcher("system/type_add_edit.jsp").forward(request, response);
        }
    }
}
