/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.createitem.dao.model;

/**
 *
 * @author Nagy Adam
 */
public class Item {
    // Azonosító
    private long id;
    // Neve
    private String nev;
    // Leírás 
    private String info;
    //Menyiség
    private long mennyiseg;
    
    private long nyersanyagid;

    public long getNyersanyagid() {
        return nyersanyagid;
    }

    public void setNyersanyagid(long nyersanyagid) {
        this.nyersanyagid = nyersanyagid;
    }

    public Item(long id, String nev, String info, long mennyiseg, long nyersanyagid) {
        this.id = id;
        this.nev = nev;
        this.info = info;
        this.mennyiseg = mennyiseg;
        this.nyersanyagid = nyersanyagid;
    }

    public Item() {
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

    public void setName(String parameter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
