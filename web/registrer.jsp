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
            Rolle:<br>
            <input type="checkbox" name="role" value="user">Bruger
            <input type="checkbox" name="role" value="therapist">Behandler
            <input type="checkbox" name="role" value="administrator">Administrator<br>
            
            Fornavn:<br>
            <input type="text" name="firstName" value=""><br>
            Efternavn<br>
            <input type="text" name="lastName" value=""><br>
            Telefonnummer:<br>
            <input type="text" name="phone" value=""><br>
            Email:<br>
            <input type="text" name="email" value=""><br>
            Adgangskode:<br>
            <input type="password" name="password" value=""><br>

            <input type="hidden" name="origin" value="register"><br>
            <input type="submit" name="submit" value="Send">
        </form>
    </body>
</html>
