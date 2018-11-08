/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.herostatus.dao.jdbc.herostatus.dao.jdbc;


import hu.javanetacademy.hoe.herostatus.dao.model.herostatus.dao.model.heroStatusDao;
import hu.javanetacademy.hoe.herostatus.dao.model.herostatus.dao.model.heroStatus;
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
 * @author Attila
 */
public class heroStatusJDBCDAOImpl implements heroStatusDao {

        private  Connection con;

    public heroStatusJDBCDAOImpl() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/hoe?useSSL=false", "hoe", "hoe");
        }
        catch(Exception e){
            System.exit(100);
        }
    }
    
    @Override
    public heroStatus create(heroStatus pHeroStatus) {
        try {
            PreparedStatement ps=con.prepareStatement("INSERT INTO heroStatus (heroid,health,mana,level,experience,intellect,strength,agility) VALUES (?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, pHeroStatus.getHeroid());
            ps.setLong(2, pHeroStatus.getHealth());
            ps.setLong(3, pHeroStatus.getMana());
            ps.setLong(4, pHeroStatus.getLevel());
            ps.setLong(5, pHeroStatus.getExperience());
            ps.setLong(6, pHeroStatus.getIntellect());
            ps.setLong(7, pHeroStatus.getStrength());
            ps.setLong(8, pHeroStatus.getAgility());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if (rs.next()) {
                pHeroStatus.setHeroid(rs.getLong(1));
                return pHeroStatus;
            }
        } catch (SQLException ex) {
            Logger.getLogger(heroStatusJDBCDAOImpl.class.getName()).log(Level.SEVERE,null,ex);
        }
        return null;
    }
    
    @Override
    public heroStatus modify(long pOldId, heroStatus pNewHeroStatus) {
        try {
            PreparedStatement ps=con.prepareStatement("UPDATE heroStatus SET health=?, mana=?, level=?, experience=?, intellect=?, strength=?, agility=? WHERE heroid=?");
            ps.setLong(1, pNewHeroStatus.getHealth());
            ps.setLong(2, pNewHeroStatus.getMana());
            ps.setLong(3, pNewHeroStatus.getLevel());
            ps.setLong(4, pNewHeroStatus.getExperience());
            ps.setLong(5, pNewHeroStatus.getIntellect());
            ps.setLong(6, pNewHeroStatus.getStrength());
            ps.setLong(7, pNewHeroStatus.getAgility());
            ps.setLong(8, pOldId);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(heroStatusJDBCDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public heroStatus delete(long pheroStatusId) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("DELETE FROM heroStatus where heroid=?");
            ps.setLong(1,pheroStatusId);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(heroStatusJDBCDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;    
    }

    @Override
    public heroStatus get(long pheroStatusId) {
        heroStatus result=new heroStatus();
        try {
            PreparedStatement ps=con.prepareStatement("SELECT heroid,health,mana,level,experience,intellect,strength,agility FROM heroStatus where heroid=?");
            ps.setLong(1, pheroStatusId);
            ResultSet rs=ps.executeQuery();
            if (rs.next()) {
                heroStatus res = new heroStatus();
                res.setHeroid(rs.getLong(1));
                res.setHealth(rs.getLong(2));
                res.setMana(rs.getLong(3));
                res.setLevel(rs.getLong(4));
                res.setExperience(rs.getInt(5));         
                res.setIntellect(rs.getLong(6));
                res.setStrength(rs.getLong(7));
                res.setAgility(rs.getLong(8));
                return res;
            }
        } catch (SQLException ex) {
            Logger.getLogger(heroStatusJDBCDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    @Override
    public List<heroStatus> getAll() {
        List<heroStatus> resAll = new ArrayList<>();
        try{
            PreparedStatement ps =con.prepareStatement("SELECT heroid,health,mana,level,experience,intellect,strength,agility FROM heroStatus ORDER BY heroid");
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                heroStatus res = new heroStatus();
                res.setHeroid(rs.getLong(1));
                res.setHealth(rs.getLong(2));
                res.setMana(rs.getLong(3));
                res.setLevel(rs.getLong(4));
                res.setExperience(rs.getInt(5));         
                res.setIntellect(rs.getLong(6));
                res.setStrength(rs.getLong(7));
                res.setAgility(rs.getLong(8));
                resAll.add(res);
            }
        }
        catch (SQLException ex) {
             Logger.getLogger(heroStatusJDBCDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resAll;
    }
    @Override
    public List<heroStatus> getByLevel(long pLevel) {
        List<heroStatus> resAll = new ArrayList<>();
        try{
            PreparedStatement ps =con.prepareStatement("SELECT heroid,health,mana,level,experience,intellect,strength,agility FROM heroStatus WHERE level=? ORDER BY level");
            ps.setLong(1, pLevel);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                heroStatus res = new heroStatus();
                res.setHeroid(rs.getLong(1));
                res.setHealth(rs.getLong(2));
                res.setMana(rs.getLong(3));
                res.setLevel(rs.getLong(4));
                res.setExperience(rs.getInt(5));         
                res.setIntellect(rs.getLong(6));
                res.setStrength(rs.getLong(7));
                res.setAgility(rs.getLong(8));
                resAll.add(res);
            }
        }
        catch (SQLException ex) {
             Logger.getLogger(heroStatusJDBCDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resAll;
    }
    
}