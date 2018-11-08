/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.spell.jdc.spell.dao.jdbc;
import hu.javanetacademy.hoe.spell.spell.dao.model.Spell;
import hu.javanetacademy.hoe.spell.spell.dao.model.SpellDao;
import hu.javanetacademy.hoe.hero.dao.model.Hero;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Attila
 */
public class SpellJDBCDAOImpl implements SpellDao {

        private  Connection con;

    public SpellJDBCDAOImpl() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/hoe?useSSL=false", "hoe", "hoe");
        }
        catch(Exception e){
            System.exit(100);
        }
    }
    
    @Override
    public Spell create(Spell pSpell) {
        try {
            PreparedStatement ps=con.prepareStatement("INSERT INTO spell (heroid,name,description,attpower,deffpower) VALUES (?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, pSpell.getHeroid());
            ps.setString(2, pSpell.getName());
            ps.setString(3, pSpell.getDescription());
            ps.setLong(4, pSpell.getAttpower());
            ps.setLong(5, pSpell.getDeffpower());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if (rs.next()) {
                pSpell.setId(rs.getLong(1));
                return pSpell;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SpellJDBCDAOImpl.class.getName()).log(Level.SEVERE,null,ex);
        }
        return null;
    }

    @Override
    public Spell modify(long pOldSpellId, Spell pNewSpell) {
        try {
            PreparedStatement ps=con.prepareStatement("UPDATE spell SET heroid=?, name=?, description=?, attpower=?, deffpower=? WHERE id=?");
            ps.setLong(1, pNewSpell.getHeroid());
            ps.setString(2, pNewSpell.getName());
            ps.setString(3, pNewSpell.getDescription());
            ps.setLong(4, pNewSpell.getAttpower());
            ps.setLong(5, pNewSpell.getDeffpower());
            ps.setLong(6, pOldSpellId);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SpellJDBCDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Spell delete(long pSpellId) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("DELETE FROM spell where id=?");
            ps.setLong(1,pSpellId);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SpellJDBCDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;    
    }

    @Override
    public Spell get(long pSpellId) {
        Spell result=new Spell();
        try {
            PreparedStatement ps=con.prepareStatement("SELECT id,heroid,name,description,attpower,deffpower FROM spell where id=?");
            ps.setLong(1, pSpellId);
            ResultSet rs=ps.executeQuery();
            if (rs.next()) {
                Spell res = new Spell();
                res.setId(rs.getLong(1));
                res.setHeroid(rs.getLong(2));
                res.setName(rs.getString(3));
                res.setDescription(rs.getString(4));
                res.setAttpower(rs.getInt(5));         
                res.setDeffpower(rs.getLong(6));
                return res;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SpellJDBCDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public List<Spell> getAll() {
        List<Spell> resAll = new ArrayList<>();
        try{
            PreparedStatement ps =con.prepareStatement("SELECT id,heroid,name,description,attpower,deffpower FROM spell ORDER BY name");
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                Spell res = new Spell();
                res.setId(rs.getLong(1));
                res.setHeroid(rs.getLong(2));
                res.setName(rs.getString(3));
                res.setDescription(rs.getString(4));
                res.setAttpower(rs.getInt(5));         
                res.setDeffpower(rs.getLong(6));
                resAll.add(res);
            }
        }
        catch (SQLException ex) {
             Logger.getLogger(SpellJDBCDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resAll;
    }
    @Override
    public List<Spell> getByHero(long pHeroId) {
        List<Spell> resAll = new ArrayList<>();
        try{
            PreparedStatement ps =con.prepareStatement("SELECT id,heroid,name,description,attpower,deffpower FROM spell WHERE heroid=? ORDER BY name");
            ps.setLong(1, pHeroId);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                Spell res = new Spell();
                res.setId(rs.getLong(1));
                res.setHeroid(rs.getLong(2));
                res.setName(rs.getString(3));
                res.setDescription(rs.getString(4));
                res.setAttpower(rs.getInt(5));         
                res.setDeffpower(rs.getLong(6));
                resAll.add(res);
            }
        }
        catch (SQLException ex) {
             Logger.getLogger(SpellJDBCDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resAll;
    }
    
}
