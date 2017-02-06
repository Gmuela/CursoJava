<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registro Contacto</title>
<link rel="stylesheet" href="resources/css/estilos.css">
</head>
<body>
<header id="Cabecera">
		<img id="logo" src="resources/imgs/logo.png">
			<p id="titulo">"AGENDA SPRING MVC"</p>
		</header>
		<section id="Cuerpo">
<form action="contactos.do" method="post">
    <fieldset>
        <legend>Añadir Contacto</legend>
        <label for="nombre">Nombre:</label><input type="text" name="nombre" id="nombre">
        <label for="apellidos">Apellidos:</label><input type="text" name="apellidos" id="apellidos">
        <label for="dni">DNI:</label><input type="text" name="dni" id="dni">
        <label for="fechaNacimiento">FechaNacimiento:</label><input type="text" name="fechaNacimiento"                                                     id="fechaNacimiento">
        <label for="telefono">Teléfono:</label><input type="text" name="telefono" id="telefono">
        <div class="botones">
            <button class="myButton" type='submit' name='button' value='add'>Añadir Contacto</button>
        </div>
    </fieldset>
  
</form>
  </section>
</body>
</html>