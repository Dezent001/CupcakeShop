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
public class Invoice {
    int InvoiceID;
    int CupcakeID;
    int Qty;
    int SID;

    public Invoice(int InvoiceID, int CupcakeID, int Qty, int SID) {
        this.InvoiceID = InvoiceID;
        this.CupcakeID = CupcakeID;
        this.Qty = Qty;
        this.SID = SID;
        
    }
    
    public Invoice(int InvoiceID, int CupcakeID, int Qty) {
        this.InvoiceID = InvoiceID;
        this.CupcakeID = CupcakeID;
        this.Qty = Qty;
        
    }

    public int getSID() {
        return SID;
    }

    public void setSID(int SID) {
        this.SID = SID;
    }

    public int getInvoiceID() {
        return InvoiceID;
    }

    public void setInvoiceID(int InvoiceID) {
        this.InvoiceID = InvoiceID;
    }

    public int getCupcakeID() {
        return CupcakeID;
    }

    public void setCupcakeID(int CupcakeID) {
        this.CupcakeID = CupcakeID;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int Qty) {
        this.Qty = Qty;
    }
    
}
