package hu.javanetacademy.hoe.user.web;

import hu.javanetacademy.hoe.base.util.CustomException;
import hu.javanetacademy.hoe.user.dao.model.User;
import hu.javanetacademy.hoe.user.servece.object.UserServiceObjectImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author krisztian
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/user/login"})
public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        try {
            String name = request.getParameter("pname");
            String password = request.getParameter("ppassword");
            UserServiceObjectImpl service = new UserServiceObjectImpl();
            User user=service.login(name, password);
            request.getSession().setAttribute("user", user); 
            getServletContext().getRequestDispatcher("/index").include(request, response);
        } catch (CustomException ex) {
            request.setAttribute("errormessage", ex.getMessage());
            request.getRequestDispatcher("/errorpage.jsp").forward(request, response);
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
