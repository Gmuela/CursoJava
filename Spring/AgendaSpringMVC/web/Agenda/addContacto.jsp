<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JContacts</title>
    <link rel='stylesheet' type='text/css' href='/Resources/cssTable.css'/>
    <link rel='stylesheet' type='text/css' href='/Resources/css.css'/>
</head>
<body>
<form action="/contactos" method="post">
    <fieldset>
        <legend>Añadir Contacto</legend>
        <label for="nombre">Nombre:</label><input type="text" name="nombre" id="nombre">
        <label for="apellidos">Apellidos:</label><input type="text" name="apellidos" id="apellidos">
        <label for="dni">DNI:</label><input type="text" name="dni" id="dni">
        <label for="fechaNacimiento">FechaNacimiento:</label><input type="text" name="fechaNacimiento"
                                                                    id="fechaNacimiento">
        <label for="telefono">Teléfono:</label><input type="text" name="telefono" id="telefono">
        <div class="botones">
            <button class="myButton" type='submit' name='button' value='add'>Añadir Contacto</button>
        </div>
    </fieldset>
</form>
</body>
</html>