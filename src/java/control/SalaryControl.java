/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.*;
import enity.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author docon
 */
@WebServlet(name = "SalaryControl", urlPatterns = {"/salary"})
public class SalaryControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String id = request.getParameter("id");
        
        TimeKeeping timeKeeping=new TimeKeeping();
        timeKeeping.setAccountId(Integer.parseInt(id));
        ProductsUpdate productsUpdate=new ProductsUpdate();
        productsUpdate.setAccountId(Integer.parseInt(id));
        
        TimeKeepingDAO timeKeepingDAO=new TimeKeepingDAO();
        List<TimeKeeping> list = timeKeepingDAO.getDateTimeKeepingByAccountId(timeKeeping);
        ProductsUpdateDAO productsUpdateDAO=new ProductsUpdateDAO();
        List<ProductsUpdate> listP = productsUpdateDAO.getProductsUpdateByAccountId(productsUpdate);
        
        List<Integer> listDate = new ArrayList<>();
        List<Integer> listMonth = new ArrayList<>();
        List<Integer> listYear = new ArrayList<>();
        List<Integer> listYearNew = new ArrayList<>();
        
        DecimalFormat df = new DecimalFormat(",###");
        LocalDate  currentdate = LocalDate.now();
        int month=currentdate.getMonthValue(),year=currentdate.getYear();
        
        Calendar calendar = Calendar.getInstance();
        // lay ra nam
        for(TimeKeeping t: list){
            Date date = t.getTime();
            calendar.setTime(date);
            listYear.add(calendar.get(Calendar.YEAR));
        }
        
        //bo phan tu trung
        for(Integer i : listYear){
            if(!listYearNew.contains(i)){
                listYearNew.add(i);
            }
        }
        SalaryUpdateDAO salaryUpdateDAO=new SalaryUpdateDAO();
        MaxProductUpdateDAO maxProductUpdateDAO=new MaxProductUpdateDAO();
        
        List<String> listMonthYear = new ArrayList<>();
        List<Integer> listWorkDays = new ArrayList<>();
        List<Integer> listProdutWorked = new ArrayList<>();
        List<Integer> listOverTargetProducts = new ArrayList<>();
        List<String> listBonus = new ArrayList<>();
        List<String> listTotalSalary = new ArrayList<>();
        double salaryMin = salaryUpdateDAO.getNewUpdateSalary();
        int quantityMin = maxProductUpdateDAO.getNewMaxProductsUpdate();
        int overTargetProducts = 0;
        int bonus = 0;
        int totalSalary = 0;
        
        for(Integer o: listYearNew){
            // check nam hien tai
            if(o==year){
                for(int i=1;i<=12;i++){
                    listMonthYear.add(i+"-"+o);
                    
                    // so ngay da lam
                    int count=0;
                    for(TimeKeeping t: list){
                        Date date = t.getTime();
                        calendar.setTime(date);
                        if(t.getTime().toString().contains(String.valueOf(o))){
                            if(calendar.get(Calendar.MONTH)==(i-1)){
                                count+=1;
                            }
                        }
                    }
                    listWorkDays.add(count);
                    
                    //so sp da ban
                    int countProduct=0;
                    for(ProductsUpdate p: listP){
                        Date date = p.getUpdatedDate();
                        calendar.setTime(date);
                        if(p.getUpdatedDate().toString().contains(String.valueOf(o))){
                            if(calendar.get(Calendar.MONTH)==(i-1)){
                                countProduct+=p.getQuantity();
                            }
                        }
                    }
                    listProdutWorked.add(countProduct);
                    
                    //so sp vuot chi tieu
                    if(countProduct>quantityMin){
                        overTargetProducts = countProduct-quantityMin;
                    }else{
                        overTargetProducts = 0;
                    }
                    listOverTargetProducts.add(overTargetProducts);
                    
                    //thuong vuot chi tieu va lam du buoi
                    if(count>=20){
                        bonus = 20000*overTargetProducts;
                    }else{
                        bonus = 0;
                    }
                    listBonus.add(df.format(bonus));
                    
                    //tong luong
                    if(count>=20){
                        totalSalary = (int)salaryMin + bonus;
                    }else if(count>=8&&count<20){
                        totalSalary = (int)salaryMin - 50000*(20-count);
                    }else{
                        totalSalary = 0;
                    }
                    listTotalSalary.add(df.format(totalSalary));
                }
                
                break;
            }
        }
        
        
        request.setAttribute("listDate", listDate);
        request.setAttribute("listDateSize", listDate.size());
        request.setAttribute("yearnow", year);
        request.setAttribute("monthnow", month);
        request.setAttribute("listMonthYear", listMonthYear);
        request.setAttribute("listWorkDays", listWorkDays);
        request.setAttribute("listProdutWorked", listProdutWorked);
        request.setAttribute("listOverTargetProducts", listOverTargetProducts);
        request.setAttribute("listBonus", listBonus);
        request.setAttribute("listTotalSalary", listTotalSalary);
        request.setAttribute("salary", df.format(salaryMin));
        request.setAttribute("quantityMin", quantityMin);
        
        request.getRequestDispatcher("salary.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
