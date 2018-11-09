/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.defenderbuilding.dao.jbc;
import hu.javanetacademy.hoe.defenderbuilding.dao.model.DefenderBuilding;
import hu.javanetacademy.hoe.defenderbuilding.dao.model.Defenderbuildingdaointerface;
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
 * @author csaba
 */
public class DefenderbuildingJbcDao implements Defenderbuildingdaointerface{
    private Connection con;
    
    public DefenderbuildingJbcDao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/hoe?useSSL=false", "hoe", "hoe");
        } catch (Exception e) {
            System.exit(100);
        }
    }    
        @Override
    public DefenderBuilding create (DefenderBuilding defenderbuilding){
        try {
            PreparedStatement ps=con.prepareStatement("INSERT INTO defenderbuilding (id, name, description, attack, armor) VALUES (?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1,defenderbuilding.getId());
            ps.setString(2,defenderbuilding.getName());
            ps.setString(3,defenderbuilding.getDescription());
            ps.setLong(4,defenderbuilding.getAttack());
            ps.setLong(5,defenderbuilding.getArmor());
            ps.executeUpdate();
            con.commit();
            ResultSet rs=ps.getGeneratedKeys();
            if (rs.next()) {
               defenderbuilding.setId(rs.getLong(1));
                return defenderbuilding;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DefenderbuildingJbcDao.class.getName()).log(Level.SEVERE,null,ex);
        }
        return null;
    }
    @Override
    public DefenderBuilding modify(long id, DefenderBuilding vehicle) {
        try {
            PreparedStatement ps=con.prepareStatement("UPDATE defenderbuilding SET name =?, description=?, attack=?,armor=?, id=?, WHERE id=?");
            ps.setString(1, vehicle.getName());
            ps.setString(2, vehicle.getDescription());
            ps.setLong(3, vehicle.getAttack());
            ps.setLong(4, vehicle.getArmor());
            ps.setLong(5, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(DefenderbuildingJbcDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    @Override
    public DefenderBuilding delete(long id) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("DELETE FROM defenderbuilding where id=?");
            ps.setLong(1,id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DefenderbuildingJbcDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;      
    }
    @Override
    public DefenderBuilding getById(long Id) {
        try {
            PreparedStatement ps=con.prepareStatement("SELECT id, name, description, attack,armor FROM defenderbuilding where id=?");
            ps.setLong(1, Id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()) {
                DefenderBuilding res=new DefenderBuilding();
                res.setId(rs.getLong(1));
                res.setName(rs.getString(2));
                res.setDescription(rs.getString(3));
                res.setAttack(rs.getLong(4));
                res.setArmor(rs.getLong(5));
                return res;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DefenderbuildingJbcDao.class.getName()).log(Level.SEVERE,null,ex);
        }
        return null;
    }
    
    
}
