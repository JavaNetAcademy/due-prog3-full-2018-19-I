/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.item.service.object;
import hu.javanetacademy.hoe.item.dao.jdbc.ItemJDBCDAOImpl;
import hu.javanetacademy.hoe.createitem.dao.model.Item;
import hu.javanetacademy.hoe.createitem.dao.model.ItemDAOInterface;
import java.util.List;
/**
 *
 * @author Nagy Adam
 */
public class ItemService {
     ItemDAOInterface locdb=new ItemJDBCDAOImpl();    
    public void create (String nev,String info, long mennyiseg) {
        Item loc=new Item();
        loc.setNev(nev);
        loc.setInfo(info);
        loc.setMennyiseg(mennyiseg);
        locdb.create(loc);
    }
    public void delete (long id)
    {
        locdb.delete(id);
    }
   
    public Item modify (long id, Item newdata)
    {
        return locdb.modify(id, newdata);
    }
}
