/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.mobs.service.object;
import hu.javanetacademy.hoe.mobs.dao.jdbc.MobsJDBCDAOImpl;
import hu.javanetacademy.hoe.mobs.dao.model.Mobs;
import hu.javanetacademy.hoe.mobs.dao.model.MobsDAOInterface;

/**
 *
 * @author Major Bence
 */
public class MobsService {
    MobsDAOInterface localdb=new MobsJDBCDAOImpl();
    public void Create(String name ,int lvl, int attackpoints, int defensepoints, double posx, double posy)
    {
        Mobs local = new Mobs();
        local.setName(name);
        local.setLvl(lvl);
        local.setAttackpoints(attackpoints);
        local.setDefensepoints(defensepoints);
        local.setPosx(posx);
        local.setPosy(posy);
        localdb.Create(local);
    }
    public void Delete(long id)
    {
        localdb.Delete(id);
    }
    public Mobs Modify(long id, Mobs newdata)
    {
        return localdb.Modify(id, newdata);
    }
}
