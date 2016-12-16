/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogikLag;

import DataLag.CupcakeMapper;
import DataLag.InvoiceMapper;
import DataLag.UserMapper;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author JonasSchack
 */
public class DomainFacade {
    
    public static List<Base> getBase() throws SQLException, ClassNotFoundException {
        List<Base> base = CupcakeMapper.getBase();

        if (base != null) {
            System.out.println("getBase virker");
        }
        return base;

    }
    
    public static List<Top> getTop() throws SQLException, ClassNotFoundException {
        List<Top> top = CupcakeMapper.getTop();

        if (top != null) {
            System.out.println("getTop virker");
        }
        return top;

    }
    
    public static List<Cupcake> getCupcake() throws SQLException, ClassNotFoundException {
        List<Cupcake> cupcake = CupcakeMapper.getCupcake();

        if (cupcake != null) {
            System.out.println("getCupcake virker");
        }
        return cupcake;

    }
    
    public static List<User> getUser() throws SQLException, ClassNotFoundException {
        List<User> user = UserMapper.getUser();

        if (user != null) {
            System.out.println("getUser virker");
        }
        return user;

    }
    
    public static List<Invoice> getInvoice(int id) throws SQLException, ClassNotFoundException {
        List<Invoice> invoice = InvoiceMapper.getInvoice(id);

        if (invoice != null) {
            System.out.println("getInvoice virker");
        }
        return invoice;

    }
    
}


