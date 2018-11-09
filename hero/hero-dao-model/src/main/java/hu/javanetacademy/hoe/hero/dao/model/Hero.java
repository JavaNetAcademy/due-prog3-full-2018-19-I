package hu.javanetacademy.hoe.hero.dao.model;


/**
 * @author krisztian
 */

public class Hero extends BaseDataModel{
    
    private long userid;
    
    public Hero() {
        super();
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
    }
    
    
    
}
