/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.location.dao.jdbc;
import hu.javanetacademy.hoe.location.dao.model.Location;
import hu.javanetacademy.hoe.location.dao.model.LocationDAOInterface;
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
 * @author thejumper203
 */
public class LocationJDBCDAOImpl implements LocationDAOInterface{
    private Connection con;
    
    public LocationJDBCDAOImpl() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/hoe?useSSL=false", "hoe", "hoe");
            } catch (Exception e) {
            System.exit(100);
        }
    }
    
    @Override
    public Location create (Location pLocation){
        try {
            PreparedStatement ps=con.prepareStatement("INSERT INTO location (name, description, empid) VALUES (?,?,?)",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,pLocation.getName());
            ps.setString(2,pLocation.getDesc());
            ps.setLong(3,pLocation.getEmpid());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if (rs.next()) {
                pLocation.setId(rs.getLong(1));
                return pLocation;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LocationJDBCDAOImpl.class.getName()).log(Level.SEVERE,null,ex);
        }
        return null;
    }

    @Override
    public Location modify(long pOldLocationId, Location pNewLocation) {
        try {
            PreparedStatement ps=con.prepareStatement("UPDATE location SET name=?, description=? WHERE id=?");
            ps.setString(1, pNewLocation.getName());
            ps.setString(2, pNewLocation.getDesc());
            ps.setLong(3, pOldLocationId);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(LocationJDBCDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Location delete(long LocationId) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("DELETE FROM location where id=?");
            ps.setLong(1,LocationId);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LocationJDBCDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;      
    }

    @Override
    public Location get(long pLocationId) {
        try {
            PreparedStatement ps=con.prepareStatement("SELECT id,name,description,empid FROM location where id=?");
            ps.setLong(1, pLocationId);
            ResultSet rs=ps.executeQuery();
            if(rs.next()) {
                Location res=new Location();
                res.setId(rs.getLong(1));
                res.setName(rs.getString(2));
                res.setDesc(rs.getString(3));
                res.setEmpid(rs.getLong(4));
                return res;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LocationJDBCDAOImpl.class.getName()).log(Level.SEVERE,null,ex);
        }
        return null;
    }

    @Override
    public List<Location> getByEmpire(long pEmpireId) {
                try {
            PreparedStatement ps=con.prepareStatement("SELECT id,name,description,empid FROM location where empid=?");
            ps.setLong(1, pEmpireId);
            ResultSet rs=ps.executeQuery();
            List<Location> locl=new ArrayList<Location>();
            while(rs.next()) {
                Location res=new Location();
                res.setId(rs.getLong(1));
                res.setName(rs.getString(2));
                res.setDesc(rs.getString(3));
                res.setEmpid(rs.getLong(4)); 
                locl.add(res);
            }
            return locl;
        } catch (SQLException ex) {
            Logger.getLogger(LocationJDBCDAOImpl.class.getName()).log(Level.SEVERE,null,ex);
        }
        return null;
    }

    @Override
    public boolean checkName(String name,long empid) {
        try {
            PreparedStatement ps=con.prepareStatement("SELECT name from location where name=? and empid=?");
            ps.setString(1,name);
            ps.setLong(2,empid);
            ResultSet rs=ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LocationJDBCDAOImpl.class.getName()).log(Level.SEVERE,null,ex);
        }
        return false;
    }

}
