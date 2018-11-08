/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.location.dao.model;

import java.util.List;

/**
 *
 * @author thejumper203
 */
public interface LocationDAOInterface {
    public Location create (Location pLocation);
    public Location modify (long pOldLocationId, Location pNewLocation);
    public Location delete (long LocationId);
    public Location get(long pLocationId);
    public List<Location> getByEmpire(long pEmpireId);
    public boolean checkName(String name,long empid);
    public long getCount(long empid);
}
