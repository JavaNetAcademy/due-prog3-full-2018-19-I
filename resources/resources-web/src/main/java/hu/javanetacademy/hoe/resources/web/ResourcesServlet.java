package hu.javanetacademy.hoe.resources.web;
import hu.javanetacademy.hoe.resources.dao.model.Resources;
import java.io.IOException;
import java.io.PrintWriter;
import hu.javanetacademy.hoe.resources.service.object.ResourcesService;
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
@WebServlet(urlPatterns = {"/user/resources"})
public class ResourcesServlet extends HttpServlet{
    private ResourcesService is =new ResourcesService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Resources> resources=is.getList();
        request.setAttribute("resources", resources);
        request.getRequestDispatcher("/resources.jsp").forward(request, response);
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