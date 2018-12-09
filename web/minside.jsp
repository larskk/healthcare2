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
    </body>
</html>
