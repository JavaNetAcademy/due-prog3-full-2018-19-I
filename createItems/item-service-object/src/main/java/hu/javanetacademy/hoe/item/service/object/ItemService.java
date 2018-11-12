/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.item.service.object;
import hu.javanetacademy.hoe.resources.dao.model.Resources;
import hu.javanetacademy.hoe.resources.dao.jdbc.ResourcesJDBCDAOImpl;
import hu.javanetacademy.hoe.resources.dao.model.ResourcesInterface;
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
     ResourcesInterface locR=new ResourcesJDBCDAOImpl();
    public void create (String nev,String info, long mennyiseg,long nyersanyagid,long userid) {
        Item loc=new Item();
        loc.setNev(nev);
        loc.setInfo(info);
        loc.setMennyiseg(mennyiseg);
        loc.setNyersanyagid(nyersanyagid);
        loc.setUserid(userid);
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

    public Item get(long id) {
        return locdb.get(id);
    }
     public List<Item> getList (long userid) {
        return locdb.getList(userid);
    }
     public List<Resources> getRList(){
      return locR.getList();
     }      
}
