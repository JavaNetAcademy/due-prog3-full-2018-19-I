package hu.javanetacademy.hoe.location.web;

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
import hu.javanetacademy.hoe.user.dao.model.User;
import java.util.List;

/**
 *
 * @author thejumper203
 */
@WebServlet(urlPatterns = {"/user/locations"})
public class LocationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        EmpireServiceObjectImpl empserv =new EmpireServiceObjectImpl();
        if (request.getParameter("select")!=null) 
        {
            LocationService locserv = new LocationService();         
            long sel= Long.parseLong(request.getParameter("selectedEmpire"));
            List<Location> locations=locserv.getByEmpire(sel);
            request.getSession().setAttribute("curremp",empserv.get(sel));
            request.setAttribute("locations", locations);
            request.getRequestDispatcher("/locations.jsp").forward(request, response);
        }
        if (request.getParameter("manage")!=null) {
            User loggedInUser=(User)request.getSession().getAttribute("user");
            List<Empire> empires=empserv.getByUser(loggedInUser.getId());
            request.setAttribute("empires", empires);
            request.getRequestDispatcher("/user/empire").forward(request, response);
        }
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
