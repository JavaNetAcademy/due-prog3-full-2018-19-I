package hu.javanetacademy.hoe.location.web;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import hu.javanetacademy.hoe.location.service.object.LocationService;
/**
 *
 * @author thejumper203
 */
@WebServlet(urlPatterns = {"/location"})
public class LocationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");   
        getServletContext().getRequestDispatcher("/location.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       LocationService ls=new LocationService();
       String name=request.getParameter("pname");
       String desc=request.getParameter("pdesc");
       long empid=Long.parseLong(request.getParameter("pempid"));
       ls.create(name,desc,empid);
       doGet(request,response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
