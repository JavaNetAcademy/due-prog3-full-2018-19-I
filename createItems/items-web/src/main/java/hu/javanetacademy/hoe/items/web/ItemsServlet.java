package hu.javanetacademy.hoe.items.web;
import hu.javanetacademy.hoe.createitem.dao.model.Item;
import java.io.IOException;
import java.io.PrintWriter;
import hu.javanetacademy.hoe.item.service.object.ItemService;
import hu.javanetacademy.hoe.user.dao.model.User;
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
@WebServlet(urlPatterns = {"/user/items"})
public class ItemsServlet extends HttpServlet {
    private ItemService is=new ItemService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User current=(User)request.getSession().getAttribute("user");
        List<Item> items=is.getList(current.getId());
        request.setAttribute("items", items);
        request.setAttribute("current", current);
        request.getRequestDispatcher("/items.jsp").forward(request, response);
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
