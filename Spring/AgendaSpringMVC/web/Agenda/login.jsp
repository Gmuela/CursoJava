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
<fieldset>
    <legend>Login</legend>
    <form action="/login" method="post">
        <label for="nombre">Nombre: </label>
        <input type="text" name="nombre" id="nombre">
        <label for="password">Contraseña: </label>
        <input type="password" name="password" id="password">
        <button type="submit" class="myButton">Entrar</button>

    </form>
    <div class="registerLink"><a href="registro.jsp">¿Aún no tienes cuenta?, pincha aquí</a></div>
</fieldset>
</body>
</html>