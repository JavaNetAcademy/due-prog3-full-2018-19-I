package hu.javanetacademy.hoe.magicitem.dao.model;
import java.util.List;
/**
 * 
 * @author Sardi Gergely - FRHZU1
 */
public interface magicItemDAOInterface {
    public magicItem getById(long id);
    public magicItem create(magicItem item);
    public magicItem modify(long id, magicItem item);
    public magicItem delete(long id);
 
}
