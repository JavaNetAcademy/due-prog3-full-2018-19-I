package hu.javanetacademy.hoe.createitem.dao.model;
import java.util.List;
/**
 * 
 * @author Nagy Adam
 */
public interface ItemDAOInterface {
    public Item getById(long id);
    public Item create(Item item);
    public Item modify(long id, Item item);
    public Item delete(long id);
 
}
