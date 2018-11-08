/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.herostatus.web.herostatus.web;
import hu.javanetacademy.hoe.herostatus.servlet.object.herostatus.servlet.object.heroStatusServiceObjectImpl;
import hu.javanetacademy.hoe.herostatus.dao.model.herostatus.dao.model.heroStatus;
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
 * @author majermarci
 */
@WebServlet(urlPatterns = {"/hero/herostatusDelMod"})
public class heroStatusServletDelMod extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      response.setContentType("text/html;charset=UTF-8");
        getServletContext().getRequestDispatcher("/herostatus.jsp").forward(request, response);
        
     
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        heroStatusServiceObjectImpl ls=new heroStatusServiceObjectImpl();
        long selected = Long.parseLong(request.getParameter("selectid"));
        if (request.getParameter("modify")!=null) {
            heroStatus oldstat=ls.get(selected);
            heroStatus newstat = new heroStatus();
            newstat=oldstat;
            newstat.setHealth(Long.parseLong(request.getParameter("newhealth")));
            newstat.setMana(Long.parseLong(request.getParameter("newmana")));  
            newstat.setLevel(Long.parseLong(request.getParameter("newlevel")));
            newstat.setExperience(Long.parseLong(request.getParameter("newexperience")));  
            newstat.setIntellect(Long.parseLong(request.getParameter("newint")));  
            newstat.setStrength(Long.parseLong(request.getParameter("newstr")));
            newstat.setAgility(Long.parseLong(request.getParameter("newagi")));  
            ls.modify(selected, newstat);
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