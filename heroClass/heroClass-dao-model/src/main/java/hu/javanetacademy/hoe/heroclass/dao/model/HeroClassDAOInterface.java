/*s
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.heroclass.dao.model;

import java.util.List;

/**
 *
 * @author Norbi
 */
public interface HeroClassDAOInterface {
    public HeroClass create(HeroClass pHeroClass);
    public HeroClass modify(long pOldHeroClassId, HeroClass pNewHeroClass);
    public HeroClass delete(long pHeroClassId);

    public HeroClass get(long pHeroClassId);
    public List<HeroClass> getByUser(long pUserId);
    public HeroClass getByName(String pHeroClassName);
    public List<HeroClass> getAll();
}
