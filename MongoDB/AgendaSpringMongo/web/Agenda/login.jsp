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
    <legend><sptag:message code="legend.login"/></legend>
    <form action="${pageContext.request.contextPath}/login.do" method="post">
        <label for="nombre"><sptag:message code="label.userName"/></label>
        <input type="text" name="nombre" id="nombre">
        <label for="password"><sptag:message code="label.password"/></label>
        <input type="password" name="password" id="password">
        <button type="submit" class="myButton"><sptag:message code="button.login"/></button>

    </form>
    <div class="registerLink"><a href="registro.jsp"><sptag:message code="register.message"/></a></div>
</fieldset>
</body>
</html>