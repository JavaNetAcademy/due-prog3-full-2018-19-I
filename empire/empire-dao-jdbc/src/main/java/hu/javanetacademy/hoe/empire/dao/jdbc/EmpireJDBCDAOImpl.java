/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.empire.dao.jdbc;
import hu.javanetacademy.hoe.empire.dao.model.Empire;
import hu.javanetacademy.hoe.empire.dao.model.EmpireDAOInterface;
import hu.javanetacademy.hoe.location.dao.model.Location;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thejumper203
 */
public class EmpireJDBCDAOImpl implements EmpireDAOInterface{

        private  Connection con;

    public EmpireJDBCDAOImpl() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://192.168.1.100/hoe?useSSL=false", "hoe", "hoe");
        }
        catch(Exception e){
            System.exit(100);
        }
    }
    
    @Override
    public Empire create(Empire pEmpire) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empire modify(long pOldEmpireId, Empire pNewEmpire) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empire delete(long pEmpireId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empire get(long pEmpireId) {
        Empire result=new Empire();
        try {
            PreparedStatement ps=con.prepareStatement("SELECT id,name,description,level,userid FROM empire where id=?");
            ps.setLong(1, pEmpireId);
            ResultSet rs=ps.executeQuery();
            if (rs.next()) {
                Empire res = new Empire();
                res.setId(rs.getLong(1));
                res.setName(rs.getString(2));
                res.setDescription(rs.getString(3));
                res.setLevel(rs.getInt(4));         
                res.setUserid(rs.getLong(5));
                return res;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpireJDBCDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Empire> getByUser(long pUserId) {
        List<Empire> resAll = new ArrayList<>();
        try{
            PreparedStatement ps =con.prepareStatement("SELECT id,name,description,level,userid FROM empire WHERE userid=? ORDER BY name");
            ps.setLong(1, pUserId);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                Empire res = new Empire();
                res.setId(rs.getLong(1));
                res.setName(rs.getString(2));
                res.setDescription(rs.getString(3));
                res.setLevel(rs.getInt(4));         
                res.setUserid(rs.getLong(5));
                resAll.add(res);
            }
        }
        catch (SQLException ex) {
             Logger.getLogger(EmpireJDBCDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resAll;
    }

    @Override
    public List<Location> getLocations(long pEmpireId) {
        List<Location> resAll = new ArrayList<>();
        try{
            PreparedStatement ps =con.prepareStatement("SELECT id,name,description,level,userid FROM hero WHERE userid=? ORDER BY name");
            ps.setLong(1, pEmpireId);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                Location res = new Location();
                res.setId(rs.getLong(1));
                res.setName(rs.getString(2));
                res.setDesc(rs.getString(3));     
                res.setEmpid(rs.getLong(4));
                resAll.add(res);
            }
        }
        catch (SQLException ex) {
             Logger.getLogger(EmpireJDBCDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resAll;
    }
    
}
