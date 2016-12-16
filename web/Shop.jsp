<%-- 
    Document   : Shop
    Created on : 15-12-2016, 12:20:20
    Author     : JonasSchack
--%>

<%@page import="LogikLag.Invoice"%>
<%@page import="LogikLag.User"%>
<%@page import="LogikLag.Cupcake"%>
<%@page import="LogikLag.Top"%>
<%@page import="LogikLag.DomainFacade"%>
<%@page import="LogikLag.Base"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <link rel="stylesheet" href="Css/colorgraph.css">
    </head>
            <%
                List<Top> top = ((ArrayList<Top>) DomainFacade.getTop());
                List<Base> base = ((ArrayList<Base>) DomainFacade.getBase());
                List<Cupcake> cupcake = ((ArrayList<Cupcake>) DomainFacade.getCupcake());
                int id = (Integer) request.getSession().getAttribute("User_id");
                List<User> user = ((ArrayList<User>) DomainFacade.getUser());
                List<Invoice> invoice = ((ArrayList<Invoice>) DomainFacade.getInvoice(id));
                for (User users : user) {
                    if (users.getId() == (id)) {
                        double Balance = users.getBalance();
                        int count = invoice.size();
            %>
    <body><div class="container">

            <div class="col-md-7"><a href="Menu.jsp">Tilbage til menu</a></div><div class="col-md-3"><b>Forskellige kager i kurven: <%=count%></b></div><div class="col-md-2"><b>Saldo: <%=Balance%></b></div>
            <%}
                }%>
            <div class="row" align="center">


                <div class="col-md-12">
                    <table class ="table table-bordered " border="1" cellpadding="5">
                        <tr>
                        <div class="col-md-12"><th><h1>Kurv</h1></th></div>
                        </tr>
                        <tr>
                            <%
                                for (int h = 0; h < invoice.size(); h++) {
                                    for (int c = 0; c < cupcake.size(); c++) {
                                        if (cupcake.get(c).getCupcakeID() == invoice.get(h).getCupcakeID()) {
                            %>
                        <form method = "post" action="Cupcakes">
                            <div class="col-md-7"><td><%out.print(invoice.get(h).getQty());%> X 
                                    <%out.print(cupcake.get(c).getCupcakeName());%>  -  
                                    <%= cupcake.get(c).getPrice() * invoice.get(h).getQty()%> Kr.<td></div>
                            <input class="col-mb-5 btn btn-danger btn-block" type="Submit" name ="valg" value ="Slet">
                            <input type="hidden" name ="SID" value ="<%=invoice.get(h).getSID()%>">
                            <input type="hidden" name ="qty" value ="<%=invoice.get(h).getQty()%>">
                            <input type="hidden" name ="PRICE" value ="<%=cupcake.get(c).getPrice()%>">
                        </form>
                        <%}
                                }
                            }%>
                        </tr>
                        <tr>
                            <%
                                for (int h = 0; h < invoice.size(); h++) {
                                    for (int c = 0; c < top.size(); c++) {
                                        if (top.get(c).getTopID() == invoice.get(h).getCupcakeID()) {
                            %>
                        <form method = "post" action="Cupcakes">
                            <div class="col-md-7"><td><%out.print(invoice.get(h).getQty());%> X 
                                    <%out.print(top.get(c).getTopName());%>  -  
                                    <%= top.get(c).getPrice() * invoice.get(h).getQty()%> Kr.<td></div>
                            <input class="col-mb-5 btn btn-danger btn-block" type="Submit" name ="valg" value ="Slet">
                            <input type="hidden" name ="SID" value ="<%=invoice.get(h).getSID()%>">
                            <input type="hidden" name ="qty" value ="<%=invoice.get(h).getQty()%>">
                            <input type="hidden" name ="PRICE" value ="<%=top.get(c).getPrice()%>">
                        </form>
                        <%}
                                }
                            }%>
                        </tr>
                        <tr>
                            <%
                                for (int h = 0; h < invoice.size(); h++) {
                                    for (int c = 0; c < base.size(); c++) {
                                        if (base.get(c).getBaseID() == invoice.get(h).getCupcakeID()) {
                            %>
                        <form method = "post" action="Cupcakes">
                            <div class="col-md-7"><td><%out.print(invoice.get(h).getQty());%> X 
                                    <%out.print(base.get(c).getBaseName());%>  -  
                                    <%= base.get(c).getPrice() * invoice.get(h).getQty()%> Kr.<td></div>
                            <input class="col-mb-5 btn btn-danger btn-block" type="Submit" name ="valg" value ="Slet">
                            <input type="hidden" name ="SID" value ="<%=invoice.get(h).getSID()%>">
                            <input type="hidden" name ="qty" value ="<%=invoice.get(h).getQty()%>">
                            <input type="hidden" name ="PRICE" value ="<%=base.get(c).getPrice()%>">
                        </form>
                        <%}
                                }
                            }%>
                        </tr>
                </div>
            </div>
        </div>
        <div class="row" align="center">
            <br>
            <h2>Her kan du prøve vores yndlings cupcakes!</h2><br>
            <h2><b><%out.print(request.getSession().getAttribute("Error"));%></b></h2></div>
            <tr>
            <div class="col-md-2"><th>Cupcake</th></div>
            <div class="col-md-2"><th>Beskrivelse</th></div>
            <div class="col-md-1"><th>Pris</th></div>
            <div class="col-md-1"><th>Antal</th></div>
            <div class="col-md-2"><th>Tilføj</th></div>
        </tr>
        <%
            for (int i = 0; i < cupcake.size(); i++) {
        %>

        <tr>
        <form method = "post" action="Cupcakes">
            <input type="hidden" name ="ID" value ="<%= cupcake.get(i).getCupcakeID()%>">
            <div class="col-md-2"><td><%out.print(cupcake.get(i).getCupcakeName());%></td></div>
            <div class="col-md-2"><td><%out.print(cupcake.get(i).getCupcakeDis());%></td></div>
            <div class="col-md-1"><td><%out.print(cupcake.get(i).getPrice());%></td></div>
            <div class="col-md-1"><td><input type="text" name ="qty" value="1"></td<</div>
            <div class="col-md-2"><td><input class="btn btn-primary btn-block" type="Submit" name ="valg" value ="Add"></td></div>
            <input type="hidden" name ="PRICE" value ="<%= cupcake.get(i).getPrice()%>">
        </form>
        <%}%>
    </tr>
</table>
</div>


<div class="row" align="center">
    <h2>Her kan du lave dine egne cupcakes!<br>Husk både at vælge en top og en bund, ellers bliver det en kedelig kage!</h2></div>


<div class="col-md-12">
    <table class ="table table-bordered " border="1" cellpadding="5">
        <tr>
        <div class="col-md-3"><th>Bund</th></div>
        <div class="col-md-3"><th>Pris</th></div>
        <div class="col-md-3"><th>Antal</th></div>
        <div class="col-md-3"><th>Tilføj</th></div>
        </tr>
        <%
            for (int g = 0; g < base.size(); g++) {
        %>

        <tr>
        <form method = "post" action="Cupcakes">
            <div class="col-md-3"><td><%out.print(base.get(g).getBaseName());%></td></div>
            <div class="col-md-3"><td><%out.print(base.get(g).getPrice());%></td></div>
            <div class="col-md-3"><td><input type="text" name ="qty" value="1"></td></div>
            <div class="col-md-3"><td><input class="btn btn-primary btn-block" type="Submit" name ="valg" value ="Add"></td></div>
            <input type="hidden" name ="ID" value ="<%= base.get(g).getBaseID()%>">
            <input type="hidden" name ="PRICE" value ="<%= base.get(g).getPrice()%>">
        </form>

        </tr>
        <%}%>

        <tr>
        <div class="col-md-3"><th>Top</th></div>
        <div class="col-md-3"><th>Pris</th></div>
        <div class="col-md-3"><th>Antal</th></div>
        <div class="col-md-3"><th>Tilføj</th></div>
        </tr>
        <%
            for (int d = 0; d < top.size(); d++) {
        %>

        <tr>
        <form method = "post" action="Cupcakes">
            <div class="col-md-3"><td><%out.print(top.get(d).getTopName());%></td></div>
            <div class="col-md-3"><td><%out.print(top.get(d).getPrice());%></td></div>
            <div class="col-md-3"><td><input type="text" name ="qty" value="1"></td></div>
            <div class="col-md-3"><td><input class="btn btn-primary btn-block" type="Submit" name ="valg" value ="Add"></td></div>
            <input type="hidden" name ="ID" value ="<%= top.get(d).getTopID()%>">
            <input type="hidden" name ="PRICE" value ="<%= top.get(d).getPrice()%>">
        </form>

        <%}%>
    </table>
    <form method = "post" action="Cupcakes">
        <div class="col-md-12"><input class="btn btn-success btn-block" type="Submit" name ="valg" value ="Betal"></div>
    </form>
</div>
</div>
</tr>
                </div>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"/>
</body>
</html>


