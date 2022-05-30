/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.DBConnection;
import enity.TimeKeeping;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author docon
 */
public class TimeKeepingDAO {
    Connection conn=null;
    PreparedStatement ps = null;
    ResultSet rs=null;
    
    public List<TimeKeeping> getDateTimeKeepingByAccountId(TimeKeeping timeKeeping){
        List<TimeKeeping> list=new ArrayList<>();
        String query = "select * from timekeeping where id_account = ?";
        try {
            conn = new DBConnection().getDBConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, timeKeeping.getAccountId());
            
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new TimeKeeping(rs.getInt(1),
                rs.getInt(2),
                rs.getDate(3)));
            }
        } catch (Exception e) {
        }
        return list;
    }
}
