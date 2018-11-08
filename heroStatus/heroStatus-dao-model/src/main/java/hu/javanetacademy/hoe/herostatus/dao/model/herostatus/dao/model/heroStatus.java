/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.herostatus.dao.model.herostatus.dao.model;

/**
 *
 * @author Attila
 */
public class heroStatus {
    private long heroid;
    private long health;
    private long mana;
    private long level;
    private long experience;
    private long intellect;
    private long strength;
    private long agility;

    public heroStatus(long heroid, long health, long mana, long level, long experience, long intellect, long strength, long agility) {
        this.heroid = heroid;
        this.health = health;
        this.mana = mana;
        this.level = level;
        this.experience = experience;
        this.intellect = intellect;
        this.strength = strength;
        this.agility = agility;
    }

    public heroStatus() {
    }
    
    public long getHeroid() {
        return heroid;
    }

    public void setHeroid(long heroid) {
        this.heroid = heroid;
    }

    public long getHealth() {
        return health;
    }

    public void setHealth(long health) {
        this.health = health;
    }

    public long getMana() {
        return mana;
    }

    public void setMana(long mana) {
        this.mana = mana;
    }

    public long getLevel() {
        return level;
    }

    public void setLevel(long level) {
        this.level = level;
    }

    public long getExperience() {
        return experience;
    }

    public void setExperience(long experience) {
        this.experience = experience;
    }

    public long getIntellect() {
        return intellect;
    }

    public void setIntellect(long intellect) {
        this.intellect = intellect;
    }

    public long getStrength() {
        return strength;
    }

    public void setStrength(long strength) {
        this.strength = strength;
    }

    public long getAgility() {
        return agility;
    }

    public void setAgility(long agility) {
        this.agility = agility;
    }
    
    
}
