<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>K ase</title>
</head>
<body>
<jsp:useBean id="mensaje" class="Beans.Mensaje"/>
<c:forEach var="texto" items="${mensaje.listaTexto}">
    <p><c:out value="${texto}"/></p>
</c:forEach>
<c:out value="${fn:length(mensaje.listaTexto)}"/>
<c:if test="${fn:contains(mensaje.listaTexto, 'Hola')}">
    <c:out value="Oieh xaval t kjo i t rebiento"/>
</c:if>
</body>
</html>
