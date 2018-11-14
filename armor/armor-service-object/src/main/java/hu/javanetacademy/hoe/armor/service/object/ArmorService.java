/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.armor.service.object;
import hu.javanetacademy.hoe.armor.dao.model.ArmorDAOInterface;
import hu.javanetacademy.hoe.armor.dao.model.Armor;
import hu.javanetacademy.hoe.armor.dao.jdbc.ArmorJDBCDAOImpl;
import hu.javanetacademy.hoe.resources.dao.jdbc.ResourcesJDBCDAOImpl;
import hu.javanetacademy.hoe.resources.dao.model.Resources;
import hu.javanetacademy.hoe.resources.dao.model.ResourcesInterface;
import java.util.List;
/**
 *
 * @author Mckyni
 */
public class ArmorService {
    ArmorDAOInterface locdb=new ArmorJDBCDAOImpl(); 
     ResourcesInterface locR=new ResourcesJDBCDAOImpl();
    public void create (String nev,String info, long tamadoertek,long vedoertek,long userid,long nyersanyagid) {
        Armor loc=new Armor();
        loc.setNev(nev);
        loc.setInfo(info);
        loc.setTamadoertek(tamadoertek);
        loc.setVedoertek(vedoertek);
        loc.setUserid(userid);
        loc.setNyersanyagid(nyersanyagid);
        locdb.create(loc);
    }
    public void delete (long id)
    {
        locdb.delete(id);
    }
   
    public Armor modify (long id, Armor newdata)
    {
        return locdb.modify(id, newdata);
    }

    public Armor get(long id) {
        return locdb.get(id);
    }
     public List<Armor> getList (long userid) {
        return locdb.getList(userid);
    }
      public List<Resources> getRList(){
      return locR.getList();
     } 
}
