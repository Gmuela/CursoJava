<%@ taglib prefix="sptag" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title><sptag:message code="title"/></title>
    <link rel='stylesheet' type='text/css' href=<sptag:message code="cssTable"/>/>
    <link rel='stylesheet' type='text/css' href=<sptag:message code="css"/>/>
</head>
<body>
<form action="${pageContext.request.contextPath}/crearContacto.do" method="post">
    <fieldset>
        <legend><sptag:message code="legend.addContact"/></legend>
        <label for="nombre"><sptag:message code="label.contactName"/></label>
        <input type="text" name="nombre" id="nombre">

        <label for="apellidos"><sptag:message code="label.contactSurname"/></label>
        <input type="text" name="apellidos" id="apellidos">

        <label for="dni"><sptag:message code="label.contactDni"/></label>
        <input type="text" name="dni" id="dni">

        <label for="fechaNacimiento"><sptag:message code="label.contactDate"/></label>
        <input type="date" name="fechaNacimiento" id="fechaNacimiento">

        <label for="telefono"><sptag:message code="label.contactTelephone"/></label>
        <input type="text" name="telefono" id="telefono">

        <div class="botones">
            <button class="myButton" type='submit' name='button'><sptag:message code="button.addContact"/></button>
        </div>
    </fieldset>
</form>
</body>
</html>