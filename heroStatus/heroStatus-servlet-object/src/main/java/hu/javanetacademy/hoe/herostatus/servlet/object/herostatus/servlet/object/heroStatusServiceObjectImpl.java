/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.herostatus.servlet.object.herostatus.servlet.object;

import java.util.List;
import hu.javanetacademy.hoe.herostatus.dao.model.herostatus.dao.model.heroStatus;
import hu.javanetacademy.hoe.herostatus.dao.model.herostatus.dao.model.heroStatusDao;
import hu.javanetacademy.hoe.herostatus.dao.jdbc.herostatus.dao.jdbc.heroStatusJDBCDAOImpl;

/**
 *
 * @author Attila
 */
public class heroStatusServiceObjectImpl {
    private heroStatusDao dao = new heroStatusJDBCDAOImpl();
    public heroStatus create(heroStatus pHeroStatus)
    {
        return dao.create(pHeroStatus);
    }
    public heroStatus modify(long pOldId, heroStatus pNewHeroStatus)
    {
        return dao.modify(pOldId,pNewHeroStatus);
    }
    public heroStatus delete(long pheroStatusId)
    {
        return dao.delete(pheroStatusId);
    }
    public heroStatus get(long pheroStatusId)
    {
        return dao.get(pheroStatusId);
    }
    public List<heroStatus> getAll()
    {
        return dao.getAll();
    }
    public List<heroStatus> getByLevel(long pLevel)
    {
        return dao.getByLevel(pLevel);
    }
}