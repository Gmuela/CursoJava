<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <ul>
  <c:forEach items="${ofertas}" var="oferta">
      <li>Hotel ${oferta.hotel}, ${oferta.numNoches} noches por solo ${oferta.precio}eur./noche</li>
  </c:forEach>
  </ul>
  </body>
</html>
