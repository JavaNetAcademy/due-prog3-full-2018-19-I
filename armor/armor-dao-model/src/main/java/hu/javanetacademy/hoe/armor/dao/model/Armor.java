package hu.javanetacademy.hoe.armor.dao.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author  Mckyni
 */
public class Armor {
      private long id,nyersanyagid;

    public long getNyersanyagid() {
        return nyersanyagid;
    }

    public void setNyersanyagid(long nyersanyagid) {
        this.nyersanyagid = nyersanyagid;
    }
      private String nev;
      private String info;
      private long tamadoertek;
      private long vedoertek;
      private long userid;

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

    public long getTamadoertek() {
        return tamadoertek;
    }

    public void setTamadoertek(long tamadoertek) {
        this.tamadoertek = tamadoertek;
    }

    public long getVedoertek() {
        return vedoertek;
    }

    public void setVedoertek(long vedoertek) {
        this.vedoertek = vedoertek;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }
      

    public Armor(long id, String nev, String info, long tamadoertek, long vedoertek, long userid, long nyersanyagid) {
        this.id = id;
        this.nev = nev;
        this.info = info;
        this.tamadoertek = tamadoertek;
        this.vedoertek = vedoertek;
        this.userid = userid;
        this.nyersanyagid = nyersanyagid;
    }
    public Armor()
    {
    }
      
}
