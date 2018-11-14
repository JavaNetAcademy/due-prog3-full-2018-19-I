package hu.javanetacademy.hoe.armor.web;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import hu.javanetacademy.hoe.armor.dao.model.Armor;
import hu.javanetacademy.hoe.armor.service.object.ArmorService;
import hu.javanetacademy.hoe.resources.dao.model.Resources;
import hu.javanetacademy.hoe.user.dao.model.User;
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
 * @author Nagy Adam
 */
@WebServlet(urlPatterns = {"/user/armor/delarmor"})
public class DelArmorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         User current=(User)request.getSession().getAttribute("user");
        ArmorService ls = new ArmorService();
        List<Resources>listaR = ls.getRList();
        List<Armor>armors = ls.getList(current.getId());
        request.setAttribute("armors", armors);
        request.setAttribute("resources", listaR);
        request.getRequestDispatcher("/delarmors.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       ArmorService ls = new ArmorService();
        long selected = Long.parseLong(request.getParameter("selectedArmor"));
        if (request.getParameter("modify")!=null) {
            if (request.getParameter("newname")!=null || request.getParameter("newinfo")!=null) {
                Armor oldloc=ls.get(selected);
                Armor newmennyiseg= new Armor();
                newmennyiseg=oldloc;
                if (!request.getParameter("newname").equals("")) {
                    newmennyiseg.setNev(request.getParameter("newname"));
                }
                if (!request.getParameter("newinfo").equals("")) {
                    newmennyiseg.setInfo(request.getParameter("newinfo"));     
                }
                if (!request.getParameter("newtamadoertek").equals("")) {
                    newmennyiseg.setTamadoertek(Long.parseLong(request.getParameter("newtamadoertek")));     
                }
                if(!request.getParameter("newvedoertek").equals("")){
                   newmennyiseg.setVedoertek(Long.parseLong(request.getParameter("newvedoertek")));
                }
                if(!request.getParameter("selectednyersanyag").equals("")){
                   newmennyiseg.setNyersanyagid(Long.parseLong(request.getParameter("selectednyersanyag")));
                ls.modify(selected, newmennyiseg);
                }
            }
        }
        if (request.getParameter("delete")!=null) {
            ls.delete(selected);
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
