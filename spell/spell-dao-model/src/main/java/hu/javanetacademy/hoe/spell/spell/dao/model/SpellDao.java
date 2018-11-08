/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.spell.spell.dao.model;

import java.util.List;

/**
 *
 * @author Attila
 */
public interface SpellDao {
    public Spell create(Spell pSpell);
    public Spell modify(long pOldSpellId, Spell pNewSpell);
    public Spell delete(long pSpellId);
    public Spell get(long pSpellId);
    public List<Spell> getAll();
    public List<Spell> getByHero(long pHeroId);
}
