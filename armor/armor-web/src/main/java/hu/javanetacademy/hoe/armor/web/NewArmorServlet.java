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
@WebServlet(urlPatterns = {"/user/armor/newarmor"})
public class NewArmorServlet extends HttpServlet {
       // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       User current=(User)request.getSession().getAttribute("user");
       ArmorService ls = new ArmorService();
        List<Resources>listaR = ls.getRList();
        List<Armor>armors = ls.getList(current.getId());
          request.setAttribute("armors", ls);
          request.setAttribute("current", current);
          request.setAttribute("resources", listaR);
          request.getRequestDispatcher("/newarmor.jsp").forward(request, response);
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
        ArmorService ls=new ArmorService();
        String name=request.getParameter("nev");
        String desc=request.getParameter("info");
        String tam =request.getParameter("tamadoertek");
        String ved = request.getParameter("vedoertek");
        String nyers = request.getParameter("nyersanyag");
        User current=(User)request.getSession().getAttribute("user");        
        ls.create(name,desc,Long.parseLong(tam),Long.parseLong(ved),current.getId(),Long.parseLong(nyers));
        request.getRequestDispatcher("/user/armor").forward(request, response);
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
