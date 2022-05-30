/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.DBConnection;
import enity.ListProductsUpdate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author docon
 */
public class ListProductsUpdateDAO {
    Connection conn=null;
    PreparedStatement ps = null;
    ResultSet rs=null;
    
    public List<ListProductsUpdate> getListProducts(ArrayList<ListProductsUpdate> listProducts){
        List<ListProductsUpdate> list = new ArrayList<ListProductsUpdate>();
        
        try {
            if(listProducts.size()>0){
                for(ListProductsUpdate c: listProducts){
                    String query = "SELECT * FROM products where id = ?";
                    conn = new DBConnection().getDBConnection();
                    ps = conn.prepareStatement(query);
                    ps.setInt(1, c.getId());
                    
                    rs = ps.executeQuery();
                    while(rs.next()){
                        ListProductsUpdate cart = new ListProductsUpdate();
                        
                        cart.setId(rs.getInt(1));
                        cart.setTitle(rs.getString(2));
                        cart.setPrice(rs.getDouble(3));
                        cart.setThumbnail(rs.getString(4));
                        cart.setContent(rs.getString(5));
                        cart.setQuantity(c.getQuantity());
                        cart.setPrices(rs.getDouble(3)*c.getQuantity());
                        
                        list.add(cart);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return list;
    }
}
