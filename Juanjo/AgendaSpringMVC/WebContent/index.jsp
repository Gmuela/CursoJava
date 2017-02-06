<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-UTF-8">
<title>AGENDA SPRING MVC</title>
<link rel="stylesheet" href="resources/css/estilos.css">
</head>
<body>
	<header id="Cabecera">
		<img id="logo" src="resources/imgs/logo.png">
		<p id="titulo">BIENVENIDO A "AGENDA WEB JSP"</p>
	</header>
	<section id="Cuerpo">
		<h2>ENTRAR A TU AGENDA</h2>
		<fieldset>
			<legend>Login</legend>
			<form action="login.do" method="post">
				<label for="nombre">Nombre:</label>
				<input type="text" name="nombre"/>
				<label for="pass">Contraseña:</label>
				<input type="password" name="pass"/>
				<button type="submit" class="myButton">Entrar</button>
			</form>
			<div class="registerLink">
				<a href="registroUsuario.jsp">¿Aún no tienes cuenta?, pincha
					aquí</a>
			</div>
		</fieldset>
	</section>
</body>
</html>