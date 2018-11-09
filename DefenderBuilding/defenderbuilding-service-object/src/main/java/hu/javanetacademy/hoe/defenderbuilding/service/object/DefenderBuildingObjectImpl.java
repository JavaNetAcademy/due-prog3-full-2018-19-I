/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.defenderbuilding.service.object;
import hu.javanetacademy.hoe.defenderbuilding.dao.jdbc.DefenderbuildingJbcDao;
import hu.javanetacademy.hoe.defenderbuilding.dao.model.DefenderBuilding;
import hu.javanetacademy.hoe.defenderbuilding.dao.model.Defenderbuildingdaointerface;
import java.util.List;
/**
 *
 * @author saba
 */
public class DefenderBuildingObjectImpl {
    Defenderbuildingdaointerface dao = new DefenderbuildingJbcDao();
    
    public void create (long id, String name,String description, long attack,long armor) {
        DefenderBuilding defbuild=new DefenderBuilding();
        defbuild.setId(id);
        defbuild.setName(name);
        defbuild.setDescription(description);
        defbuild.setAttack(attack);
        defbuild.setArmor(armor);
        dao.create(defbuild);
    }
    
    public DefenderBuilding  getById(long id)
    {
        return dao.getById(id);
    }
    public DefenderBuilding  modify (long id, DefenderBuilding  defbuild)
    {
        return dao.modify(id, defbuild);
    }
    public void delete (long id)
    {
        dao.delete(id);
    }

    public List<DefenderBuilding > getByUser(long id) {
        return null;
    }
}
