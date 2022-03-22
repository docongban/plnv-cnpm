/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.DBConnection;
import enity.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

/**
 *
 * @author docon
 */
public class DAO {
    Connection conn=null;
    PreparedStatement ps = null;
    ResultSet rs=null;
    
    public Account login(String phone, String pass){
        String query = "select * from accounts where phone=? and pass = ?";
        
        try {
            conn = new DBConnection().getDBConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, phone);
            ps.setString(2, pass);
            
            rs = ps.executeQuery();
            while(rs.next()){
                return(new Account(rs.getInt(1), 
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public void insertSalaryUpdate(String salary){
        String query = "insert into salaryupdate (salary) values (?)";
        
        try {
            conn = new DBConnection().getDBConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, salary);
            
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public double getNewUpdateSalary(){
        double salary=0;
        
        String query = "SELECT salary FROM salaryupdate where id = (select max(id) from salaryupdate)";
        
        try {
            conn = new DBConnection().getDBConnection();
            ps = conn.prepareStatement(query);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                salary = rs.getDouble("salary");
            }
            
        } catch (Exception e) {
        }
        
        return salary;
    }
    
    public void insertMaxProductsUpdate(String maxproducts){
        String query = "insert into maxproductsupdate (maxproducts) values (?)";
        
        try {
            conn = new DBConnection().getDBConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, maxproducts);
            
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public double getNewMaxProductsUpdate(){
        int maxproducts=0;
        
        String query = "SELECT maxproducts FROM maxproductsupdate where id = (select max(id) from maxproductsupdate)";
        
        try {
            conn = new DBConnection().getDBConnection();
            ps = conn.prepareStatement(query);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                maxproducts = rs.getInt("maxproducts");
            }
            
        } catch (Exception e) {
        }
        
        return maxproducts;
    }
    
    public List<Product> searchProductByName(String title){
        List<Product> list=new ArrayList<>();
        String query = "select * from products where title like ? ";
        
        try {
            conn = new DBConnection().getDBConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%"+title+"%");
            
            rs = ps.executeQuery();
            while(rs.next()){
                list.add( new Product(rs.getInt(1),
                rs.getString(2),
                rs.getDouble(3),
                rs.getString(4),
                rs.getString(5),
                rs.getInt(6)));
            }
        } catch (Exception e) {
        }
        
        return list;
    }
    
    //test
    public static void main(String[] args) {
        DAO dao=new DAO();
//        System.out.println(dao.login("0123456789", "123456").getFullname());
//        dao.insertSalaryUpdate(200);
//        System.out.println(dao.getNewUpdateSalary());

//        dao.insertMaxProductsUpdate("111");
//        System.out.println(dao.getNewMaxProductsUpdate());
        List<Product> list = dao.searchProductByName("nike");
        for(Product p: list){
            System.out.println(p.getTitle());
        }
    }
}
