/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.armor.dao.jdbc;
import hu.javanetacademy.hoe.armor.dao.model.Armor;
import hu.javanetacademy.hoe.armor.dao.model.ArmorDAOInterface;
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
 * @author Nagy Adam
 */
public class ArmorJDBCDAOImpl implements ArmorDAOInterface {
        private Connection con;
    
    public ArmorJDBCDAOImpl() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/hoe?useSSL=false", "hoe", "hoe");
        } catch (Exception e) {
            System.exit(100);
        }
    }    
        @Override
    public Armor create (Armor armor){
        try {
            PreparedStatement ps=con.prepareStatement("INSERT INTO armor (nev, info, tamadoertek, vedoertek, userid, nyersanyagid) VALUES (?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,armor.getNev());
            ps.setString(2,armor.getInfo());
            ps.setLong(3,armor.getTamadoertek());
            ps.setLong(4,armor.getVedoertek());
            ps.setLong(5,armor.getUserid());
            ps.setLong(6,armor.getNyersanyagid());
            ps.executeUpdate();
            con.commit();
            ResultSet rs=ps.getGeneratedKeys();
            if (rs.next()) {
               armor.setId(rs.getLong(1));
                return armor;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArmorJDBCDAOImpl.class.getName()).log(Level.SEVERE,null,ex);
        }
        return null;
    }
    @Override
    public Armor modify(long id, Armor armor) {
        try {
            PreparedStatement ps=con.prepareStatement("UPDATE armor SET nev=?, info=?, tamadoertek=?, vedoertek=?, nyersanyagid=? WHERE id=?");
              ps.setString(1, armor.getNev());
            ps.setString(2, armor.getInfo());
            ps.setLong(3, armor.getTamadoertek());
            ps.setLong(4,armor.getVedoertek());
            ps.setLong(5,armor.getNyersanyagid());
            ps.setLong(6, id);
            ps.executeUpdate();
        } catch (Exception ex) {
           Logger.getLogger(ArmorJDBCDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    @Override
    public Armor delete(long id) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("DELETE FROM armor where id=?");
            ps.setLong(1,id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ArmorJDBCDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;      
    }
    @Override
    public Armor getById(long Id) {
        try {
            PreparedStatement ps=con.prepareStatement("SELECT id,nev,info,tamadoertek,vedoertek,nyersanagyid FROM armor where id=?");
            ps.setLong(1, Id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()) {
                Armor res=new Armor();
                res.setId(rs.getLong(1));
                res.setNev(rs.getString(2));
                res.setInfo(rs.getString(3));
                res.setTamadoertek(rs.getLong(4));
                res.setVedoertek(rs.getLong(5));
                res.setNyersanyagid(rs.getLong(6));
                return res;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArmorJDBCDAOImpl.class.getName()).log(Level.SEVERE,null,ex);
        }
        return null;
    }
     @Override
    public Armor get(long id) {
        try {
            PreparedStatement ps=con.prepareStatement("SELECT id,nev,info,tamadoertek,vedoertek,nyersanyagid FROM armor where id=?");
            ps.setLong(1, id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()) {
                Armor res=new Armor();
                res.setId(rs.getLong(1));
                res.setNev(rs.getString(2));
                res.setInfo(rs.getString(3));
                res.setTamadoertek(rs.getLong(4));
                res.setVedoertek(rs.getLong(5));
                res.setNyersanyagid(rs.getLong(6));
                return res;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArmorJDBCDAOImpl.class.getName()).log(Level.SEVERE,null,ex);
        }
        return null;
    }
    @Override
    public List<Armor> getList(long puserid) {
                try {
            PreparedStatement ps=con.prepareStatement("SELECT id,nev,info,tamadoertek,vedoertek,userid,nyersanyagid FROM armor WHERE userid=?");
            ps.setLong(1,puserid);
            ResultSet rs=ps.executeQuery();
            List<Armor> locl=new ArrayList<Armor>();
            while(rs.next()) {
                Armor res=new Armor();
                res.setId(rs.getLong(1));
                res.setNev(rs.getString(2));
                res.setInfo(rs.getString(3));
                res.setTamadoertek(rs.getLong(4));
                res.setVedoertek(rs.getLong(5));
                res.setUserid(rs.getLong(6));
                res.setNyersanyagid(rs.getLong(7));
                locl.add(res);
            }
            return locl;
        } catch (SQLException ex) {
            Logger.getLogger(ArmorJDBCDAOImpl.class.getName()).log(Level.SEVERE,null,ex);
        }
        return null;
    }
}
