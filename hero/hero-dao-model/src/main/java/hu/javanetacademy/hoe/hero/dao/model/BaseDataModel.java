package hu.javanetacademy.hoe.hero.dao.model;

/**
 *
 * @author krisztian
 */
public class BaseDataModel {
    protected long id;
    protected String name,description,classid;

    public BaseDataModel() {
    }

    public BaseDataModel(long id, String classid, String name, String description) {
        this.id = id;
        this.classid = classid;
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
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
