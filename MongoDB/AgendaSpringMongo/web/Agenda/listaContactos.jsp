<%@ taglib prefix="sptag" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="format" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title><sptag:message code="title"/></title>
    <link rel='stylesheet' type='text/css' href=<sptag:message code="cssTable"/>/>
    <link rel='stylesheet' type='text/css' href=<sptag:message code="css"/>/>
</head>
<body>
<fieldset>
    <legend><sptag:message code="legend.userData"/></legend>
<span class="nombreUsuario"><sptag:message code="label.contactName"/> </span><core:out value="${sessionScope.usuario.nombre}"/>
<div class='registerLink'>
    <a href='/logout'><sptag:message code="logout"/></a>
</div>
</fieldset>
<div>
    <form action='${pageContext.request.contextPath}/filterFecha.do' method='post'>
        <div class='select-style'>
            <select name='mes'>
                <option value='00' selected><sptag:message code="option.all"/></option>
                <option value='01'><sptag:message code="option.January"/></option>
                <option value='02'><sptag:message code="option.February"/></option>
                <option value='03'><sptag:message code="option.March"/></option>
                <option value='04'><sptag:message code="option.April"/></option>
                <option value='05'><sptag:message code="option.May"/></option>
                <option value='06'><sptag:message code="option.June"/></option>
                <option value='07'><sptag:message code="option.July"/></option>
                <option value='08'><sptag:message code="option.August"/></option>
                <option value='09'><sptag:message code="option.September"/></option>
                <option value='10'><sptag:message code="option.October"/></option>
                <option value='11'><sptag:message code="option.November"/></option>
                <option value='12'><sptag:message code="option.December"/></option>
            </select>
        </div>
        <button type='submit' class='myButton' name='button' value='filter'><sptag:message code="button.filter"/></button>
    </form>
</div>

<table>
    <tr>
        <th><sptag:message code="label.contactName"/></th>
        <th><sptag:message code="label.contactSurname"/></th>
        <th><sptag:message code="label.contactDni"/></th>
        <th><sptag:message code="label.contactDate"/></th>
        <th><sptag:message code="label.contactTelephone"/></th>
        <th><sptag:message code="label.contactModify"/></th>
        <th><sptag:message code="label.contactRemove"/></th></tr>
    <tr>
    <core:if test="${fn:length(sessionScope.listaContactos) == 0}">
        <tr><td class="noContacts" colspan="7"><sptag:message code="noContactsFound"/></td></tr>
    </core:if>
    <core:if test="${fn:length(sessionScope.listaContactos) > 0}">
        <core:forEach var="contacto" items="${sessionScope.listaContactos}">
            <td><core:out value="${contacto.nombre}"/></td>
            <td><core:out value="${contacto.apellidos}"/></td>
            <td><core:out value="${contacto.dni}"/></td>
            <td><core:out value="${contacto.fechaNacimiento}"/></td>
            <td><core:out value="${contacto.telefono}"/></td>
            <td>
                <form action='${pageContext.request.contextPath}/redirectToUpdateForm.do' method='post'>
                    <div class='botones'>
                        <button type='submit' class='modifyButton'>
                            <img src='${pageContext.request.contextPath}/Resources/modify.png' class='iconM'>
                        </button>
                    </div>
                    <input type='hidden' name='idContacto' value='${contacto._id}'/>
                </form>
            </td>
            <td>
                <form action='${pageContext.request.contextPath}/borrarContacto.do' method='post'>
                    <div class='botones'>
                        <button type='submit' class='removeButton' name='button' value='remove'>
                            <img src='${pageContext.request.contextPath}/Resources/remove.png' class='iconR'>
                        </button>
                    </div>
                    <input type='hidden' name='idContacto' value='${contacto._id}'/>
                </form>
            </td>
    <tr>
        </core:forEach>
    </core:if>
</table>
<a class='linkEspecial' href='${pageContext.request.contextPath}/Agenda/addContacto.jsp'>
    <button class='myButton'><sptag:message code="button.addContact"/></button>
</a>
</body>
</html>
