/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.createitem.dao.model.createitem.dao.model;

/**
 *
 * @author Nagy Adam
 */
public class item {
    // Azonosító
    private long id;
    // Neve
    private String nev;
    // Leírás
    private String info;
    // Támadó erő
    private long mennyiseg;

    public item(long id, String nev, String info, long mennyiseg) {
        this.id = id;
        this.nev = nev;
        this.info = info;
        this.mennyiseg = mennyiseg;
    }

    public item() {
    }

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

    public long getMennyiseg() {
        return mennyiseg;
    }

    public void setMennyiseg(long mennyiseg) {
        this.mennyiseg = mennyiseg;
    }
    
}
