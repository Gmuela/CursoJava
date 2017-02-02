<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sptag" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><sptag:message code="title"/></title>
    <link rel='stylesheet' type='text/css' href=<sptag:message code="cssTable"/> />
    <link rel='stylesheet' type='text/css' href=<sptag:message code="css"/> />
</head>
<body>
<c:set var="contacto" value="${sessionScope.contactoModificar}" scope="page"/>
<fieldset>
    <legend><sptag:message code="legend.updateContact"/></legend>
    <form action='/updateContacto.do' method='post'>
        <label for='nombre'><sptag:message code="label.contactName"/></label>
        <input type='text' name='nombre' id='nombre' value='${contacto.nombre}'>

        <label for='apellidos'><sptag:message code="label.contactSurname"/></label>
        <input type='text' name='apellidos' id='apellidos' value='${contacto.apellidos}'>

        <label for='dni'><sptag:message code="label.contactDni"/></label>
        <input type='text' name='dni' id='dni' value='${contacto.dni}'>

        <label for='fechaNacimiento'><sptag:message code="label.contactDate"/></label>
        <input type='date' name='fechaNacimiento' id='fechaNacimiento' value='${contacto.fechaNacimiento}'>

        <label for='telefono'><sptag:message code="label.contactTelephone"/></label>
        <input type='text' name='telefono' id='telefono' value='${contacto.telefono}'>

        <div class='botones'>
            <button type='submit' class='myButton' name='button'><sptag:message code="button.update"/></button>
        </div>
    </form>
</fieldset>
</body>
</html>
