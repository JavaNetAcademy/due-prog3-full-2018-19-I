/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.building.dao.model;


import java.util.List;

/**
 *
 * @author JUHASZ
 */
public interface BuildingDaoInterface {
    public Building create (Building pBuilding);
    public Building modify(long pOldBuildingId, Building pNewBuilding);
    public Building delete(long pBuildingID);
    
    public Building get(long pBuildingId);
    public List<Building> getByUser(long pUserId);
    public Building getByName(String pBuildingName);
    
    public Building changeOwnerUser(long pBuildingID,long pUserId);
    public List<Building> getAll();
    
}
