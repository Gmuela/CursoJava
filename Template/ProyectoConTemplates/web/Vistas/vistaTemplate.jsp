<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="format" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="sptag" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="spform" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title><sptag:message code="title"/></title>
    <link rel='stylesheet' type='text/css' href=<sptag:message code="cssTable"/>/>
    <link rel='stylesheet' type='text/css' href=<sptag:message code="css"/>/>
</head>
<body>
<fieldset>
    <legend><sptag:message code="legend.register"/></legend>
    <form action="${pageContext.request.contextPath}/nombreAccion.do" method="post">
        <label for="nombre"><sptag:message code="label.userName"/></label>
        <input type="text" name="nombre" id="nombre"/>

        <label for="email"><sptag:message code="label.email"/></label>
        <input type="text" name="email" id="email"/>

        <label for="password"><sptag:message code="label.password"/></label>
        <input type="password" name="password" id="password" />

        <button type="submit" class="myButton"><sptag:message code="button.register"/></button>
    </form>
</fieldset>
</body>
</html>
