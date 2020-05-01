<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Brugere</title>
    <link rel="stylesheet" type="text/css" href="style.css">
  </head>
  <body>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <c:if test = "${user == null}">
      <p>Du skal først logge ind <a href="login.jsp">Gå til login siden</a></p>
    </c:if>

    <c:if test="${user != null}">
      <h2>Brugere</h2>

      <table>
        <thead>
          <tr>
            <th>Fornavn</th>
            <th>Efternavn</th>
            <th>Email</th>
            <th>Telefonnummer</th>
            <th>Rolle</th>
          </tr>
        </thead>
        
        <tbody>
          <c:forEach var="user" items="${users}">
            <tr>
              <td>${user.firstName}</td>
              <td>${user.lastName}</td>
              <td>${user.phone}</td>
              <td>${user.email}</td>
              <td>${user.role}</td>
            </tr>
          </c:forEach>
        </tbody>
        
      </table>
    </c:if>
  </body>
</html>
