/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogikLag;

/**
 *
 * @author JonasSchack
 */
public class Top {
    
    int TopID;
    String TopName;
    double Price;
    
    public Top(int TopID, String TopName, double Price) {
        this.TopID = TopID;
        this.TopName = TopName;
        this.Price = Price;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public int getTopID() {
        return TopID;
    }

    public void setTopID(int TopID) {
        this.TopID = TopID;
    }

    public String getTopName() {
        return TopName;
    }

    public void setTopName(String TopName) {
        this.TopName = TopName;
    }
    
}
