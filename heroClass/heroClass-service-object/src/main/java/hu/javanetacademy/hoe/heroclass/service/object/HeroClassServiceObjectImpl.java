/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.heroclass.service.object;

import hu.javanetacademy.hoe.base.util.CustomException;
import hu.javanetacademy.hoe.heroclass.dao.jdbc.HeroClassDaoJDBCImpl;
import hu.javanetacademy.hoe.heroclass.dao.model.HeroClass;
import hu.javanetacademy.hoe.heroclass.dao.model.HeroClassDAOInterface;
import java.util.List;



/**
 *
 * @author Norbi
 */
public class HeroClassServiceObjectImpl {
    
    private HeroClassDAOInterface dao;
    
    public HeroClassServiceObjectImpl() {
        dao = new HeroClassDaoJDBCImpl();
    }
    
    public HeroClass create(HeroClass pNewHeroClass){
        HeroClass avb = dao.getByName(pNewHeroClass.getName());
        if (avb == null) {           
            return dao.create(pNewHeroClass);
        } else {
            throw new CustomException();
        }
    }
    public List<HeroClass> getHeroClassByUser(long pUserId) {
        return dao.getByUser(pUserId);
    }

    public HeroClass modifyHeroClass(long pOldHeroClassId, HeroClass pNewHeroClass) {
        return dao.modify(pOldHeroClassId, pNewHeroClass);
    }

    public HeroClass deleteHeroClass(long pHeroClassId) {
        return dao.delete(pHeroClassId);
    }

    public HeroClass getHeroClass(long pHeroClassId) {
        return dao.get(pHeroClassId);
    }

    public HeroClass getHeroClassByName(String pHeroClassName) {
        return dao.getByName(pHeroClassName);
    }
    public List<HeroClass> getAllHeroClasses() {
        return dao.getAll();
    }
}
