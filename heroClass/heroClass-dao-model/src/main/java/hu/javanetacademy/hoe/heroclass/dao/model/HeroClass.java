/*s
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.heroclass.dao.model;

/**
 *
 * @author Norbi
 */
public class HeroClass {
    private long id,userid;
    private String name,description;
    
    public HeroClass() {
    }
    
    public HeroClass(String name, String description, long id,long userid) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.userid = userid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
