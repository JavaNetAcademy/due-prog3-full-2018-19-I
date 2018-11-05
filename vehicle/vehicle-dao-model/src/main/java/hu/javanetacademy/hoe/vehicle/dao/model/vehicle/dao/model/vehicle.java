/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.vehicle.dao.model.vehicle.dao.model;

/**
 *
 * @author ttama
 */
public class vehicle {
        // Azonosító
    private long id;
    // Neve
    private String nev;
    // Leírás
    private String info;
    // sebesseg
    private long speed;

    public vehicle(long id, String nev, String info, long speed) {
        this.id = id;
        this.nev = nev;
        this.info = info;
        this.speed = speed;
    }

    public vehicle() {
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

    public long getSpeed() {
        return speed;
    }

    public void setSpeed(long speed) {
        this.speed = speed;
    }
    
    
}
