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

@WebServlet(urlPatterns = {"/user/resources/delresources"})
public class DelResourcesServlet extends HttpServlet{

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ResourcesService ls = new ResourcesService();
        List<Resources>lista = ls.getList();
        request.setAttribute("resources", lista);
        request.getRequestDispatcher("/delresources.jsp").forward(request, response);
        
     //   processRequest(request, response);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //doGet(request, response);
        ResourcesService ls = new ResourcesService();
        long selected = Long.parseLong(request.getParameter("selectedItem"));
        if (request.getParameter("modify")!=null) {
            if (request.getParameter("newname")!=null || request.getParameter("newinfo")!=null) {
                Resources oldloc=ls.get(selected);
                Resources newmennyiseg= new Resources();
                newmennyiseg=oldloc;
                if (!request.getParameter("newname").equals("")) {
                    newmennyiseg.setNev(request.getParameter("newname"));
                }
                if (!request.getParameter("newinfo").equals("")) {
                    newmennyiseg.setInfo(request.getParameter("newinfo"));     
                }
                if (!request.getParameter("newamount").equals("")) {
                    newmennyiseg.setMennyiseg(Long.parseLong(request.getParameter("newinfo")));     
                }
                ls.modify(selected, newmennyiseg);
            }
        }
        if (request.getParameter("delete")!=null) {
            ls.delete(selected);
        }   
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
