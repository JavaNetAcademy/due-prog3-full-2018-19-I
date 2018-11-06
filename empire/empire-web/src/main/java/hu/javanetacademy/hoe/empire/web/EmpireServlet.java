package hu.javanetacademy.hoe.empire.web;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import hu.javanetacademy.hoe.empire.dao.model.Empire;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import hu.javanetacademy.hoe.location.service.object.LocationService;
import hu.javanetacademy.hoe.empire.service.object.EmpireServiceObjectImpl;
import hu.javanetacademy.hoe.location.dao.model.Location;
import java.util.List;

/**
 *
 * @author kovacsmate96
 */
@WebServlet(urlPatterns = {"/user/empire"})
public class EmpireServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        LocationService locserv = new LocationService();
        EmpireServiceObjectImpl empserv =new EmpireServiceObjectImpl();
        long sel= Long.parseLong(request.getParameter("selectedEmpire"));
        List<Empire> empires=locserv.getByEmpire(sel);
        request.getSession().setAttribute("curremp",empserv.get(sel));
        request.setAttribute("empires", empires);
        request.getRequestDispatcher("/empire.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
