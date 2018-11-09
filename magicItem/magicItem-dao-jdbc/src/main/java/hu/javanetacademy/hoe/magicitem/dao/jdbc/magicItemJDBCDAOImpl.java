/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 
package hu.javanetacademy.hoe.magicitem.dao.jdbc;
import hu.javanetacademy.hoe.magicitem.dao.model.magicItem;
import hu.javanetacademy.hoe.magicitem.dao.model.magicItemDAOInterface;
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
 * @author Sardi Gergely - FRHZU1
 */
public class magicItemJDBCDAOImpl implements magicItemDAOInterface {
        private Connection con;
    
    public magicItemJDBCDAOImpl() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://db.inf.duf.hu/p_frhzu1?useSSL=false", "p_frhzu1", "frhzu1");
        } catch (Exception e) {
            System.exit(100);
        }
    }    
        @Override
    public magicItem create (magicItem mitem){
        try {
            PreparedStatement ps=con.prepareStatement("INSERT INTO magicitem (name, info, mennyiseg) VALUES (?,?,?)",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,mitem.getNev());
            ps.setString(2,mitem.getInfo());
            ps.setLong(3,mitem.getMennyiseg());
            ps.executeUpdate();
            con.commit();
            ResultSet rs=ps.getGeneratedKeys();
            if (rs.next()) {
               mitem.setId(rs.getLong(1));
                return mitem;
            }
        } catch (SQLException ex) {
            Logger.getLogger(magicItemJDBCDAOImpl.class.getName()).log(Level.SEVERE,null,ex);
        }
        return null;
    }
    @Override
    public magicItem modify(long id, magicItem mitem) {
        try {
            PreparedStatement ps=con.prepareStatement("UPDATE magicitem SET name=?, description=? WHERE id=?");
              ps.setString(1, mitem.getNev());
            ps.setString(2, mitem.getInfo());
            ps.setLong(3, mitem.getMennyiseg());
            ps.setLong(3, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(magicItemJDBCDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    @Override
    public magicItem delete(long id) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("DELETE FROM magicitem where id=?");
            ps.setLong(1,id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(magicItemJDBCDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;      
    }
    @Override
    public magicItem getById(long Id) {
        try {
            PreparedStatement ps=con.prepareStatement("SELECT id,name,info, FROM magicitem where id=?");
            ps.setLong(1, Id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()) {
                magicItem res=new magicItem();
                res.setId(rs.getLong(1));
                res.setNev(rs.getString(2));
                res.setInfo(rs.getString(3));
                res.setMennyiseg(rs.getLong(4));
                return res;
            }
        } catch (SQLException ex) {
            Logger.getLogger(magicItemJDBCDAOImpl.class.getName()).log(Level.SEVERE,null,ex);
        }
        return null;
    }
    }

