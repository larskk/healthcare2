<%-- 
    Document   : login
    Created on : 01-12-2018, 19:54:20
    Author     : LarsKramer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="frontControl" method="POST">
            Email eller telefonnummer<br>
            <input type="text" name="username" value="" ><br>
            Adgangskode:<br>
            <input type="text" name="password" value="" ><br>
            <input type="hidden" name="origin" value="login"/>
            <input type="submit" name="submit" value="Login" />
        </form>
    </body>
</html>
