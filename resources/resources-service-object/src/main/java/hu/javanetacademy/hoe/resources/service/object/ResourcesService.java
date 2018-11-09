/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.resources.service.object;
import hu.javanetacademy.hoe.resources.dao.jdbc.ResourcesJDBCDAOImpl;
import hu.javanetacademy.hoe.resources.dao.model.Resources;
import hu.javanetacademy.hoe.resources.dao.model.ResourcesInterface;
import java.util.List;

/**
 *
 * @author jf6vmn
 */
public class ResourcesService {
     ResourcesInterface locdb=new ResourcesJDBCDAOImpl();    
    public void create (String nev,String info, long mennyiseg) {
        Resources loc=new Resources();
        loc.setNev(nev);
        loc.setInfo(info);
        loc.setMennyiseg(mennyiseg);
        locdb.create(loc);
    }
    public void delete (long id)
    {
        locdb.delete(id);
    }
   
    public Resources modify (long id, Resources newdata)
    {
        return locdb.modify(id, newdata);
    }

    public Resources get(long id) {
        return locdb.get(id);
    }
     public List<Resources> getList () {
        return locdb.getList();
    }
}
