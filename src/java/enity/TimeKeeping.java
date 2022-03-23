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
public class TimeKeeping extends Account{
    private int id, accountId;
    private Date time;

    public TimeKeeping() {
        
    }

    public TimeKeeping(int id, int accountId, Date time) {
        this.id = id;
        this.accountId = accountId;
        this.time = time;
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
    
    
}
