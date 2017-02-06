<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registro Usuario</title>
<link rel="stylesheet" href="resources/css/estilos.css">
</head>
<body>
	<header id="Cabecera">
		<img id="logo" src="resources/imgs/logo.png">
		<p id="titulo">"AGENDA SPRING MVC"</p>
	</header>
	<section id="Cuerpo">
		<fieldset>
			<legend>Registro</legend>
			<form action="${pageContext.request.contextPath}/registro.do" method="post">
				<label for="nombre">Nombre: </label><input type="text" name="nombre"
					id="nombre">Password: <input type="password"
					name="password" id="password">
				<button type="submit" class="myButton">Registrarse</button>
			</form>
		</fieldset>
	</section>
</body>
</html>