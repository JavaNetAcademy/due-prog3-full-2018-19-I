package hu.javanetacademy.hoe.createitem.dao.model.createitem.dao.model;
import java.util.List;
/**
 * 
 * @author Nagy Adam
 */
public interface itemdao {
    public List<item> getAll();
    public item getById(long id);
    public item getByName(String name);
    public item modify(long id,long mennyiseg);
    public item delete(long id);
}
