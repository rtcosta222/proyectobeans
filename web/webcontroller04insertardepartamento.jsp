<%-- 
    Document   : webcontroller04insertardepartamento
    Created on : 28-ene-2021, 16:39:48
    Author     : lscar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controllerdepartamentos" class="controllers.ControllerDepartamentos" scope="request"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MVC04</title>
    </head>
    <body>
        <h1>Insertar Departamento</h1>
        <form method="get">
            <label>Insertar dept no.: </label>
            <input type="number" name="cajadeptnum" required><br/>
            <label>Insertar nombre del dept: </label>
            <input type="text" name="cajadeptnom" required><br/>
            <label>Insertar localidad del dept: </label>
            <input type="TEXT" name="cajadeptloc" required><br/>
            <button type="submit">Insertar departamento</button><br/>
        </form>
        
    <%  String dato = request.getParameter("cajadeptnum");
        if (dato != null) {
            int z_deptnum = Integer.parseInt(dato); 
            String z_deptnom = request.getParameter("cajadeptnom");
            String z_deptloc = request.getParameter("cajadeptloc");
            controllerdepartamentos.insertarDepartamento(z_deptnum, z_deptnom, z_deptloc);
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
