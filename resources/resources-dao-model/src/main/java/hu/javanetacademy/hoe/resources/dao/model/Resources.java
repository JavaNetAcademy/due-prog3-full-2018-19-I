/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.resources.dao.model;

/**
 *
 * @author jf6vmn
 */
public class Resources {
    private long id;
    private String nev;
    private String info;
    private long mennyiseg;

    public Resources(long id, String nev, String info, long mennyiseg) {
        this.id = id;
        this.nev = nev;
        this.info = info;
        this.mennyiseg = mennyiseg;
    }

    public Resources() {
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
        throw new UnsupportedOperationException("Ilyen biza' nincsen még! De nincsen ám..."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
