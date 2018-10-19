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
    // Azonosító
    private long id;
    // Neve
    private String nev;
    // Leírás
    private String info;
    // Támadó erő
    private long attpower;
    // Támadó Védekező erő
    private long deffpower;

    
    // Constructor
    public Spell(long id, String nev, String info, long attpower, long deffpower) {
        this.id = id;
        this.nev = nev;
        this.info = info;
        this.attpower = attpower;
        this.deffpower = deffpower;
    }

    // Getter / Setter
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
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
