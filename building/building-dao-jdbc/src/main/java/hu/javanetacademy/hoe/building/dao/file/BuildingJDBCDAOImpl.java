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
            //System.err.println("---------------- constructor IN //////////////////////");
            con = DriverManager.getConnection("jdbc:mysql://localhost/hoe?useSSL=false", "root", "root");
        } catch (Exception e) {
            //System.err.println("------------BuildingJDBCDAOImpl error ----------------------------"+e);
            System.exit(100);
        }
    }

    @Override
    public Building create(Building pBuilding) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO building(name, description, level) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pBuilding.getName());
            ps.setString(2, pBuilding.getDescription());
            ps.setLong(3, pBuilding.getLevel());
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
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE building SET name=?, description=?, level=? WHERE id = ?");
            ps.setString(1, pNewBuilding.getName());
            ps.setString(2, pNewBuilding.getDescription());
            ps.setLong(3, pNewBuilding.getLevel());
            ps.executeUpdate();
            pNewBuilding.setId(pOldBuildingId);
            return pNewBuilding;

        } catch (SQLException ex) {
            Logger.getLogger(BuildingJDBCDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public Building delete(long pBuildingID) {
        Building returnBuilding = get(pBuildingID);
        try {
            PreparedStatement ps = con.prepareStatement("DELETE building WHERE id=?");
            ps.setLong(1, pBuildingID);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BuildingJDBCDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnBuilding;
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
            PreparedStatement ps = con.prepareStatement("SELECT id, name, description, level,userid FROM building WHERE userid=? ORDER BY name");
            ps.setLong(1, pUserId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Building res = new Building();
                res.setId(rs.getLong(1));
                res.setName(rs.getString(2));
                res.setDescription(rs.getString(3));
                res.setLevel(rs.getInt(4));
                res.setUserid(rs.getLong(5));
                resAll.add(res);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BuildingJDBCDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resAll;
    }

    @Override
    public Building getByName(String pBuildingName) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT id, name, description, level,userid FROM building WHERE name=?");
            ps.setString(1, pBuildingName);
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
    public Building changeOwnerUser(long pBuildingID, long pUserId) {
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE building SET userid=? WHERE id = ?");
            ps.setLong(1, pUserId);
            ps.setLong(2, pBuildingID);
            ps.executeUpdate();
            Building returnBuilding = get(pBuildingID);
            return returnBuilding;

        } catch (SQLException ex) {
            Logger.getLogger(BuildingJDBCDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Building> getAll() {
        List<Building> resAll = new ArrayList();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT id, name, description, level,userid FROM building");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Building res = new Building();
                res.setId(rs.getLong(1));
                res.setName(rs.getString(2));
                res.setDescription(rs.getString(3));
                res.setLevel(rs.getInt(4));
                res.setUserid(rs.getLong(5));
                resAll.add(res);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BuildingJDBCDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resAll;
    }
}
