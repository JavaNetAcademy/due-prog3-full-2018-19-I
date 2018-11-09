/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.resources.dao.jdbc;

import hu.javanetacademy.hoe.resources.dao.model.Resources;
import hu.javanetacademy.hoe.resources.dao.model.ResourcesInterface;
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
 * @author jf6vmn
 */
public class ResourcesJDBCDAOImpl implements ResourcesInterface {
       private Connection con;
    
    public ResourcesJDBCDAOImpl() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/hoe?useSSL=false", "hoe", "hoe");
        } catch (Exception e) {
            System.exit(100);
        }
    }    
        @Override
    public Resources create (Resources resources){
        try {
            PreparedStatement ps=con.prepareStatement("INSERT INTO nyersanyag (name, info, mennyiseg) VALUES (?,?,?)",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,resources.getNev());
            ps.setString(2,resources.getInfo());
            ps.setLong(3,resources.getMennyiseg());
            ps.executeUpdate();
            con.commit();
            ResultSet rs=ps.getGeneratedKeys();
            if (rs.next()) {
               resources.setId(rs.getLong(1));
                return resources;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResourcesJDBCDAOImpl.class.getName()).log(Level.SEVERE,null,ex);
        }
        return null;
    }
    @Override
    public Resources modify(long id, Resources resources) {
        try {
            PreparedStatement ps=con.prepareStatement("UPDATE item SET name=?, info=?, mennyiseg=? WHERE id=?");
              ps.setString(1, resources.getNev());
            ps.setString(2, resources.getInfo());
            ps.setLong(3, resources.getMennyiseg());
            ps.setLong(4,id);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(ResourcesJDBCDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    @Override
    public Resources delete(long id) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("DELETE FROM item where id=?");
            ps.setLong(1,id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ResourcesJDBCDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;      
    }
    @Override
    public Resources getById(long Id) {
        try {
            PreparedStatement ps=con.prepareStatement("SELECT id,name,info, FROM item where id=?");
            ps.setLong(1, Id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()) {
                Resources res=new Resources();
                res.setId(rs.getLong(1));
                res.setNev(rs.getString(2));
                res.setInfo(rs.getString(3));
                res.setMennyiseg(rs.getLong(4));
                return res;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResourcesJDBCDAOImpl.class.getName()).log(Level.SEVERE,null,ex);
        }
        return null;
    }
     @Override
    public Resources get(long id) {
        try {
            PreparedStatement ps=con.prepareStatement("SELECT id,name,info,mennyiseg FROM item where id=?");
            ps.setLong(1, id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()) {
                Resources res=new Resources();
                res.setId(rs.getLong(1));
                res.setNev(rs.getString(2));
                res.setInfo(rs.getString(3));
                res.setMennyiseg(rs.getLong(4));
                return res;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResourcesJDBCDAOImpl.class.getName()).log(Level.SEVERE,null,ex);
        }
        return null;
    }
    @Override
    public List<Resources> getList() {
                try {
            PreparedStatement ps=con.prepareStatement("SELECT id,name,info,mennyiseg FROM nyersanyagok");
            ResultSet rs=ps.executeQuery();
            List<Resources> locl=new ArrayList<Resources>();
            while(rs.next()) {
                Resources res=new Resources();
                res.setId(rs.getLong(1));
                res.setNev(rs.getString(2));
                res.setInfo(rs.getString(3));
                res.setMennyiseg(rs.getLong(4)); 
                locl.add(res);
            }
            return locl;
        } catch (SQLException ex) {
            Logger.getLogger(ResourcesJDBCDAOImpl.class.getName()).log(Level.SEVERE,null,ex);
        }
        return null;
    }
}
