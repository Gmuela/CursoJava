<%@ page import="Beans.Contacto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JContacts</title>
    <link rel='stylesheet' type='text/css' href='/Resources/css.css' />
    <link rel='stylesheet' type='text/css' href='/Resources/cssTable.css' />
</head>
<body>
<%Contacto contacto = (Contacto) session.getAttribute("contactoModificar");%>
<fieldset>
    <legend>Modificar Contacto</legend>
    <form action='/modificarContacto' method='post'>
        <label for='nombre'>Nombre:</label>
        <input type='text' name='nombre' id='nombre' value='<%=contacto.getNombre()%>'>

        <label for='apellidos'>Apellidos:</label>
        <input type='text' name='apellidos' id='apellidos' value='<%=contacto.getApellidos()%>'>

        <label for='dni'>DNI:</label>
        <input type='text' name='dni' id='dni' value='<%=contacto.getDni()%>'>

        <label for='fechaNacimiento'>FechaNacimiento:</label>
        <input type='text' name='fechaNacimiento' id='fechaNacimiento' value='<%=contacto.getFechaNacimiento()%>'>

        <label for='telefono'>Teléfono:</label>
        <input type='text' name='telefono' id='telefono' value='<%=contacto.getTelefono()%>'>

        <div class='botones'>
            <button type='submit' class='myButton' name='button' value='modify'>Modificar Contacto</button>
        </div>
    </form>
</fieldset>
</body>
</html>
