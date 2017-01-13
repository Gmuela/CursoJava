<%@ page import="java.util.ArrayList" %>
<%@ page import="Beans.Contacto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JContacts</title>
    <link rel='stylesheet' type='text/css' href='/Resources/css.css' />
    <link rel='stylesheet' type='text/css' href='/Resources/cssTable.css' />
</head>
<body>
<fieldset>
    <legend>Datos Usuario</legend>
<span class="nombreUsuario">Usuario: </span><%=session.getAttribute("nombreUsuario")%>
<div class='registerLink'>
    <a href='/logout'>Logout</a>
</div>
</fieldset>
<div>
    <form action='/contactos' method='post'>
        <div class='select-style'>
            <select name='mes'>
                <option value='/00/' selected>Todos</option>
                <option value='/01/'>Enero</option>
                <option value='/02/'>Febrero</option>
                <option value='/03/'>Marzo</option>
                <option value='/04/'>Abril</option>
                <option value='/05/'>Mayo</option>
                <option value='/06/'>Junio</option>
                <option value='/07/'>Julio</option>
                <option value='/08/'>Agosto</option>
                <option value='/09/'>Septiembre</option>
                <option value='/10/'>Octubre</option>
                <option value='/11/'>Noviembre</option>
                <option value='/12/'>Diciembre</option>
            </select>
        </div>
        <button type='submit' class='myButton' name='button' value='filter'>Filtrar</button>
    </form>
</div>

<table>
    <tr>
        <th>Nombre</th>
        <th>Apellidos</th>
        <th>DNI</th>
        <th>Fecha de nacimiento</th>
        <th>Teléfono</th>
        <th>Modificar</th>
        <th>Borrar</th></tr>
    <tr>
    <%
        ArrayList<Contacto> listaContactos = (ArrayList<Contacto>)session.getAttribute("listaContactos");
        for (Contacto contacto : listaContactos) {
    %>
            <td><%=contacto.getNombre()%></td>
            <td><%=contacto.getApellidos()%></td>
            <td><%=contacto.getDni()%></td>
            <td><%=contacto.getFechaNacimiento()%></td>
            <td><%=contacto.getTelefono()%></td>
            <td>
                <form action='/modificarContacto' method='get'>
                    <div class='botones'>
                        <button type='submit' class='modifyButton'>
                            <img src='/Resources/modify.png' class='iconM'>
                        </button>
                    </div>
                    <input type='hidden' name='idContacto' value='<%=contacto.getId()%>'/>
                </form>
            </td>
            <td>
                <form action='/contactos' method='post'>
                    <div class='botones'>
                        <button type='submit' class='removeButton' name='button' value='remove'>
                            <img src='/Resources/remove.png' class='iconR'>
                        </button>
                    </div>
                    <input type='hidden' name='idContacto' value='<%=contacto.getId()%>'/>
                </form>
            </td>
        </tr>
    <%
        };
    %>

</table>
<a class='linkEspecial' href='/Agenda/addContacto.html'>
    <button class='myButton'>Añadir</button>
</a>
</body>
</html>
