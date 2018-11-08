/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.vehicle.dao.model;

/**
 *
 * @author ttama
 */
public class Vehicle {
    // Azonosito
    private long id;
    // Nev
    private String name;
    // Leiras
    private String info;
    // Sebesseg
    private long speed;

    public Vehicle(long id, String nev, String info, long speed) {
        this.id = id;
        this.name = nev;
        this.info = info;
        this.speed = speed;
    }

    public Vehicle() {
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
