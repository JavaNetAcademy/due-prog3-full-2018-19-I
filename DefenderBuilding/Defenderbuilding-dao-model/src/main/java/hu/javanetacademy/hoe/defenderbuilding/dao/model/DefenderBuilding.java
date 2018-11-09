/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.defenderbuilding.dao.model;

/**
 *
 * @author csaba
 */
public class DefenderBuilding {
    // Azonosito
    private long id;
    //Hős Id-ja
    private long baseid;
    // Neve
    private String name;
    // Leiras
    private String description;
    // Adatok
    private long armor;
    private long attack;

    public DefenderBuilding(long id, long baseid, String name, String info, long armor,long attack) {
        this.id = id;
        this.name = name;
        this.description = info;
        this.armor=armor;
        this.attack=attack;        
        this.baseid = baseid;
    }

    public DefenderBuilding() {
        
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public long getBaseid() {
        return baseid;
    }

    public void setBaseid(long baseid) {
        this.baseid = baseid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getArmor() {
        return armor;
    }

    public void setArmor(long armor) {
        this.armor = armor;
    }

    public long getAttack() {
        return attack;
    }

    public void setAttack(long attack) {
        this.attack = attack;
    }

    
}
