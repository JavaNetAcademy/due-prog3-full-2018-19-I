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
 * @author thejumper203
 */
public class EmpireServiceObjectImpl {
    EmpireDAOInterface dao = new EmpireJDBCDAOImpl();
    
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
    
}
