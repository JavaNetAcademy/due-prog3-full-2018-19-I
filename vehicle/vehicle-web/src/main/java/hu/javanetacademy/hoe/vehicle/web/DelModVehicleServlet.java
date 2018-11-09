/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.vehicle.web;
import hu.javanetacademy.hoe.vehicle.dao.model.Vehicle;
import hu.javanetacademy.hoe.vehicle.service.object.VehicleServiceObjectImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author ttama
 */
@WebServlet(urlPatterns = {"/user/vehicle/delmod"})
public class DelModVehicleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        VehicleServiceObjectImpl vs=new VehicleServiceObjectImpl();
        long selected = Long.parseLong(request.getParameter("selectedVehicle"));
        if (request.getParameter("modify")!=null) {
            if (request.getParameter("newname")!=null || request.getParameter("newinfo")!=null || request.getParameter("newspeed")!=null) {
                Vehicle vehicle=vs.getById(selected);
                Vehicle newVehicle= new Vehicle();
                newVehicle=vehicle;
                if (request.getParameter("newname").equals("")) {
                    newVehicle.setName(request.getParameter("newname"));
                }
                if (request.getParameter("newinfo").equals("")) {
                    newVehicle.setInfo(request.getParameter("newdesc"));     
                }
                vs.modify(selected, newVehicle);
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
