/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.empire.service.object;
import hu.javanetacademy.hoe.empire.dao.jdbc.EmpireJDBCDAOImpl;
import hu.javanetacademy.hoe.empire.dao.model.Empire;
import hu.javanetacademy.hoe.empire.dao.model.EmpireDAOInterface;
import hu.javanetacademy.hoe.location.dao.model.Location;
import java.util.List;

/**
 *
 * @author kovacsmate96
 */
public class EmpireServiceObjectImpl {
    EmpireDAOInterface dao = new EmpireJDBCDAOImpl();
    
    public void create (String name,String descr, int level,long userid) {
        Empire emp=new Empire();
        emp.setName(name);
        emp.setDescription(descr);
        emp.setLevel(level);
        emp.setUserid(userid);
        dao.create(emp);
    }
    
    public List<Empire> getByUser(long userid)
    {
        return dao.getByUser(userid);
    }
    public List<Location> getLocations(long empid)
    {
        return dao.getLocations(empid);
    }
    public Empire get(long id)
    {
        return dao.get(id);
    }
    public Empire modify (long oldid, Empire newemp)
    {
        return dao.modify(oldid, newemp);
    }
    public void delete (long id)
    {
        dao.delete(id);
    }
}
