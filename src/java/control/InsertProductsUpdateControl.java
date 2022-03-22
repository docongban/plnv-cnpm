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
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author docon
 */
@WebServlet(name = "InsertProductsUpdateControl", urlPatterns = {"/insert-products-update"})
public class InsertProductsUpdateControl extends HttpServlet {

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
        try(PrintWriter out= response.getWriter() ) {
            
            ArrayList<ListProductsUpdate> cart_list = (ArrayList<ListProductsUpdate>) request.getSession().getAttribute("cart-list");
            
            Account account = (Account) request.getSession().getAttribute("acc");
            
            Date d=new Date();
            
            if(cart_list!=null && account!=null){
                
                for(ListProductsUpdate c: cart_list){
                    ProductsUpdate product =new ProductsUpdate();
                    product.setProductId(c.getId());
                    product.setAccountId(account.getId());
                    product.setQuantity(c.getQuantity());
                    product.setUpdatedDate(new java.sql.Timestamp(d.getTime()));
                    
                    DAO dao=new DAO();
                    dao.insertProductsUpdate(product);
                }
                
                cart_list.clear();
                response.sendRedirect("productsupdate.jsp");
                
            }else{
                if(account==null){
                    response.sendRedirect("login.jsp");
                }else{
                    response.sendRedirect("productsupdate.jsp");
                }
            }
        } catch (Exception e) {
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
