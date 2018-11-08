/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.mobs.web;
import hu.javanetacademy.hoe.mobs.service.object.MobsService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Major Bence
 */
@WebServlet(urlPatterns = {"/user/mobs/new"})
public class NewMobsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      response.setContentType("text/html;charset=UTF-8");
        getServletContext().getRequestDispatcher("/mobs.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         MobsService ls=new MobsService();
       String name=request.getParameter("nev");
       int lvl=Integer.parseInt(request.getParameter("lvl"));
       int attackpoints=Integer.parseInt(request.getParameter("attackpoints"));
       int defensepoints=Integer.parseInt(request.getParameter("defensepoints"));
       double posx=Double.valueOf(request.getParameter("posx"));
       double posy=Double.valueOf(request.getParameter("posy"));
        ls.Create(name,lvl,attackpoints,defensepoints,posx,posy );
       
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
