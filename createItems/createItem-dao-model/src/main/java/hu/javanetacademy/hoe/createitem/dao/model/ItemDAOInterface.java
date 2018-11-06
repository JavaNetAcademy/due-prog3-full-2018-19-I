package hu.javanetacademy.hoe.createitem.dao.model;
import java.util.List;
/**
 * 
 * @author Nagy Adam
 */
public interface ItemDAOInterface {
    public List<Item> getAll();
    public Item getById(long id);
    public Item create(Item item);
    public Item getByName(String name);
    public Item modify(long id);
    public Item delete(long id);
    public List<Item> getByEmpire(long id);
}
