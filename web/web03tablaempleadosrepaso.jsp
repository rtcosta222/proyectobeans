<%-- 
    Document   : web03tablaempleadosrepaso
    Created on : 26-ene-2021, 1:43:00
    Author     : lscar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="empleado" class="beans.Bean03TablaEmpleadosRepaso" scope="request"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tabla Empleados</title>
    </head>
    <body>
        <h1>Incrementar Salarios</h1>
        <form method="post">
            <label>Introduzca incremento</label>
            <input type="number" name="cjinc"/>
            <button type="submit">Incrementar</button>
        </form>
    <%  String dato = request.getParameter("cjinc");
        if (dato != null) {
            int incsal = Integer.parseInt(dato);
            empleado.incrementarSalario(incsal);
        }
    %>  <%=empleado.mostrarEmpleados()%>
</html>

