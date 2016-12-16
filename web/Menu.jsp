<%-- 
    Document   : Menu
    Created on : 15-12-2016, 12:20:09
    Author     : JonasSchack
--%>
<%@page import="LogikLag.DomainFacade"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="LogikLag.User"%>
<%
    String ErrorMSG = "";
    request.getSession().setAttribute("Error", ErrorMSG);
    List<User> user = ((ArrayList<User>)DomainFacade.getUser()); 
    for (User users : user) {
    String id = (String) request.getSession().getAttribute("User_Name");
        if (users.getUserName().equals(id)){
            double Balance = users.getBalance();
%>
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
		<form method = "post" action = "Login">
			<fieldset>
                            
                            <div><h3>Velkommen <%String UserName = (String) request.getSession().getAttribute("User_Name"); out.print(UserName);%> </h3></div>
                            <div><h3>Din saldo er: <%out.print(Balance);%> </h3></div>
                            <%}}%>
				<hr class="colorgraph">
				<div class="form-group">
                   <p><a class="btn btn-primary btn-block" href="Shop.jsp">Shoppen</a></p>
				</div>
				<div class="form-group">
                    <p><a class="btn btn-primary btn-block" href="Indbetal.jsp">Indbetal flere penge på kontoen</a></p>
				</div>
                                <div class="form-group">
                    <p><a class="btn btn-primary btn-block" href="http://fotos.fotoflexer.com/fe8888d629a32a748f5fe05e8381d433.gif">Til den som mangler appetit!</a></p>
				</div>
			
				<div class="row">
					<div class="col-xs-6 col-sm-6 col-md-6">
                      
					</div>
					
				</div>
			</fieldset>
		</form>
	</div>
</div>

</div>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"/>
    </body>
</html>
