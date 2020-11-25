<%-- 
    Document   : altaAlumno
    Created on : 03/11/2020, 01:06:50
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
        <h1>Alta Alumno</h1>
        <form action="/Parcial2_AcademiaProg/AltaAlumnoServlet" method="post">
                    <p>
                        <label for="txtApellido">Apellido</label>
                        <input type="text" name="txtApellido"/>
                    </p>
                    <p>
                        <label for="txtNombre">Nombre</label>
                        <input type="text" name="txtNombre"/> 
                    </p>
                     <p>
                        <label for="txtTelefono">Telefono</label>
                        <input type="text" name="txtTelefono"/> 
                    </p>
                     <p>
                        <label for="txtEmail">Email</label>
                        <input type="email" name="txtEmail"/> 
                    </p>                      
                    <p>
                        <label for="cboTipoSexos">Sexo</label>
                        <select name="cboTipoSexos">
                            <c:forEach var="t" items="${lista}">
                                <option value="${t.idSexo}">${t.descripcion}</option>
                            </c:forEach>
                            
                        </select>
                        
                    </p>
                   
                       
                      
                        <input type="submit" value="Aceptar" />
                </form>
    </body>
</html>
