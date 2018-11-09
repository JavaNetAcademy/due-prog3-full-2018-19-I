package hu.javanetacademy.hoe.hero.dao.model;

import java.util.List;

/**
 * @author krisztian
 */
public interface HeroDAOInterface {

public Hero create(Hero pHero);
public Hero modify(long pOldId, Hero pNewHero);
public Hero delete(long pId);

public Hero get(long pId);
public List<Hero>getByName(String pName);
public List<Hero> getByUser(long pUserId);

}
