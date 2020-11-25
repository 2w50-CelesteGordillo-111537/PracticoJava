<%-- 
    Document   : listadoAlumnos
    Created on : 03/11/2020, 01:06:29
    Author     : desi
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado de Alumnos</h1>
        <table border="1">
            <tr><th>Apellido</th><th>Nombre</th><th>Telefono</th><th>Email</th><th>Sexo</th></tr>
                    <c:forEach items="${ alumnos }" var="item">
                <tr><td>${ item.apellido }</td><td> ${ item.nombre }</td><td> ${ item.telefono }</td><td> ${ item.email }</td><td> ${ item.descripcion }</td></tr>
            </c:forEach>
        </table>
    </body>
</html>
