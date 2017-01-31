<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JContacts</title>
    <link rel='stylesheet' type='text/css' href='/Resources/css.css' />
    <link rel='stylesheet' type='text/css' href='/Resources/cssTable.css' />
</head>
<body>
<c:set var="contacto" value="${sessionScope.contactoModificar}" scope="page"/>
<fieldset>
    <legend>Modificar Contacto</legend>
    <form action='/modificarContacto' method='post'>
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
