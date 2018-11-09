/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.resources.dao.model;
import java.util.List;
/**
 *
 * @author jf6vmn
 */
public interface ResourcesInterface {
    public Resources getById(long id);
    public Resources create(Resources resources);
    public Resources modify(long id, Resources resources);
    public Resources get(long id);
    public Resources delete(long id);
    public List<Resources> getList();
    
}
