<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form action="login" method="post">
        <label for="nombre">Nombre </label><input type="text" name="nombre" id="nombre">
        <label for="nombre">Edad </label><input type="text" name="edad" id="edad">
        <button type="submit">Login</button>
    </form>
    <s:actionerror/>
</body>
</html>
