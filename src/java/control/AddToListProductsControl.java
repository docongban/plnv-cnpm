/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import enity.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author docon
 */
@WebServlet(name = "AddToListProducts", urlPatterns = {"/add-to-list-products"})
public class AddToListProductsControl extends HttpServlet {

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
        
        try(PrintWriter out = response.getWriter()) {
            ArrayList<ListProductsUpdate> listProducts = new ArrayList<>();
        
            int id = Integer.parseInt(request.getParameter("id"));
            ListProductsUpdate cart = new ListProductsUpdate();
            cart.setId(id);
            cart.setQuantity(1);
            
            HttpSession session = request.getSession();
            ArrayList<ListProductsUpdate> cart_list = (ArrayList<ListProductsUpdate>) session.getAttribute("cart-list");
            
            if (cart_list == null) {
                listProducts.add(cart);
                session.setAttribute("cart-list", listProducts);
                session.setMaxInactiveInterval(60*60*24);
                response.sendRedirect("product");
            } else {
                listProducts = cart_list;

                boolean exist = false;
                for (ListProductsUpdate c : cart_list) {
                    if (c.getId() == id) {
                        //Cong them quantity khi bam 2 lan
                        exist = true;
                        int quantity = c.getQuantity();
                        quantity++;
                        c.setQuantity(quantity);
                        response.sendRedirect("product");
                    }
                }

                if (!exist) {
                    listProducts.add(cart);
                    response.sendRedirect("product");
                }
            }
        } catch (Exception e) {
        }
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
