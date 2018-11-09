/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.defenderbuild.web;

import hu.javanetacademy.hoe.defenderbuilding.dao.model.DefenderBuilding;
import hu.javanetacademy.hoe.vdefenderbuilding.service.object.DefenderBuildingObjectImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author I-117-05.hallgato
 */
@WebServlet(urlPatterns = {"/user/defenderbuild/delmod"})
public class DelModDefenderBuildServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DefenderBuildingObjectImpl vs=new DefenderBuildingObjectImpl();
        long selected = Long.parseLong(request.getParameter("selectedVehicle"));
        if (request.getParameter("modify")!=null) {
            if (request.getParameter("newname")!=null || request.getParameter("newinfo")!=null || request.getParameter("newattack")!=null || request.getParameter("newarmor")!=null)  {
                DefenderBuilding defbuild=vs.getById(selected);
                DefenderBuilding newdefbuild= new DefenderBuilding();
                newdefbuild=defbuild;
                if (request.getParameter("newname").equals("")) {
                    newdefbuild.setName(request.getParameter("newname"));
                }
                if (request.getParameter("newdesc").equals("")) {
                    newdefbuild.setInfo(request.getParameter("newdesc"));     
                }
                if (request.getParameter("newattack").equals("")) {
                    newdefbuild.setInfo(request.getParameter("newattack"));     
                }
                if (request.getParameter("newarmor").equals("")) {
                    newdefbuild.setInfo(request.getParameter("newarmor"));     
                }
                vs.modify(selected, newdefbuild);
            }
        }
        if (request.getParameter("delete")!=null) {
            vs.delete(selected);
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
