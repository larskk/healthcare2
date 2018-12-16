<%-- 
    Document   : regsitrer
    Created on : 02-12-2018, 12:20:53
    Author     : LarsKramer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Opret dig som bruger</h1>
        <form action="frontControl" method="POST">
            
            Fornavn:<br>
            <input type="text" name="firstName" autofocus required><br>
            Efternavn<br>
            <input type="text" name="lastName" required><br>
            Telefonnummer:<br>
            <input type="text" name="phone"><br>
            Email:<br>
            <input type="text" name="email" required><br>
            Adgangskode:<br>
            <input type="password" name="password" required><br>
            Rolle:<br>
            <input type="radio" name="role" value="1" checked>Bruger
            <input type="radio" name="role" value="2">Behandler
            <input type="radio" name="role" value="3">Administrator<br>

            <input type="hidden" name="origin" value=register><br>
            <input type="submit" name="submit" value="Registrer">
        </form>
    </body>
</html>
