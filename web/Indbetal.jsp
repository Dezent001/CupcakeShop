<%-- 
    Document   : Indbetal
    Created on : 15-12-2016, 12:20:30
    Author     : JonasSchack
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>
    <body>
     
        
        
        <div class="container">

<div class="row" style="margin-top:20px">
    <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
		<form method = "post" action = "Indbetaling">
			<fieldset>
                            
                            <div><h2>Her kan du forhøje din balance for brugeren: <%String UserName = (String) request.getSession().getAttribute("User_Name"); out.print(UserName);%> </h2></div>
				<div class="form-group">
                    <p>For høj din balance med: <input class="form-control" type="number" name ="Balance"/><br/><p/>
				</div>
                    <input class="btn btn-primary btn-block"  type ="Submit" name ="Opret" value = "Godkend betaling"/>
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
