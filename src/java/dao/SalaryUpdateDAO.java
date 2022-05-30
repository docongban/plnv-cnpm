/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.DBConnection;
import enity.SalaryUpdate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author docon
 */
public class SalaryUpdateDAO {
    Connection conn=null;
    PreparedStatement ps = null;
    ResultSet rs=null;
    
    public void insertSalaryUpdate(SalaryUpdate salaryUpdate){
        String query = "insert into salaryupdate (salary) values (?)";
        
        try {
            conn = new DBConnection().getDBConnection();
            ps = conn.prepareStatement(query);
            ps.setDouble(1, salaryUpdate.getSalary());
            
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
}
