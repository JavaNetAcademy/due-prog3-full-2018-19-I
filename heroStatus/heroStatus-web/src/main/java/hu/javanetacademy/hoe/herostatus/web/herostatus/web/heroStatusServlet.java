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
 * @author Attila
 */
@WebServlet(urlPatterns = {"/hero/herostatus"})
public class heroStatusServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        heroStatusServiceObjectImpl herostatusserv = new heroStatusServiceObjectImpl();
        List<heroStatus> herostatus=herostatusserv.getAll();
        request.setAttribute("herostatus", herostatus);
        request.getRequestDispatcher("/herostatus.jsp").forward(request, response);
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}