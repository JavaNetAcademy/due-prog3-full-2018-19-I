package hu.javanetacademy.hoe.empire.web;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import hu.javanetacademy.hoe.empire.dao.model.Empire;
import hu.javanetacademy.hoe.empire.service.object.EmpireServiceObjectImpl;
import hu.javanetacademy.hoe.location.dao.model.Location;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kovacsmate96
 */
@WebServlet(urlPatterns = {"/user/empires/delmod"})
public class DelModEmpireServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EmpireServiceObjectImpl es=new EmpireServiceObjectImpl();
        long selected = Long.parseLong(request.getParameter("selectedEmpire"));
        if (request.getParameter("modify")!=null) {
            if (request.getParameter("newname")!=null || request.getParameter("newdesc")!=null || request.getParameter("newlevel")!=null) {
                Empire oldemp=es.get(selected);
                Empire newemp= new Empire();
                newemp=oldemp;
                if (request.getParameter("newname").equals("")) {
                    newemp.setName(request.getParameter("newname"));
                }
                if (request.getParameter("newdesc").equals("")) {
                    newemp.setDescription(request.getParameter("newdesc"));     
                }
                es.modify(selected, newemp);
            }
        }
        if (request.getParameter("delete")!=null) {
            es.delete(selected);
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
