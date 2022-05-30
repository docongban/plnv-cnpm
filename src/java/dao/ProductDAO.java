/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.DBConnection;
import enity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author docon
 */
public class ProductDAO {
    Connection conn=null;
    PreparedStatement ps = null;
    ResultSet rs=null;
    
    public List<Product> getProduct(){
        List<Product> list=new ArrayList<>();
        String query = "select * from products";
        
        try {
            conn = new DBConnection().getDBConnection();
            ps = conn.prepareStatement(query);
            
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
    
    public List<Product> searchProductByName(Product product){
        List<Product> list=new ArrayList<>();
        String query = "select * from products where title like ? ";
        
        try {
            conn = new DBConnection().getDBConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%"+product.getTitle()+"%");
            
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
}
