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
        
        <%@page import="entity.User" %>
        <% String message = (String)request.getAttribute("message"); %>
        <h2><%= message %></h2>
        <% User user = (User)session.getAttribute("user"); %>
         <p><% out.println(user.getEmail()); %></p>
         <ul>
            <li><a href="visbrugere.jsp">Vis brugere</a></li>
            <li><a href="booktid.jsp">Book en tid</a></li>
        </ul>
         <h2>Mine tider</h2>
    </body>
</html>
