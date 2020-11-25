<%-- 
    Document   : altaCursos
    Created on : 03/11/2020, 10:37:23
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
        <h1>Hello World!</h1>
         <form action="/Parcial2_AcademiaProg/AltaCursoServlet" method="post">
                    <p>
                        <label for="txtNombreCurso">Curso</label>
                        <input type="text" name="txtNombreCurso"/>
                    </p>
                    <p>
                        <label for="txtPrecio">Precio Total</label>
                        <input type="number" name="txtPrecio"/> 
                    </p>
                     <p>
                        <label for="txtDuracion">Duracion</label>
                        <input type="text" name="txtTelefono"/> 
                    </p>
                     <p>
                        <label for="cboModalidades">Modalidad</label>
                        <select name="cboModalidades">
                            <c:forEach var="t" items="${lista1}">
                                <option value="${t.idModalidad}">${t.descripcion}</option>
                            </c:forEach>
                            
                        </select>
                     <p>
                     <p>
                        <label for="cboTipoCursos">Tipo Curso</label>
                        <select name="cboTipoCursos">
                            <c:forEach var="t" items="${lista2}">
                                <option value="${t.idTipoCurso}">${t.descripcion}</option>
                            </c:forEach>
                            
                        </select>
                        
                    </p>
                     <p>
                        <label for="txtFecha">Fecha Inicio</label>
                        <input type="text" name="txtFecha"/> 
                    </p>
                     <p>
                        <label for="txtDescripcion">Descripcion</label>
                        <input type="text" name="txtDescripcion"/> 
                    </p>

                        <input type="submit" value="Aceptar" />
                </form>
    </body>
</html>
