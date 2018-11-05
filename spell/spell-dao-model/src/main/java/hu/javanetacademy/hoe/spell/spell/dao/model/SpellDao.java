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
    public Spell create(Spell newSpell);
    public Spell modify(long pOldSpellId, Spell spellMod);
    public Spell delete(long spellId);

    public Spell get(long spellId);
    public List<Spell> getByHero(long heroid);
}
