/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.mobs.dao.jdbc;
import hu.javanetacademy.hoe.mobs.dao.model.Mobs;
import hu.javanetacademy.hoe.mobs.dao.model.MobsDAOInterface;
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
 * @author Major Bence
 */
public class MobsJDBCDAOImpl implements MobsDAOInterface{
    private Connection conn;

    public MobsJDBCDAOImpl()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/hoe?useSSL=false", "hoe", "hoe");
        } catch (Exception e) {
            System.exit(100);
        }
    }
    @Override
    public Mobs Create(Mobs mobs)
    {
        try {
            PreparedStatement ps=conn.prepareStatement("INSERT INTO mobs (name, lvl, attackpoints, defensepoints, posx, posy) VALUES (?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,mobs.getName());
            ps.setInt(2,mobs.getLvl());
            ps.setInt(3,mobs.getAttackpoints());
            ps.setInt(4,mobs.getDefensepoints());
            ps.setDouble(5,mobs.getPosx());
            ps.setDouble(6,mobs.getPosy());
            ps.executeUpdate();
            conn.commit();
            ResultSet rs=ps.getGeneratedKeys();
            if (rs.next()) {
               mobs.setId(rs.getLong(1));
                return mobs;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MobsJDBCDAOImpl.class.getName()).log(Level.SEVERE,null,ex);
        }
        return null;
    }
    @Override
    public Mobs Modify(long id,Mobs mobs)
    {
        try {
            PreparedStatement ps=conn.prepareStatement("UPDATE mobs SET name=?, lvl=?, attackpoints=?, defensepoints=?, posx=?, posy=? WHERE id=?");
              ps.setString(1, mobs.getName());
            ps.setInt(2,mobs.getLvl());
            ps.setInt(3,mobs.getAttackpoints());
            ps.setInt(4,mobs.getDefensepoints());
            ps.setDouble(5,mobs.getPosx());
            ps.setDouble(6,mobs.getPosy());
            ps.setLong(7, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(MobsJDBCDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    @Override
    public Mobs Delete(long id)
    {
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("DELETE FROM mobs where id=?");
            ps.setLong(1,id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MobsJDBCDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null; 
    }
    @Override
    public Mobs getById(long id)
    {
        try {
            PreparedStatement ps=conn.prepareStatement("SELECT id,name,lvl, attackpoints, defensepoints, posx, posy FROM mobs where id=?");
            ps.setLong(1, id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()) {
                Mobs res=new Mobs();
                res.setId(rs.getLong(1));
                res.setName(rs.getString(2));
                res.setLvl(rs.getInt(3));
                res.setAttackpoints(rs.getInt(4));
                res.setDefensepoints(rs.getInt(5));
                res.setPosx(rs.getInt(6));
                res.setPosy(rs.getInt(7));
                return res;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MobsJDBCDAOImpl.class.getName()).log(Level.SEVERE,null,ex);
        }
        return null;
    }
    
}
