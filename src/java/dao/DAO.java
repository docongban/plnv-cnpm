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
import java.time.LocalDate;
import java.util.*;

/**
 *
 * @author docon
 */
public class DAO {
    Connection conn=null;
    PreparedStatement ps = null;
    ResultSet rs=null;
    
    public Account login(Account account){
        String query = "select * from accounts where phone=? and pass = ?";
        
        try {
            conn = new DBConnection().getDBConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, account.getPhone());
            ps.setString(2, account.getPass());
            
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
     
    //test
    public static void main(String[] args) {
        DAO dao=new DAO();
//        System.out.println(dao.login("0123456789", "123456").getFullname());
//        dao.insertSalaryUpdate(200);
//        System.out.println(dao.getNewUpdateSalary());

//        dao.insertMaxProductsUpdate("111");
//        System.out.println(dao.getNewMaxProductsUpdate());
//        List<Product> list = dao.searchProductByName("nike");
//        for(Product p: list){
//            System.out.println(p.getTitle());
//        }
        TimeKeeping timeKeeping=new TimeKeeping();
        timeKeeping.setAccountId(Integer.parseInt("4"));
        List<TimeKeeping> list = dao.getDateTimeKeepingByAccountId(timeKeeping);
        ProductsUpdate productsUpdate=new ProductsUpdate();
        productsUpdate.setAccountId(Integer.parseInt("4"));
        List<ProductsUpdate> listP = dao.getProductsUpdateByAccountId(productsUpdate);
        
        List<Integer> listDate = new ArrayList<>();
        List<Integer> listMonth = new ArrayList<>();
        List<Integer> listYear = new ArrayList<>();
        List<Integer> listYearNew = new ArrayList<>();
        
        LocalDate  currentdate = LocalDate.now();
        int month=currentdate.getMonthValue(),year=currentdate.getYear();
        
        Calendar calendar = Calendar.getInstance();
        for(TimeKeeping t: list){
            Date date = t.getTime();
            calendar.setTime(date);
//            listDate.add(calendar.get(Calendar.DAY_OF_MONTH));
//            listMonth.add(calendar.get(Calendar.MONTH));
            listYear.add(calendar.get(Calendar.YEAR));
        }
        
        //bo phan tu trung
        for(Integer i : listYear){
            if(!listYearNew.contains(i)){
                listYearNew.add(i);
            }
        }
        List<String> listMonthYear = new ArrayList<>();
        String monthYear="";
        
        for(Integer o: listYearNew){
            for(int i=1;i<=12;i++){
                monthYear+=i+"-"+o;
                
                int count=0;
                for(TimeKeeping t: list){
                    Date date = t.getTime();
                    calendar.setTime(date);
                    if(t.getTime().toString().contains(String.valueOf(o))){
                        if(calendar.get(Calendar.MONTH)==(i-1)){
                            count++;
                        }
                    }
                }
                listMonthYear.add(monthYear);
//                monthYear+=count;
            }
        }
//        System.out.println(listMonthYear.size());
    }
}
