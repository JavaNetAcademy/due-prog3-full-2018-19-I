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
    private long id;
    // Neve
    private String classid;
    private String name;
    // Leírás
    private String description;
    // Támadó erő
    private long attpower;
    // Támadó Védekező erő
    private long deffpower;

    public Spell(long id, String classid, String name, String description, long attpower, long deffpower) {
        this.id = id;
        this.classid = classid;
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

    public String getclassid() {
        return classid;
    }

    public void setclassid(String classid) {
        this.classid = classid;
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
