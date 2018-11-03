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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JUHASZ
 */
@WebServlet(name = "DisplayBuildingServlet", urlPatterns = {"/building/display"})
public class DisplayBuildingServlet extends HttpServlet {
    List<Building> blst = new ArrayList<Building>();
    List<String> lst = new ArrayList<String>();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        BuildingService bs = new BuildingService();        
        try {
            blst = bs.getAllBuildings();
            for(Building bld: blst){
                lst.add(Long.toString(bld.getId()));
                lst.add(bld.getName());
                lst.add(bld.getDescription());
                lst.add(Long.toString(bld.getLevel()));
                lst.add(Long.toString(bld.getUserid()));
            }
        } catch (Exception e) {
        } finally {
            request.setAttribute("BuildingData", lst);
            RequestDispatcher rd = request.getRequestDispatcher("/building/displayrecord.jsp");
            rd.forward(request, response);
            lst.clear();
        }
    }

    @Override
    protected void doHead(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

}
