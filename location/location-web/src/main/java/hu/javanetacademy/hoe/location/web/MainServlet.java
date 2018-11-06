package hu.javanetacademy.hoe.location.web;

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
import hu.javanetacademy.hoe.empire.service.object.EmpireServiceObjectImpl;
import hu.javanetacademy.hoe.empire.dao.model.Empire;
import hu.javanetacademy.hoe.hero.dao.model.Hero;
import hu.javanetacademy.hoe.hero.service.object.HeroService;
import hu.javanetacademy.hoe.user.dao.model.User;
import java.util.List;


/**
 *
 * @author thejumper203
 */
@WebServlet(urlPatterns = {"/index"})
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        if (true) 
        {
            EmpireServiceObjectImpl empservice=new EmpireServiceObjectImpl();
            HeroService heroservice=new HeroService();
            User current=(User)request.getSession().getAttribute("user");
            List<Empire> empires=empservice.getByUser(current.getId());
            List<Hero> heroes=heroservice.getHeroByUser(current.getId());
            request.setAttribute("empires", empires);
            request.setAttribute("heroes", heroes);
            request.getRequestDispatcher("/empires.jsp").forward(request, response);
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
