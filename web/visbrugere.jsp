<%-- 
    Document   : minside
    Created on : 02-12-2018, 12:18:21
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
        <%@page import="java.util.List, entity.User, data.UserManager" %>
         <h2><Brugere></h2>
         <table>
            <thead><tr><th>Fornavn</th><th>Efternavn</th><th>Telefonnummer</th><th>Rolle</th></tr></thead>
            <tbody>
           <% List<User> users = UserManager.getAllUsers(); 
            for (User user : users) {
                out.println("<tr>" +
                    "<td>" + user.getFirstName() + "</td>" +
                    "<td>" + user.getLastName()  + "</td>" +
                    "<td>" + user.getPhone()     + "</td>" +
                    "<td>" + user.getRole()      + "</td>" +
                    "</tr>");
            }
            %>
            </tbody>
        </table>
    </body>
</html>
