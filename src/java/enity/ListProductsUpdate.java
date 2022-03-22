/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enity;

import java.util.Date;

/**
 *
 * @author docon
 */
public class ListProductsUpdate extends Product{
    private int quantity;
    private double prices;

    public ListProductsUpdate() {
        
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrices() {
        return prices;
    }

    public void setPrices(double prices) {
        this.prices = prices;
    }
}
