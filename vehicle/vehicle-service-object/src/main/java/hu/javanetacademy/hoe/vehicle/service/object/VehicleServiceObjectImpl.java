/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.vehicle.service.object;
import hu.javanetacademy.hoe.vehicle.dao.jdbc.VehicleJdbcDao;
import hu.javanetacademy.hoe.vehicle.dao.model.Vehicle;
import hu.javanetacademy.hoe.vehicle.dao.model.VehicleDaoInterface;
import java.util.List;

/**
 *
 * @author ttama
 */
public class VehicleServiceObjectImpl {
    VehicleDaoInterface dao = new VehicleJdbcDao();
    
    public void create (long id, String name,String info, long speed) {
        Vehicle vehicle=new Vehicle();
        vehicle.setId(id);
        vehicle.setName(name);
        vehicle.setInfo(info);
        vehicle.setSpeed(speed);
        dao.create(vehicle);
    }
    
    public Vehicle getById(long id)
    {
        return dao.getById(id);
    }
    public Vehicle modify (long id, Vehicle vehicle)
    {
        return dao.modify(id, vehicle);
    }
    public void delete (long id)
    {
        dao.delete(id);
    }

    public List<Vehicle> getByUser(long id) {
        return null;
     //   return dao.getByUser(id);
    }
}
