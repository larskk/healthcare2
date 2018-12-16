<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        
        <% String message = (String)request.getAttribute("message");
        if (message!=null) { %>
         <h2 style="color:red"><%= message %></h2>
         <% } %>
        <form action="frontControl" method="POST">
            Email:<br>
            <input type="email" name="email"><br>
            Adgangskode:<br>
            <input type="password" name="pwd" required><br>
            
            <input type="hidden" name="origin" value="login">
            <input type="submit" name="submit" value="Login">
        </form>
    </body>
</html>
