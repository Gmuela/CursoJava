<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/estilos.css">
</head>
<body>
<!--  <c:set var="contacto" value="${sessionScope.contactoModificar}" scope="page"/> -->
<fieldset>
    <legend>Modificar Contacto</legend>
    <form action='modificarContacto.do' method='post'>
        <label for='nombre'>Nombre:</label>
        <input type='text' name='nombre' id='nombre' value='${contacto.nombre}'>

        <label for='apellidos'>Apellidos:</label>
        <input type='text' name='apellidos' id='apellidos' value='${contacto.apellidos}'>

        <label for='dni'>DNI:</label>
        <input type='text' name='dni' id='dni' value='${contacto.dni}'>

        <label for='fechaNacimiento'>FechaNacimiento:</label>
        <input type='text' name='fechaNacimiento' id='fechaNacimiento' value='${contacto.fechaNacimiento}'>

        <label for='telefono'>Teléfono:</label>
        <input type='text' name='telefono' id='telefono' value='${contacto.telefono}'>

        <div class='botones'>
            <button type='submit' class='myButton' name='button' value='modify'>Modificar Contacto</button>
        </div>
    </form>
</fieldset>
</body>
</html>