/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.location.service.object;
import hu.javanetacademy.hoe.base.util.CustomException;
import hu.javanetacademy.hoe.location.dao.jdbc.LocationJDBCDAOImpl;
import hu.javanetacademy.hoe.location.dao.model.Location;
import hu.javanetacademy.hoe.location.dao.model.LocationDAOInterface;
import java.util.List;
/**
 *
 * @author thejumper203
 */
public class LocationService {
    LocationDAOInterface locdb=new LocationJDBCDAOImpl();
    
    public void create (String name,String descr, long empid) {
        if (!locdb.checkName(name,empid)) {
            Location loc=new Location();
            loc.setName(name);
            loc.setDesc(descr);
            loc.setEmpid(empid);
            locdb.create(loc);
        }
        else throw new CustomException("This location name already exists in the empire");
    }
    public List<Location> getByEmpire (long empid) {
        return locdb.getByEmpire(empid);
    }
    public void delete (long id)
    {
        locdb.delete(id);
    }
    public Location get(long id)
    {
       return locdb.get(id);
    }
    public Location modify (long oldid, Location newloc)
    {
        if (!locdb.checkName(newloc.getName(),newloc.getEmpid())) {
            return locdb.modify(oldid, newloc);
        }
        throw new CustomException("This location name already exists in the empire");
    }
}
