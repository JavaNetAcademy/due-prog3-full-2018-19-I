/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.empire.dao.model;

import java.util.List;
import hu.javanetacademy.hoe.location.dao.model.Location;



     

/**
 *
 * @author kovacsmate96
 */
public interface EmpireDAOInterface {
    public Empire create(Empire pEmpire);
public Empire modify(long pOldEmpireId, Empire pNewEmpire);
public Empire delete(long pEmpireId);

public Empire get(long pEmpireId);
public List<Empire> getByUser(long pUserId);
public List<Location> getLocations (long pEmpireId);
}
