<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <p>Velkommen ${user.firstName}, du er nu logget ind.</p>
    <p>Rolle: ${user.role}</p>
    <c:if test="${user.role == 'Administrator'}">
      <p><a href="visbrugere.jsp">Vis brugere</a></p>
    </c:if>
    <p><a href="booktid.jsp">Book en tid</a></p>

    <h2>Mine tider</h2>
  </body>
</html>
