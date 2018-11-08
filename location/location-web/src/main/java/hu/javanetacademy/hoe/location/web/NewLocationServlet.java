package hu.javanetacademy.hoe.location.web;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import hu.javanetacademy.hoe.base.util.CustomException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import hu.javanetacademy.hoe.location.service.object.LocationService;
import hu.javanetacademy.hoe.empire.dao.model.Empire;
/**
 *
 * @author thejumper203
 */
@WebServlet(urlPatterns = {"/user/locations/new"})
public class NewLocationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        getServletContext().getRequestDispatcher("/location.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            LocationService ls=new LocationService();
            String name=request.getParameter("pname");
            String desc=request.getParameter("pdesc");
            Empire actual=(Empire)request.getSession().getAttribute("curremp");
            ls.create(name,desc,actual.getId());
        } catch (CustomException ex) {
            request.setAttribute("errormessage", ex.getMessage());
            request.getRequestDispatcher("/errorpage.jsp").forward(request, response);
        }

    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
