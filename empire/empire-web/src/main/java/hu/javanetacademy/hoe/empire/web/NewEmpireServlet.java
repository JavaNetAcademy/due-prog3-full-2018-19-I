package hu.javanetacademy.hoe.empire.web;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import hu.javanetacademy.hoe.empire.service.object.EmpireServiceObjectImpl;
import hu.javanetacademy.hoe.user.dao.model.User;
/**
 *
 * @author kovacsmate96
 */
@WebServlet(urlPatterns = {"/user/empires/new"})
public class NewEmpireServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        getServletContext().getRequestDispatcher("/empire.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       EmpireServiceObjectImpl es=new EmpireServiceObjectImpl();
       String name=request.getParameter("pname");
       String desc=request.getParameter("pdesc");
       String level=request.getParameter("plevel");
       User loggedInUser=(User)request.getSession().getAttribute("user");
       es.create(name,desc,Integer.parseInt(level),loggedInUser.getId());
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
