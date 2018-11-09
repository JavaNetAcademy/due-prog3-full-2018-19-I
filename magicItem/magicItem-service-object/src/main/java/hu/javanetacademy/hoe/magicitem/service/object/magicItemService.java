/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.magicitem.service.object;
import hu.javanetacademy.hoe.magicitem.dao.jdbc.magicItemJDBCDAOImpl;
import hu.javanetacademy.hoe.magicitem.dao.model.magicItem;
import hu.javanetacademy.hoe.magicitem.dao.model.magicItemDAOInterface;
import java.util.List;
/**
 *
 * @author Sardi Gergely - FRHZU1
 */
public class magicItemService {
     magicItemDAOInterface locdb=new magicItemJDBCDAOImpl();    
    public void create (String nev,String info, long mennyiseg) {
        magicItem loc=new magicItem();
        loc.setNev(nev);
        loc.setInfo(info);
        loc.setMennyiseg(mennyiseg);
        locdb.create(loc);
    }
    public void delete (long id)
    {
        locdb.delete(id);
    }
   
    public magicItem modify (long id, magicItem newdata)
    {
        return locdb.modify(id, newdata);
    }
}
