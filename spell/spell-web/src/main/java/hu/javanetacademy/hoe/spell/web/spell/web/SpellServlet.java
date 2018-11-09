/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hu.javanetacademy.hoe.spell.web.spell.web;
import hu.javanetacademy.hoe.user.dao.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import hu.javanetacademy.hoe.spell.jdc.spell.dao.jdbc.SpellJDBCDAOImpl;
import hu.javanetacademy.hoe.spell.spell.dao.model.Spell;
import hu.javanetacademy.hoe.spell.service.object.spell.service.object.SpellServiceObjectImpl;
/**
 *
 * @author Attila
 */
@WebServlet(urlPatterns = {"/spell"})
public class SpellServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        SpellServiceObjectImpl spellserv =new SpellServiceObjectImpl();
        String sel= request.getParameter("selectid");
        List<Spell> spells=spellserv.getByClass(sel);
        List<Spell> spellsAll=spellserv.getAll();
        request.setAttribute("spells", spells);
        request.setAttribute("spellsAll", spellsAll);
        request.getRequestDispatcher("/spell.jsp").forward(request, response);
        
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
