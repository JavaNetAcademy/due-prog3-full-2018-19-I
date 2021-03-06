package hu.javanetacademy.hoe.location.web;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import hu.javanetacademy.hoe.base.util.CustomException;
import hu.javanetacademy.hoe.location.dao.model.Location;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import hu.javanetacademy.hoe.location.service.object.LocationService;
import java.util.HashSet;

/**
 *
 * @author thejumper203
 */
@WebServlet(urlPatterns = {"/user/locations/delmod"})
public class DelModLocationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LocationService ls=new LocationService();
        long selected = Long.parseLong(request.getParameter("selectedLocation"));
        if (request.getParameter("modify")!=null) {
            try {
                if (request.getParameter("newname")!=null || request.getParameter("newdesc")!=null) {
                Location oldloc=ls.get(selected);
                Location newloc= new Location();
                newloc=oldloc;
                if (!request.getParameter("newname").equals("")) {
                    newloc.setName(request.getParameter("newname"));
                }
                if (!request.getParameter("newdesc").equals("")) {
                    newloc.setDesc(request.getParameter("newdesc"));     
                }
                ls.modify(selected, newloc);
                }
            } catch (CustomException ex) {
                request.setAttribute("errormessage", ex.getMessage());
                request.getRequestDispatcher("/errorpage.jsp").forward(request, response);
            }
        }
        if (request.getParameter("delete")!=null) {
            ls.delete(selected);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
