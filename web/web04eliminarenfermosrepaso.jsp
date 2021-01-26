<%-- 
    Document   : web04eliminarenfermosrepaso
    Created on : 26-ene-2021, 2:25:18
    Author     : lscar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="tablaenfermo" class="beans.Bean04EliminarEnfermosRepaso" scope="request"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestión - Tabla Enfermos</title>
    </head>
    <body>        
        <h1>Borrar enfermos</h1>
        <form method="get">
            <label>Intro num. inscripcion enfermo</label>
            <input type="number" name="cajains"/>
            <button type="submit">Borrar</button>
        </form>
    <%  String dato = request.getParameter("cajains");
        if (dato != null) {
            int inscripcion = Integer.parseInt(dato);
            tablaenfermo.borrarEnfermo(inscripcion);
        }
    %>  <%=tablaenfermo.mostrarEnfermos()%>   
    </body>
</html>
