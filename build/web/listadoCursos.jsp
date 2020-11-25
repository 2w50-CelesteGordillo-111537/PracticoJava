<%-- 
    Document   : listadoCursos
    Created on : 03/11/2020, 08:59:20
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
        <h1>Listado de Cursos</h1>
        <table>
            <tr><th>Nombre</th><th>Precio Total</th><th>Duracion</th><th>Modalidad</th><th>Tipo Curso</th><th>Fecha Inicio</th><th>Descripcion</th></tr>
                    <c:forEach items="${ lista }" var="item">
                <tr><td>${ item.nombre }</td><td> ${ item.precioTotal }</td><td> ${ item.duracion }</td><td> ${ item.modalidad }</td><td> ${ item.tipoCurso }</td><td> ${ item.fechaInicio }</td><td> ${ item.descripcion }</td></tr>
            </c:forEach>
        </table>
    </body>
</html>
