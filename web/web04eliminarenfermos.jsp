<%-- 
    Document   : web04eliminarenfermos
    Created on : 25-ene-2021, 20:16:33
    Author     : lscar
    Supuesto   : web04eliminarenfermos.jsp
                 Bean04EliminarEnfermos.java
                 Dibujar todos los enfermos al iniciar la página.
                 Una caja para escribir la inscripción.
                 Si pulsamos sobre un botón eliminar, borramos al enfermo.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="tablaenfermos" class="beans.Bean04EliminarEnfermos" scope="request"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tabla Enfermo - Eliminar</title>
    </head>
    <body>
        <h1>Eliminar Enfermos</h1><br/>
            <form method="post">
                <label>Eliminar enfermo no.: </label>
                <input type="number" name="cajains" required>
                <button type="submit">Eliminar enfermos</button>
            </form>
                
        <%  String dato = request.getParameter("cajains");
            if (dato != null) {
                int ins = Integer.parseInt(dato);
                tablaenfermos.eliminarEnfermo(ins);
            }
        %>
        <%=tablaenfermos.getTablaEnfermo()%>
    </body>
</html>
