/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.resources.web;

import hu.javanetacademy.hoe.resources.dao.model.Resources;
import hu.javanetacademy.hoe.resources.service.object.ResourcesService;
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
 * @author jf6vmn
 */
@WebServlet(urlPatterns = {"/user/resources/resources"})
public class NewResourcesServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {            
      response.setContentType("text/html;charset=UTF-8");
      
        }
     
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
       ResourcesService ls=new ResourcesService();
       String name=request.getParameter("nev");
       String desc=request.getParameter("info");
        String meny =request.getParameter("mennyiseg");
        ls.create(name,desc,Long.parseLong(meny) );
        request.getRequestDispatcher("/user/resources").forward(request, response);
       
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
