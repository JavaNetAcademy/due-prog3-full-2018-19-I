/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.vehicle.dao.model;

import java.util.List;

/**
 *
 * @author ttama
 */
public interface VehicleDaoInterface {
    //public List<Vehicle> getAll();
    public Vehicle getById(long id);
    public Vehicle create(Vehicle vehicle);
    public Vehicle modify(long id, Vehicle vehicle);
    public Vehicle delete(long id);

   // public List<Vehicle> getByUser(long id);

   // public List<Vehicle> getByUser(long id);
}
