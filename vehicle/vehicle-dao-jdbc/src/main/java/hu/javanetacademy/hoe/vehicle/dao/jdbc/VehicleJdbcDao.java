/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.vehicle.dao.jdbc;
import hu.javanetacademy.hoe.vehicle.dao.model.Vehicle;
import hu.javanetacademy.hoe.vehicle.dao.model.VehicleDaoInterface;
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
 * @author Nagy Adam
 */
public class VehicleJdbcDao implements VehicleDaoInterface {
        private Connection con;
    
    public VehicleJdbcDao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/hoe?useSSL=false", "hoe", "hoe");
        } catch (Exception e) {
            System.exit(100);
        }
    }    
        @Override
    public Vehicle create (Vehicle vehicle){
        try {
            PreparedStatement ps=con.prepareStatement("INSERT INTO vehicle (name, info, speed) VALUES (?,?,?)",Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1,vehicle.getId());
            ps.setString(1,vehicle.getName());
            ps.setString(2,vehicle.getInfo());
            ps.setLong(3,vehicle.getSpeed());
            ps.executeUpdate();
            con.commit();
            ResultSet rs=ps.getGeneratedKeys();
            if (rs.next()) {
               vehicle.setId(rs.getLong(1));
                return vehicle;
            }
        } catch (SQLException ex) {
            Logger.getLogger(VehicleJdbcDao.class.getName()).log(Level.SEVERE,null,ex);
        }
        return null;
    }
    @Override
    public Vehicle modify(long id, Vehicle vehicle) {
        try {
            PreparedStatement ps=con.prepareStatement("UPDATE vehicle SET name =?, info=?, speed=?, id=?, WHERE id=?");
            ps.setString(1, vehicle.getName());
            ps.setString(2, vehicle.getInfo());
            ps.setLong(3, vehicle.getSpeed());
            ps.setLong(4, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(VehicleJdbcDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    @Override
    public Vehicle delete(long id) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("DELETE FROM vehicle where id=?");
            ps.setLong(1,id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VehicleJdbcDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;      
    }
    @Override
    public Vehicle getById(long Id) {
        try {
            PreparedStatement ps=con.prepareStatement("SELECT id, name, info, speed FROM vehicle where id=?");
            ps.setLong(1, Id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()) {
                Vehicle res=new Vehicle();
                res.setId(rs.getLong(1));
                res.setName(rs.getString(2));
                res.setInfo(rs.getString(3));
                res.setSpeed(rs.getLong(4));
                return res;
            }
        } catch (SQLException ex) {
            Logger.getLogger(VehicleJdbcDao.class.getName()).log(Level.SEVERE,null,ex);
        }
        return null;
    }
    /*/@Override
    public dao getAll() {
        return Vehicle.getAll();
    }/*/
    }

