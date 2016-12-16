/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PræsentationsLag;

import DataLag.InvoiceMapper;
import DataLag.UserMapper;
import LogikLag.DomainFacade;
import LogikLag.Invoice;
import LogikLag.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JonasSchack
 */
@WebServlet(name = "Cupcakes", urlPatterns = {"/Cupcakes"})
public class Cupcakes extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        String ErrorMSG = "";
        request.getSession().setAttribute("Error", ErrorMSG);
        response.setContentType("text/html;charset=UTF-8");
        String Valg = request.getParameter("valg");
        System.out.println(Valg);
        switch (Valg) {
            case "Add":
                List<User> user = ((ArrayList<User>) DomainFacade.getUser());
                int UID = (Integer) request.getSession().getAttribute("User_id");
                int Qty = Integer.parseInt(request.getParameter("qty"));
                double Price = Double.parseDouble(request.getParameter("PRICE"));
                double Error = Price * Qty;
                for (User users : user) {
                    if (users.getId() == (UID)) {
                        if (users.getBalance() > Error) {
                            Add(request);
                            request.getRequestDispatcher("/Shop.jsp").forward(request, response);
                        } else {
                            ErrorMSG = "Du har ikke råd til at foretage denne handel!";
                            request.getSession().setAttribute("Error", ErrorMSG);
                            request.getRequestDispatcher("/Shop.jsp").forward(request, response);
                        }
                    }
                }
                break;
            case "Slet":
                Slet(request);
                request.getRequestDispatcher("/Shop.jsp").forward(request, response);
                break;
            case "Betal":
                request.getRequestDispatcher("/Faktura.jsp").forward(request, response);
                int id = (Integer) request.getSession().getAttribute("User_id");
                InvoiceMapper.RemoveAllInvoice(id);
                break;
            default:
                request.getRequestDispatcher("/index.html").forward(request, response);
                break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cupcakes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Cupcakes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cupcakes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Cupcakes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void Add(HttpServletRequest request) throws ClassNotFoundException, SQLException, IOException, ServletException {
        int Qty = Integer.parseInt(request.getParameter("qty"));
        double Price = Double.parseDouble(request.getParameter("PRICE"));
        int InvoiceID = (Integer) request.getSession().getAttribute("User_id");
        int CupcakeID = Integer.parseInt(request.getParameter("ID"));
        Invoice i = new Invoice(InvoiceID, CupcakeID, Qty);
        InvoiceMapper.NewInvoice(i);
        List<User> user = ((ArrayList<User>) DomainFacade.getUser());
        for (User users : user) {
            if (users.getId() == (InvoiceID)) {
                double Bala = users.getBalance();
                double total = Price * Qty;
                double Balance = Bala - total;
                int id = InvoiceID;
                User u = new User(Balance);
                UserMapper.updateBalance(u, id);
            }
        }
    }

    private void Slet(HttpServletRequest request) throws ClassNotFoundException, SQLException, IOException, ServletException {
        int Qty = Integer.parseInt(request.getParameter("qty"));
        double Price = Double.parseDouble(request.getParameter("PRICE"));
        int id = Integer.parseInt(request.getParameter("SID"));
        int UID = (Integer) request.getSession().getAttribute("User_id");
        List<User> user = ((ArrayList<User>) DomainFacade.getUser());
        for (User users : user) {
            if (users.getId() == (UID)) {
                double Bala = users.getBalance();
                double total = Price * Qty;
                double Balance = Bala + total;
                User u = new User(Balance);
                UserMapper.updateBalance(u, UID);
                InvoiceMapper.RemoveInvoice(id);
            }
        }
    }
}
