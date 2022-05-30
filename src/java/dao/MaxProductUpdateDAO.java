/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.DBConnection;
import enity.MaxProductsUpdate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author docon
 */
public class MaxProductUpdateDAO {
    Connection conn=null;
    PreparedStatement ps = null;
    ResultSet rs=null;
    
    public void insertMaxProductsUpdate(MaxProductsUpdate maxProductsUpdate){
        String query = "insert into maxproductsupdate (maxproducts) values (?)";
        
        try {
            conn = new DBConnection().getDBConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, maxProductsUpdate.getMaxproducts());
            
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public int getNewMaxProductsUpdate(){
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
}
