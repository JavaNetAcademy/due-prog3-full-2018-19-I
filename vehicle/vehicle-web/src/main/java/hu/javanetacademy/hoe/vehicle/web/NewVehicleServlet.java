package hu.javanetacademy.hoe.vehicle.web;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import hu.javanetacademy.hoe.vehicle.service.object.VehicleServiceObjectImpl;
/**
 *
 * @author ttama
 */
@WebServlet(urlPatterns = {"/user/vehicle/new"})
public class NewVehicleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        getServletContext().getRequestDispatcher("/vehicle.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       VehicleServiceObjectImpl vs=new VehicleServiceObjectImpl();
       String id=request.getParameter("pid");
       String name=request.getParameter("pname");
       String info=request.getParameter("pinfo");
       String speed=request.getParameter("pspeed");
       
       vs.create(Long.parseLong(id),name,info,Long.parseLong(speed));
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
