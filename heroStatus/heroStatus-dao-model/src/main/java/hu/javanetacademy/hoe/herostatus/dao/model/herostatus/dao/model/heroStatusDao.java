/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.herostatus.dao.model.herostatus.dao.model;

import java.util.List;

/**
 *
 * @author Attila
 */
public interface heroStatusDao {
    public heroStatus create(heroStatus pHeroStatus);
    public heroStatus modify(long pOldId, heroStatus pNewHeroStatus);
    public heroStatus delete(long pheroStatusId);
    public heroStatus get(long pheroStatusId);
    public List<heroStatus> getAll();
    public List<heroStatus> getByLevel(long pLevel);
}
