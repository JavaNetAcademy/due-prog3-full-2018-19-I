/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.heroclass.web;

import hu.javanetacademy.hoe.heroclass.dao.model.HeroClass;
import hu.javanetacademy.hoe.heroclass.service.object.HeroClassServiceObjectImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Norbi
 */
@WebServlet(urlPatterns = {"/addnewheroclass"})
public class AddHeroClassServlet extends HttpServlet {



    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
        getServletContext().getRequestDispatcher("/heroclass.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HeroClassServiceObjectImpl ls = new HeroClassServiceObjectImpl();
        String name=request.getParameter("name");
        String description=request.getParameter("description");
        HeroClass newHeroClass = new HeroClass();
        newHeroClass.setName(name);
        newHeroClass.setDescription(description);
        ls.create(newHeroClass);
       
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
