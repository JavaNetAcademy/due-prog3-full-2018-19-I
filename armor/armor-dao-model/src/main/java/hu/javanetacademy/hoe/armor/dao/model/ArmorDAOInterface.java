/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.armor.dao.model;

import java.util.List;

/**
 *
 * @author Mckyni
 */
public interface ArmorDAOInterface {
     public Armor getById(long id);
    public Armor create(Armor armor);
    public Armor modify(long id, Armor armor);
    public Armor get(long id);
    public Armor delete(long id);
    public List<Armor> getList(long userid);
}
