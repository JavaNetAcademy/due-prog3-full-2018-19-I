/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.building.service.object;

import hu.javanetacademy.hoe.building.dao.file.BuildingJDBCDAOImpl;
import hu.javanetacademy.hoe.building.dao.model.Building;
import hu.javanetacademy.hoe.building.dao.model.BuildingDaoInterface;
import hu.javanetacademy.hoe.base.util.CustomException;
import java.util.List;



/**
 *
 * @author JUHASZ
 */
public class BuildingService {
    private BuildingDaoInterface dao = new BuildingJDBCDAOImpl();
    
    public Building create(Building pNewBuilding){
        Building avb = dao.getByNameFromUser(pNewBuilding.getName(),pNewBuilding.getUserid());
        if(avb==null)
            return dao.create(pNewBuilding);
        else 
            throw new CustomException();
    }
    
    public List<Building> getBuildingByUser(long pUserId){
        return dao.getByUser(pUserId);
    }
    
}
