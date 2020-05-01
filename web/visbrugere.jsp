<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Brugere</title>
    <link rel="stylesheet" type="text/css" href="style.css">
  </head>
  <body>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:choose>

      <c:when test = "${user == null}">
        <p>Du skal f�rst logge ind <a href="login.jsp">G� til login siden</a></p>
      </c:when>

      <c:when test= "${user.role.equals('Administrator')}">
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
      </c:when>
      <c:otherwise>
        <p>Du har desv�rre ikke administrator-rettigheder!</p>
      </c:otherwise>
    </c:choose>
  </body>
</html>
