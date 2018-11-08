/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.mobs.dao.model;

/**
 *
 * @author Major Bence
 */
public class Mobs {
    private long id;
    private String name;
    private int lvl;
    private int attackpoints;
    private int defensepoints;
    private double posx;
    private double posy;
    
    public Mobs(long id, String name, int lvl, int attackpoints, int defensepoints, double posx, double posy)
    {
        this.id=id;
        this.name=name;
        this.lvl=lvl;
        this.attackpoints=attackpoints;
        this.defensepoints=defensepoints;
        this.posx=posx;
        this.posy=posy;
    }
    
    public Mobs()
            
       {
       }
    public long getId()
    {
        return id;
    }
    
    public void setId(long id)
    {
        this.id=id;
    }
    
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public int getLvl()
    {
        return lvl;
    }
    public void setLvl(int lvl)
    {
        this.lvl=lvl;
    }
    public int getAttackpoints()
    {
        return attackpoints;
    }
    public void setAttackpoints(int attackpoints)
    {
        this.attackpoints=attackpoints;
    }
    public int getDefensepoints()
    {
        return defensepoints;
    }
    public void setDefensepoints(int defensepoints)
    {
        this.defensepoints=defensepoints;
    }
    public double getPosx()
    {
        return posx;
    }
    public void setPosx(double posx)
    {
        this.posx=posx;
    }
    public double getPosy()
    {
        return posy;
    }
    public void setPosy(double posy)
    {
        this.posy=posy;
    }
}
