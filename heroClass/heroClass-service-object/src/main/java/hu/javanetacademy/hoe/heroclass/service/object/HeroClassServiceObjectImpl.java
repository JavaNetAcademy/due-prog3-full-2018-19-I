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
    /*
    public HeroClass create(HeroClass pHeroClass);
    public HeroClass modify(String pHeroClassName,String pHeroClassDescription, HeroClass pNewHeroClass);
    public HeroClass delete(String pHeroClassName);

    public HeroClass get(String pHeroClassName);
    public List<HeroClass> getAll();
*/
    private HeroClassDAOInterface dao = new HeroClassDaoJDBCImpl();
    
    
    public HeroClass create(HeroClass pHeroClass){
        HeroClass avb = dao.get(pHeroClass.getName());
        if (avb == null) {           
            return dao.create(pHeroClass);
        } else {
            throw new CustomException();
        }
    }

    public HeroClass modify(String pHeroClassName,String pHeroClassDescription, HeroClass pNewHeroClass) {
        return dao.modify(pHeroClassName, pHeroClassDescription,pNewHeroClass);
    }

    public HeroClass delete(String pHeroClassName) {
        return dao.delete(pHeroClassName);
    }

    public HeroClass get(String pHeroClassName) {
        return dao.get(pHeroClassName);
    }
    public List<HeroClass> getAll() {
        return dao.getAll();
    }
}
