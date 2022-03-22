/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enity;

import java.util.*;

/**
 *
 * @author docon
 */
public class ProductsUpdate extends Product{
    private int id, accountId, productId, quantity;
    private Date updatedDate;

    public ProductsUpdate() {
        
    }

    public ProductsUpdate(int id, int accountId, int productId, int quantity, Date updatedDate) {
        this.id = id;
        this.accountId = accountId;
        this.productId = productId;
        this.quantity = quantity;
        this.updatedDate = updatedDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
    
}
