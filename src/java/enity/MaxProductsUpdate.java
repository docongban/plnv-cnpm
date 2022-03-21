/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enity;

/**
 *
 * @author docon
 */
public class MaxProductsUpdate {
    private int id, maxproducts;

    public MaxProductsUpdate() {
        
    }

    public MaxProductsUpdate(int id, int maxproducts) {
        this.id = id;
        this.maxproducts = maxproducts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaxproducts() {
        return maxproducts;
    }

    public void setMaxproducts(int maxproducts) {
        this.maxproducts = maxproducts;
    }
    
    
}
