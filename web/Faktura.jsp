<%-- 
    Document   : Faktura
    Created on : 15-12-2016, 12:20:57
    Author     : JonasSchack
--%>

<%@page import="LogikLag.Top"%>
<%@page import="LogikLag.Base"%>
<%@page import="LogikLag.Cupcake"%>
<%@page import="LogikLag.Invoice"%>
<%@page import="LogikLag.DomainFacade"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="Css/colorgraph.css">
    </head>
    <body>



        <div class="container">

            <div class="row" style="margin-top:20px">
                <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
                    <fieldset>
                        <h2>Faktura</h2>
                        <div class="col-md-12">
                            <table class ="table table-bordered " border="1" cellpadding="5">
                                <tr>
                                <div class="col-md-3"><th>Cupcake</th></div>
                                <div class="col-md-3"><th>Beskrivelse</th></div>
                                <div class="col-md-2"><th>Pris</th></div>
                                <div class="col-md-2"><th>Antal</th></div>
                                <div class="col-md-2"><th>Ialt</th></div>
                                </tr>

                                <%
                                    int id = (Integer) request.getSession().getAttribute("User_id");
                                    List<Invoice> invoice = ((ArrayList<Invoice>) DomainFacade.getInvoice(id));
                                    List<Top> top = ((ArrayList<Top>) DomainFacade.getTop());
                                    List<Base> base = ((ArrayList<Base>) DomainFacade.getBase());
                                    List<Cupcake> cupcake = ((ArrayList<Cupcake>) DomainFacade.getCupcake());
                                    for (int i = 0; i < invoice.size(); i++) {
                                        for (int c = 0; c < cupcake.size(); c++) {
                                            if (cupcake.get(c).getCupcakeID() == invoice.get(i).getCupcakeID()) {
                                %>

                                <form method = "post" action="Faktura">
                                    <tr>
                                    <div class="col-md-3"><td><%= cupcake.get(c).getCupcakeName()%></td></div>
                                    <div class="col-md-3"><td><%= cupcake.get(c).getCupcakeDis()%></td></div>
                                    <div class="col-md-2"><td><%= cupcake.get(c).getPrice()%></td></div>
                                    <div class="col-mb-2"><td><%= invoice.get(i).getQty()%></td>
                                        <div class="col-md-2"><td><%= cupcake.get(c).getPrice() * invoice.get(i).getQty()%></td></div>
                                        </tr>
                                        <%}
                    }
                }%>
                                        <%
                                            for (int i = 0; i < invoice.size(); i++) {
                                                for (int c = 0; c < top.size(); c++) {
                                                    if (top.get(c).getTopID() == invoice.get(i).getCupcakeID()) {
                                        %>

                                        <form method = "post" action="Faktura">
                                            <tr>
                                            <div class="col-md-3"><td><%= top.get(c).getTopName()%></td></div>
                                            <div class="col-md-3"><td>Ingen</td></div>
                                            <div class="col-md-2"><td><%= top.get(c).getPrice()%></td></div>
                                            <div class="col-mb-2"><td><%= invoice.get(i).getQty()%></td>
                                                <div class="col-md-2"><td><%= top.get(c).getPrice() * invoice.get(i).getQty()%></td></div>
                                                </tr>
                                                <%}
                    }
                }%>
                                                <%
                                                    for (int i = 0; i < invoice.size(); i++) {
                                                        for (int c = 0; c < base.size(); c++) {
                                                            if (base.get(c).getBaseID() == invoice.get(i).getCupcakeID()) {
                                                %>

                                                <form method = "post" action="Faktura">
                                                    <tr>
                                                    <div class="col-md-3"><td><%= base.get(c).getBaseName()%></td></div>
                                                    <div class="col-md-3"><td>Ingen</td></div>
                                                    <div class="col-md-2"><td><%= base.get(c).getPrice()%></td></div>
                                                    <div class="col-mb-2"><td><%= invoice.get(i).getQty()%></td>
                                                        <div class="col-md-2"><td><%= base.get(c).getPrice() * invoice.get(i).getQty()%></td></div>
                                                        </tr>
                                                        <%}
                    }
                }%>
                                                        </table>
                                                    </div>
                                            </div>

                                    </div>
                                    </div>
                                    </div>
                                    <p><a class="btn btn-primary btn-block" href="Menu.jsp">Tilbage til menu</a></p>
                                    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"/>
                                    </body>
                                    </html>

