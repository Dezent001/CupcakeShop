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
public class User {

    String UserName;
    String Password;
    double Balance;
    int id;

    public User(String UserName, String Password, double Balance, int ID) {
        this.UserName = UserName;
        this.Password = Password;
        this.Balance = Balance;
        this.id = ID;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User(double Balance) {
        this.Balance = Balance;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double Balance) {
        this.Balance = Balance;
    }
    
}
