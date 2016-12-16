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
public class Base {
    
    int BaseID;
    String BaseName;
    double Price;

    public Base(int BaseID, String BaseName, double Price) {
        this.BaseID = BaseID;
        this.BaseName = BaseName;
        this.Price = Price;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public int getBaseID() {
        return BaseID;
    }

    public void setBaseID(int BaseID) {
        this.BaseID = BaseID;
    }

    public String getBaseName() {
        return BaseName;
    }

    public void setBaseName(String BaseName) {
        this.BaseName = BaseName;
    }
    
    
}
