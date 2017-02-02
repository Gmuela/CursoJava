<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spt" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Búsqueda Ofertas</title>
</head>
<body>
<spf:form modelAttribute="busquedaOferta" method="post">
    <spt:message code="label.Price"/><br>
    <spf:input path="precio"/>
    <spf:errors path="precio"/><br>
    <spt:message code="label.Nights"/><br>
    <spf:select path="numNoches">
        <spf:option value="1">1</spf:option>
        <spf:option value="2">2</spf:option>
        <spf:option value="3">3</spf:option>
        <spf:option value="4">4</spf:option>
        <spf:option value="5">5</spf:option>
    </spf:select><br>
    <button type="submit">Enviar</button>
</spf:form>
</body>
</html>