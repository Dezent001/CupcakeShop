/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLag;

import LogikLag.Cupcake;
import LogikLag.Invoice;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JonasSchack
 */
public class InvoiceMapper {

    public static boolean removeInvoice(int id) throws ClassNotFoundException {
        String sql = "DELETE FROM invoice_line WHERE invoice_id = '" + id + "';";

        try (PreparedStatement ps = Connector.prepare(sql)) {
            ps.execute();
        } catch (SQLException ex) {
            String msg = "kunne ikke slette invoice";
        }
        return true;
    }

    public static List<Invoice> getInvoice(int id) throws SQLException, ClassNotFoundException {
        List<Invoice> invoice = new ArrayList();
        String sql = "SELECT * FROM invoice_line WHERE id = '" + id + "';";

        try {
            Connector DB = Connector.getInstance();
            Statement stmt = DB.getConnection().createStatement();
            ResultSet res = stmt.executeQuery(sql);
            while (res.next()) {
                int InvoiceID = res.getInt("id");
                int CupcakeID = res.getInt("cupcake_id");
                int qty = res.getInt("qty");
                int SID = res.getInt("special_id");
                invoice.add(new Invoice(InvoiceID, CupcakeID, qty, SID));

            }
            System.out.println(sql);
        } catch (SQLException ex) {
        }
        return invoice;
    }

    public static void NewInvoice(Invoice i) throws ClassNotFoundException, SQLException, IOException {
        int InvoiceID = i.getInvoiceID();
        int ID = i.getCupcakeID();
        int Qty = i.getQty();
        String sql = "INSERT INTO invoice_line (id, cupcake_id, qty) values (?,?,?)";
        PreparedStatement stmt = Connector.prepare(sql);
        stmt.setInt(1, InvoiceID);
        stmt.setInt(2, ID);
        stmt.setInt(3, Qty);

        System.out.println(sql);
        try {
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Invoice added");
            } else {
                System.out.println("No change");
            }
        } catch (SQLException ex) {
            System.out.println("I broke somewhere SQLExeception " + ex.getMessage());
        }
    }

    public static void RemoveInvoice(int id) throws ClassNotFoundException {
        String sql = "DELETE FROM invoice_line WHERE special_id = '" + id + "';";
        try (PreparedStatement ps = Connector.prepare(sql)) {
            ps.execute();
        } catch (SQLException ex) {
        }
    }

    public static void RemoveAllInvoice(int id) throws ClassNotFoundException {
        String sql = "DELETE FROM invoice_line WHERE id = '" + id + "';";
        try (PreparedStatement ps = Connector.prepare(sql)) {
            ps.execute();
        } catch (SQLException ex) {
        }
    }
}
