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
    public HeroClass modify(String pHeroClassName,String pHeroClassDescription, HeroClass pNewHeroClass);
    public HeroClass delete(String pHeroClassName);

    public HeroClass get(String pHeroClassName);
    public List<HeroClass> getAll();
}
