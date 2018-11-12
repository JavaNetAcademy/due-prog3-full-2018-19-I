package hu.javanetacademy.hoe.resources.web;
import hu.javanetacademy.hoe.createitem.dao.model.Item;
import hu.javanetacademy.hoe.item.service.object.ItemService;
import hu.javanetacademy.hoe.resources.dao.model.Resources;
import hu.javanetacademy.hoe.resources.service.object.ResourcesService;
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
 * @author jf6vmn
 */
@WebServlet(urlPatterns = {"/user/resources/new"})
public class NewResourcesServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {            
      response.setContentType("text/html;charset=UTF-8");
       User current=(User)request.getSession().getAttribute("user");
        ResourcesService ls = new ResourcesService();
        List<Resources>lista = ls.getList();
        List<Item>listaR = ls.getRList(current.getId());
        request.setAttribute("items", listaR);
        request.setAttribute("resources", lista);
        request.getRequestDispatcher("/newresources.jsp").forward(request, response);
        }
     
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
       ResourcesService ls=new ResourcesService();
       String name=request.getParameter("nev");
       String desc=request.getParameter("info");
        String meny =request.getParameter("mennyiseg");
        ls.create(name,desc,Long.parseLong(meny) );
        request.getRequestDispatcher("/user/resources").forward(request, response);
       
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
