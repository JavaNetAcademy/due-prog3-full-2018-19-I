/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.magicitem.dao.model;

/**
 *
 * @author Sardi Gergely - FRHZU1
 */
public class magicItem {
    // Azonosító
    private long id;
    // Neve
    private String nev;
    // Leírás 
    private String info;
    //Menyiség
    private long mennyiseg;

    public magicItem(long id, String nev, String info, long mennyiseg) {
        this.id = id;
        this.nev = nev;
        this.info = info;
        this.mennyiseg = mennyiseg;
    }

    public magicItem() {
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
