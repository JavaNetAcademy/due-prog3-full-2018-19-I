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

/**
 *
 * @author Nagy Adam
 */
@WebServlet(urlPatterns = {"/user/items/delitem"})
public class DelItemServlet extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ItemService ls = new ItemService();
        List<Item>lista = ls.getList();
        request.setAttribute("items", lista);
        request.getRequestDispatcher("/delitem.jsp").forward(request, response);
        
     //   processRequest(request, response);
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
        //doGet(request, response);
        ItemService ls = new ItemService();
        long selected = Long.parseLong(request.getParameter("selectedItem"));
        if (request.getParameter("modify")!=null) {
            if (request.getParameter("newname")!=null || request.getParameter("newinfo")!=null) {
                Item oldloc=ls.get(selected);
                Item newmennyiseg= new Item();
                newmennyiseg=oldloc;
                if (!request.getParameter("newname").equals("")) {
                    newmennyiseg.setNev(request.getParameter("newname"));
                }
                if (!request.getParameter("newinfo").equals("")) {
                    newmennyiseg.setInfo(request.getParameter("newinfo"));     
                }
                if (!request.getParameter("newamount").equals("")) {
                    newmennyiseg.setMennyiseg(Long.parseLong(request.getParameter("newinfo")));     
                }
                ls.modify(selected, newmennyiseg);
            }
        }
        if (request.getParameter("delete")!=null) {
            ls.delete(selected);
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
