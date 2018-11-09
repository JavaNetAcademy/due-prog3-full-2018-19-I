/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.spell.service.object.spell.service.object;

import hu.javanetacademy.hoe.spell.jdc.spell.dao.jdbc.SpellJDBCDAOImpl;
import hu.javanetacademy.hoe.spell.spell.dao.model.Spell;
import hu.javanetacademy.hoe.spell.spell.dao.model.SpellDao;
import java.util.List;

/**
 *
 * @author Attila
 */
public class SpellServiceObjectImpl {
    private SpellDao dao = new SpellJDBCDAOImpl();
   /*
    public Spell create(Spell pSpell);
    public Spell modify(long pOldSpellId, Spell pNewSpell);
    public Spell delete(long pSpellId);
    public Spell get(long pSpellId);
    public List<Spell> getByHero(long pclassid);
    */
    public Spell create(Spell pSpell)
    {
        return dao.create(pSpell);
    }
    public Spell modify(long pOldSpellId, Spell pNewSpell)
    {
        return dao.modify(pOldSpellId,pNewSpell);
    }
    public Spell delete(long pSpellId)
    {
        return dao.delete(pSpellId);
    }
    public Spell get(long id)
    {
        return dao.get(id);
    }
    public List<Spell> getAll()
    {
        return dao.getAll();
    }
    public List<Spell> getByClass(String classid)
    {
        return dao.getByClass(classid);
    }
}