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
public class Cupcake {

   int CupcakeID;
   String CupcakeName;
   String CupcakeDis;
   int TopID;
   int BaseID;
   double price;

    public Cupcake(int CupcakeID, String CupcakeName, String CupcakeDis, int TopID, int BaseID, double price) {
        this.CupcakeID = CupcakeID;
        this.CupcakeName = CupcakeName;
        this.CupcakeDis = CupcakeDis;
        this.TopID = TopID;
        this.BaseID = BaseID;
        this.price = price;
    }

    public String getCupcakeDis() {
        return CupcakeDis;
    }

    public void setCupcakeDis(String CupcakeDis) {
        this.CupcakeDis = CupcakeDis;
    }

    public int getCupcakeID() {
        return CupcakeID;
    }

    public void setCupcakeID(int CupcakeID) {
        this.CupcakeID = CupcakeID;
    }

    public String getCupcakeName() {
        return CupcakeName;
    }

    public void setCupcakeName(String CupcakeName) {
        this.CupcakeName = CupcakeName;
    }

    public int getTopID() {
        return TopID;
    }

    public void setTopID(int TopID) {
        this.TopID = TopID;
    }

    public int getBaseID() {
        return BaseID;
    }

    public void setBaseID(int BaseID) {
        this.BaseID = BaseID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
}
