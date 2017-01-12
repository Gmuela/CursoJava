<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<jsp:useBean id="persona" class="beans.Persona" scope="request"/>
<jsp:setProperty name="persona" property="nombre" param="paco"/>
<form action="CalcularEdad" method="post">
    <label for="nombre">Nombre:</label><br>
    <input type="text" name="nombre" id="nombre" value="<jsp:getProperty name="persona" property="nombre"/>">
    <br>
    <label for="fechaNacimiento">Fecha de Nacimiento:</label><br>
    <input type="date" name="fechaNacimiento" id="fechaNacimiento">
    <button type="submit">Enviar</button>
</form>
</body>
</html>
