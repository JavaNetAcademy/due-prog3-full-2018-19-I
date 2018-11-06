/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.Item.dao.jdbc;
import hu.javanetacademy.hoe.createitem.dao.model.Item;
import hu.javanetacademy.hoe.item.dao.model.ItemDAOInterface;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nagy Adam
 */
public class ItemJDBCDAOImpl implements ItemDAOInterface {
        private Connection con;
    
    public ItemJDBCDAOImpl() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://192.168.1.100/hoe?useSSL=false", "hoe", "hoe");
        } catch (Exception e) {
            System.exit(100);
        }
    }
    
        @Override
    public Item create (Item item){
        try {
            PreparedStatement ps=con.prepareStatement("INSERT INTO location (name, description, empid) VALUES (?,?,?)",Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1,item.getId());
            ps.setString(2,item.getNev());
            ps.setString(3,item.getInfo());
            ps.setLong(4,item.getMennyiseg());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if (rs.next()) {
               item.setId(rs.getLong(1));
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemJDBCDAOImpl.class.getName()).log(Level.SEVERE,null,ex);
        }
        return null;
    }

    @Override
    public Item modify(long id, Item item) {
        try {
            PreparedStatement ps=con.prepareStatement("UPDATE location SET name=?, description=? WHERE id=?");
            ps.setLong(1,item.getId());
            ps.setString(2,item.getNev());
            ps.setString(3,item.getInfo());
            ps.setLong(4,item.getMennyiseg());
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(ItemJDBCDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Item delete(long id) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("DELETE FROM location where id=?");
            ps.setLong(1,id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ItemJDBCDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;      
    }

    @Override
    public Item get(long Id) {
        try {
            PreparedStatement ps=con.prepareStatement("SELECT id,name,description,empid FROM location where id=?");
            ps.setLong(1, Id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()) {
                Item res=new Item();
                res.setId(rs.getLong(1));
                res.setNev(rs.getString(2));
                res.setInfo(rs.getString(3));
                res.setMennyiseg(rs.getLong(4));
                return res;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemJDBCDAOImpl.class.getName()).log(Level.SEVERE,null,ex);
        }
        return null;
    }

    @Override
    public List<Item> getByEmpire(long id) {
                try {
            PreparedStatement ps=con.prepareStatement("SELECT id,name,description,empid FROM location where empid=?");
            ps.setLong(1, id);
            ResultSet rs=ps.executeQuery();
            List<Item> locl=new ArrayList<Item>();
            while(rs.next()) {
                Item res=new Item();
                res.setId(rs.getLong(1));
                res.setNev(rs.getString(2));
                res.setInfo(rs.getString(3));
                res.setMennyiseg(rs.getLong(4)); 
                locl.add(res);
            }
            return locl;
        } catch (SQLException ex) {
            Logger.getLogger(ItemJDBCDAOImpl.class.getName()).log(Level.SEVERE,null,ex);
        }
        return null;
    }

}

