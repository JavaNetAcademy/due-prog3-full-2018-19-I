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

    private BuildingDaoInterface dao;

    public BuildingService() {
        dao = new BuildingJDBCDAOImpl();
        //System.err.println("------ ++++++++++++++++++++++++++++++ ----------------");
    }

    public Building create(Building pNewBuilding) {
        Building avb = dao.getByName(pNewBuilding.getName());
        if (avb == null) {
            //System.err.println("------ NO building prior in DB ---------------- BuildingService create");
            return dao.create(pNewBuilding);
        } else {
            //System.err.println("------ YES building prior in DB ---------------- BuildingService create");
            throw new CustomException();
        }
    }

    public List<Building> getBuildingsByUser(long pUserId) {
        return dao.getByUser(pUserId);
    }

    public Building modifyBuilding(long pOldBuildingId, Building pNewBuilding) {
        return dao.modify(pOldBuildingId, pNewBuilding);
    }

    public Building deleteBuilding(long pBuildingID) {
        return dao.delete(pBuildingID);
    }

    public Building getBuilding(long pBuildingId) {
        return dao.get(pBuildingId);
    }

    public Building getBuildingByName(String pBuildingName) {
        return dao.getByName(pBuildingName);
    }

    public Building changeBuildingOwner(long pBuildingID, long pUserId) {
        return dao.changeOwnerUser(pBuildingID, pUserId);
    }

    public List<Building> getAllBuildings() {
        return dao.getAll();
    }
}
