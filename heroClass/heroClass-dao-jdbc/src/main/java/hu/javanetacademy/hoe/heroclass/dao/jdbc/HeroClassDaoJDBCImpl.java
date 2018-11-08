/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.heroclass.dao.jdbc;

import hu.javanetacademy.hoe.heroclass.dao.model.HeroClass;
import hu.javanetacademy.hoe.heroclass.dao.model.HeroClassDAOInterface;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Norbi
 */
public class HeroClassDaoJDBCImpl implements HeroClassDAOInterface{
    
    private  Connection con;
    
    public HeroClassDaoJDBCImpl(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/hoe?useSSL=false", "hoe", "hoe");
        }
        catch(Exception e){
            System.exit(100);
        }
    }

    @Override
    public HeroClass create(HeroClass pHeroClass) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO heroclass(name, description,userid) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pHeroClass.getName());
            ps.setString(2, pHeroClass.getDescription());
            ps.setLong(3, pHeroClass.getUserid());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                pHeroClass.setId(rs.getLong(1));
                return pHeroClass;
            }
        } catch (SQLException ex) {
            Logger.getLogger(HeroClassDaoJDBCImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public HeroClass modify(long pOldHeroClassId, HeroClass pNewHeroClass) {
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE heroclass SET name=?, description=?WHERE id = ?");
            ps.setString(1, pNewHeroClass.getName());
            ps.setString(2, pNewHeroClass.getDescription());
            ps.executeUpdate();
            pNewHeroClass.setId(pOldHeroClassId);
            return pNewHeroClass;

        } catch (SQLException ex) {
            Logger.getLogger(HeroClassDaoJDBCImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public HeroClass delete(long pHeroClassId) {
        HeroClass returnHeroClass = get(pHeroClassId);
        try {
            PreparedStatement ps = con.prepareStatement("DELETE heroclass WHERE id=?");
            ps.setLong(1, pHeroClassId);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HeroClassDaoJDBCImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnHeroClass;
    }

    @Override
    public HeroClass get(long pHeroClassId) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT id, name, description,userid FROM heroclass WHERE id=?");
            ps.setLong(1, pHeroClassId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                HeroClass res = new HeroClass();
                res.setId(rs.getLong(1));
                res.setName(rs.getString(2));
                res.setDescription(rs.getString(3));
                res.setUserid(rs.getLong(4));
                return res;
            }
        } catch (SQLException ex) {
            Logger.getLogger(HeroClassDaoJDBCImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<HeroClass> getByUser(long pUserId) {
        List<HeroClass> resAll = new ArrayList<>();
        try{
            PreparedStatement ps =con.prepareStatement("SELECT id,name,description,userid FROM heroclass WHERE userid=? ORDER BY name");
            ps.setLong(1, pUserId);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                HeroClass res = new HeroClass();
                res.setId(rs.getLong(1));
                res.setName(rs.getString(2));
                res.setDescription(rs.getString(3));         
                res.setUserid(rs.getLong(4));
                resAll.add(res);
            }
        }
        catch (SQLException ex) {
             Logger.getLogger(HeroClassDaoJDBCImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resAll;
    }

    @Override
    public HeroClass getByName(String pHeroClassName) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT id, name, description,userid FROM heroclass WHERE name=?");
            ps.setString(1, pHeroClassName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HeroClass res = new HeroClass();
                res.setId(rs.getLong(1));
                res.setName(rs.getString(2));
                res.setDescription(rs.getString(3));
                res.setUserid(rs.getLong(4));
                return res;
            }
        } catch (SQLException ex) {
            Logger.getLogger(HeroClassDaoJDBCImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<HeroClass> getAll() {
        List<HeroClass> resAll = new ArrayList();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT id, name, description,userid FROM heroclass");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HeroClass res = new HeroClass();
                res.setId(rs.getLong(1));
                res.setName(rs.getString(2));
                res.setDescription(rs.getString(3));
                res.setUserid(rs.getLong(4));
                resAll.add(res);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HeroClassDaoJDBCImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resAll;
    }
    
}
