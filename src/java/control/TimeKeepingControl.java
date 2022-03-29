/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.DAO;
import enity.*;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "TimeKeepingControl", urlPatterns = {"/time-keeping"})
public class TimeKeepingControl extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddToListProducts</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddToListProducts at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        response.setContentType("text/html;charset=UTF-8");
        
        String id = request.getParameter("id");
        
        DAO dao=new DAO();
        
        List<TimeKeeping> list = dao.getDateTimeKeepingByAccountId(id);
        
        List<Integer> listDate = new ArrayList<>();
        
        LocalDate  currentdate = LocalDate.now();
        int month=currentdate.getMonthValue(),year=currentdate.getYear();
        
        Calendar calendar = Calendar.getInstance();
        for(TimeKeeping t: list){
            Date date = t.getTime();
            calendar.setTime(date);
            if(t.getTime().toString().contains(String.valueOf(month)) && 
                    t.getTime().toString().contains(String.valueOf(year))){
                listDate.add(calendar.get(Calendar.DAY_OF_MONTH));
            }
        }
        
        request.setAttribute("listDate", listDate);
        request.setAttribute("listDateSize", listDate.size()-1);
        request.setAttribute("monthnow", month);
        request.setAttribute("yearnow", year);

        request.getRequestDispatcher("timekeeping.jsp").forward(request, response);
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
