/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.DBConnection;
import enity.ProductsUpdate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author docon
 */
public class ProductsUpdateDAO {
    Connection conn=null;
    PreparedStatement ps = null;
    ResultSet rs=null;
    
    public void insertProductsUpdate(ProductsUpdate product){
        String query = "insert into productsupdate (id_account,id_product,quantity,updated_date) values(?,?,?,?)";
        
        try {
            conn = new DBConnection().getDBConnection();
            ps = conn.prepareStatement(query);
            
            Date d=new Date();
            
            ps.setInt(1, product.getAccountId());
            ps.setInt(2, product.getProductId());
            ps.setInt(3, product.getQuantity());
            ps.setTimestamp(4, new java.sql.Timestamp(d.getTime()));
            
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public List<ProductsUpdate> getProductsUpdateByAccountId(ProductsUpdate productsUpdate){
        List<ProductsUpdate> list=new ArrayList<>();
        
        String query = "select * from productsupdate where id_account = ?";
        
        try {
            conn = new DBConnection().getDBConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, productsUpdate.getAccountId());
            
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new ProductsUpdate(rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getInt(4),
                rs.getDate(5)));
            }
        } catch (Exception e) {
        }
        return list;
    }
}
