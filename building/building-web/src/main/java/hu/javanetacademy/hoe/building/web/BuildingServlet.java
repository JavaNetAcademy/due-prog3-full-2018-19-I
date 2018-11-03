/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.building.web;

import hu.javanetacademy.hoe.building.dao.model.Building;
import hu.javanetacademy.hoe.building.service.object.BuildingService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 *
 * @author JUHASZ
 */
@WebServlet(name = "BuildingServlet", urlPatterns = {"/building/building"})
public class BuildingServlet extends HttpServlet{
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        BuildingService bs = new BuildingService();
        request.setAttribute("buildings", bs.getBuildingsByUser(110));
        
        getServletContext().getRequestDispatcher("/building.jsp").include(request, response);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //ok
        Building newBuilding = new Building();
        newBuilding.setName(request.getParameter("pname"));
        newBuilding.setDescription(request.getParameter("pdesc"));
        newBuilding.setLevel(Long.parseLong(request.getParameter("plevel")));
        //System.err.println("33333333333333333 "+newBuilding.getDescription()+" ++++++++++++");
        BuildingService hs = new BuildingService();
        hs.create(newBuilding);
    }
    
}
