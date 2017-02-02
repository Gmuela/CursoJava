<%@ taglib prefix="spf" uri="http://www.springframework.org/tags/form" %>
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
<fieldset>
    <legend><sptag:message code="legend.register"/></legend>
    <form action="${pageContext.request.contextPath}/registro.do" method="post">
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