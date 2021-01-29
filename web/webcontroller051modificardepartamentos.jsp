<%-- 
    Document   : webcontroller051modificardepartamentos
    Created on : 28-ene-2021, 18:01:22
    Author     : lscar
    Supuesto   : Versión 02: Desplegable para modificar los departamentos. Cuando 
                 pulsemos sobre el botón "Mostrar detalles", mostramos un 
                 formulario con los datos del departamento y un botón para modificar.
                 Cuando pulsemos en modificar. Mostramos la tabla departamentos 
                 todo el tiempo.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controllerdepartamentos" class="controllers.Controller01Departamentos" scope="request"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MVC05V1</title>
    </head>
    <body>
        <h1>Modificar Departamento</h1>
        <form method="get">
            <label>Insertar dept no.: </label>
            <input type="number" name="cajadeptnum" required><br/>
            <label>Insertar nombre del dept: </label>
            <input type="text" name="cajadeptnom" required><br/>
            <label>Insertar localidad del dept: </label>
            <input type="TEXT" name="cajadeptloc" required>
            <button type="submit">Modificar departamento</button><br/>
        </form>
        
    <%  String dato = request.getParameter("cajadeptnum");
        if (dato != null) {
            int z_deptnum = Integer.parseInt(dato); 
            String z_deptnom = request.getParameter("cajadeptnom");
            String z_deptloc = request.getParameter("cajadeptloc");
            controllerdepartamentos.modificarDepartamento(z_deptnum, z_deptnom, z_deptloc);
        }
    %>
        <table border="1">
            <theader>
                <tr><td>DEPT_NO</td><td>DEPT_NOMBRE</td><td>LOCALIDAD</td></tr>
            </theader>
            <tbody>
                <%=controllerdepartamentos.getTablaDepartamentos()%>
            </tbody>
        </table>
    </body>
</html>
