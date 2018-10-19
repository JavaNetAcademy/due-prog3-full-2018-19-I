/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.building.dao.file;

import hu.javanetacademy.hoe.building.dao.model.Building;
import hu.javanetacademy.hoe.building.dao.model.BuildingDaoInterface;
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
 * @author JUHASZ
 */
public class BuildingJDBCDAOImpl implements BuildingDaoInterface {

    private Connection con;

    public BuildingJDBCDAOImpl() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc://localhost/hoe?useSSL=false", "hoe", "hoe");
        } catch (Exception e) {
            System.exit(100);
        }
    }

    @Override
    public Building create(Building pBuilding) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO building(name, description, level, userid) VALUES(?,?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pBuilding.getName());
            ps.setString(2, pBuilding.getDescription());
            ps.setInt(3, pBuilding.getLevel());
            ps.setLong(4, pBuilding.getUserid());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                pBuilding.setId(rs.getLong(1));
                return pBuilding;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BuildingJDBCDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Building modify(long pOldBuildingId, Building pNewBuilding) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Building delete(long pBuildingID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Building get(long pBuildingId) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT id, name, description, level,userid FROM building WHERE id=?");
            ps.setLong(1, pBuildingId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Building res = new Building();
                res.setId(rs.getLong(1));
                res.setName(rs.getString(2));
                res.setDescription(rs.getString(3));
                res.setLevel(rs.getInt(4));
                res.setUserid(rs.getLong(5));
                return res;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BuildingJDBCDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Building> getByUser(long pUserId) {
        List<Building> resAll = new ArrayList();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT id, name, description, level,userid FROM building WHERE userid=? ORDER BY naem");
            ps.setLong(1, pUserId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Building res = new Building();
                res.setId(rs.getLong(1));
                res.setName(rs.getString(2));
                res.setDescription(rs.getString(3));
                res.setLevel(rs.getInt(4));
                res.setUserid(rs.getLong(5));
                resAll.add(res);
            }
        } catch (SQLException ex) {
        }
        return resAll;
    }

    @Override
    public Building getByNameFromUser(String pBuildingName, long pUserId) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT id, name, description, level,userid FROM building WHERE name=? AND userid=?");
            ps.setString(1, pBuildingName);
            ps.setLong(2, pUserId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Building res = new Building();
                res.setId(rs.getLong(1));
                res.setName(rs.getString(2));
                res.setDescription(rs.getString(3));
                res.setLevel(rs.getInt(4));
                res.setUserid(rs.getLong(5));
                return res;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BuildingJDBCDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
