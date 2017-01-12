<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Hola</title>
</head>
<body>
<%
    /*String nombre = request.getParameter("nombre");
    String age = (String)request.getAttribute("age");
    String date = (String)request.getAttribute("date");*/

    String nombre = (String)session.getAttribute("nombre");
    String age = (String)session.getAttribute("age");
    String date = (String)session.getAttribute("date");
    String message = "Hola " + nombre + " tu edad es " + age + " porque naciste en la siguiente fecha: " + date;
%>
<%=message%>
</body>
</html>