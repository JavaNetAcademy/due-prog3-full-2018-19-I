/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.vehicle.dao.model.vehicle.dao.model;

import java.util.List;

/**
 *
 * @author ttama
 */
public interface vehicledao {
    public List<item> getAll();
    public item getById(long id);
    public item getByName(String nev);
    public item modify(long id,long speed);
    public item delete(long id);
}
