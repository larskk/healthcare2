<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <%@page import="java.util.List, entity.User, data.UserManager" %>
        <% User bruger = (User)session.getAttribute("user"); %>
        <% if (bruger == null) { %>
        Du skal først logge ind <a href="login.jsp">Gå til login siden</a>
        <% } else { %>
        <h2><Brugere></h2>
        <table>
            <thead><tr><th>Fornavn</th><th>Efternavn</th><th>Email</th><th>Telefonnummer</th><th>Rolle</th></tr></thead>
            <tbody>
                <% List<User> users = UserManager.getAllUsers();
                        for (User user : users) {
                            out.println("<tr>"
                                + "<td>" + user.getFirstName() + "</td>"
                                + "<td>" + user.getLastName() + "</td>"
                                + "<td>" + user.getEmail() + "</td>"
                                + "<td>" + user.getPhone() + "</td>"
                                + "<td>" + user.getRole() + "</td>"
                                + "</tr>");
                        }
                    }
                %>
            </tbody>
        </table>
    </body>
</html>
