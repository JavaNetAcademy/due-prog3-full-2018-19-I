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
public interface MobsDAOInterface {
    public Mobs getById(long id);
    public Mobs Create(Mobs mobs);
    public Mobs Modify(long id, Mobs mobs);
    public Mobs Delete(long id);
}
