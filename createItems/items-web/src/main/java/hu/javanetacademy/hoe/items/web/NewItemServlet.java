package hu.javanetacademy.hoe.items.web;
import hu.javanetacademy.hoe.createitem.dao.model.Item;
import hu.javanetacademy.hoe.item.service.object.ItemService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import hu.javanetacademy.hoe.resources.dao.model.Resources;

/**
 *
 * @author Nagy Adam
 */
@WebServlet(urlPatterns = {"/user/items/new"})
public class NewItemServlet extends HttpServlet {
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {            
      response.setContentType("text/html;charset=UTF-8");
       ItemService ls = new ItemService();
        List<Item>lista = ls.getList();
        List<Resources>listaR = ls.getRList();
        request.setAttribute("items", lista);
        request.setAttribute("resources", listaR);
        request.getRequestDispatcher("/newitem.jsp").forward(request, response);
        }
     
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
         ItemService ls=new ItemService();
       String name=request.getParameter("nev");
       String desc=request.getParameter("info");
        String meny =request.getParameter("mennyiseg");
        String nyers = request.getParameter("selectedItem");
        ls.create(name,desc,Long.parseLong(meny) );
        request.getRequestDispatcher("/user/items").forward(request, response);
       
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
