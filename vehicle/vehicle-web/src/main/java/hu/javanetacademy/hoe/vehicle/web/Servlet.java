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
import hu.javanetacademy.hoe.vehicle.dao.model.Vehicle;
import hu.javanetacademy.hoe.hero.dao.model.Hero;
import hu.javanetacademy.hoe.hero.service.object.HeroService;
import hu.javanetacademy.hoe.user.dao.model.User;
import java.util.List;


/**
 *
 * @author ttama
 */
@WebServlet(urlPatterns = {"/index"})
public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        if (true) 
        {
            VehicleServiceObjectImpl vehicleService=new VehicleServiceObjectImpl();
            HeroService heroService=new HeroService();
            User current=(User)request.getSession().getAttribute("user");
         //  List<Vehicle> vehicle=vehicleService.getByUser(current.getId());
            List<Vehicle> vehicle=vehicleService.getByUser(current.getId());
            List<Hero> heroes=heroService.getHeroByUser(current.getId());
            request.setAttribute("vehicles", vehicle);
            request.setAttribute("heroes", heroes);
            request.getRequestDispatcher("/vehicle.jsp").forward(request, response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
