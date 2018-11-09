/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.defenderbuilding.dao.model;
import java.util.List;
/**
 *
 * @author csaba
 */
public interface Defenderbuildingdaointerface {
    public DefenderBuilding getById(long id);
    public DefenderBuilding create(DefenderBuilding building);
    public DefenderBuilding modify(long id, DefenderBuilding building);
    public DefenderBuilding delete(long id);
}
