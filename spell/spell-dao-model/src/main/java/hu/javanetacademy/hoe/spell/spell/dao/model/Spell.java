/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.spell.spell.dao.model;

/**
 *
 * @author Attila
 */
public class Spell {
    // Azonosító, egyéni + hős akihez rendelve van a képesség
    private long id,heroid;
    // Neve
    private String name;
    // Leírás
    private String description;
    // Támadó erő
    private long attpower;
    // Támadó Védekező erő
    private long deffpower;

    public Spell(long id, long heroid, String name, String description, long attpower, long deffpower) {
        this.id = id;
        this.heroid = heroid;
        this.name = name;
        this.description = description;
        this.attpower = attpower;
        this.deffpower = deffpower;
    }

    public Spell() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getHeroid() {
        return heroid;
    }

    public void setHeroid(long heroid) {
        this.heroid = heroid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getAttpower() {
        return attpower;
    }

    public void setAttpower(long attpower) {
        this.attpower = attpower;
    }

    public long getDeffpower() {
        return deffpower;
    }

    public void setDeffpower(long deffpower) {
        this.deffpower = deffpower;
    }
    
    
}
