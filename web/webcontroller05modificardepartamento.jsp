<%-- 
    Document   : webcontroller05modificardepartamento
    Created on : 28-ene-2021, 17:39:47
    Author     : lscar
    Supuesto   : webcontroller05modificardepartamento
                 Versiones
                 1) Tabla departamentos y cajas para modificar un nuevo 
                    departamento.
                 2) Desplegable para modificar los departamentos. Cuando pulsemos 
                    sobre el botón "Mostrar detalles", mostramos un formulario 
                    con los datos del departamento y un botón para modificar.
                    Cuando pulsemos en modificar. Mostramos la tabla 
                    departamentos todo el tiempo.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controllerdepartamentos" class="controllers.Controller01Departamentos" scope="request"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MVC05V2</title>
    </head>
    <body>
    <%  String dato = request.getParameter("cjdeptnum");
        if (dato != null) {
            int z_deptnum = Integer.parseInt(dato); 
            String z_deptnom = request.getParameter("cajadeptnom");
            String z_deptloc = request.getParameter("cajadeptloc");
            controllerdepartamentos.modificarDepartamento(z_deptnum, z_deptnom, z_deptloc);
        }
    %>
        <h1>Modificar Departamento</h1>
        <form method="post">
            <label>Departamentos: </label>
            <select name="selectdepartamento"><%=controllerdepartamentos.getSelectDepartamentos()%></select>
            <button type="submit">Ver detalles</button>
        </form><hr/>
            
    <%  dato = request.getParameter("selectdepartamento");
        if (dato != null) {
            int z_deptno = Integer.parseInt(dato);
    %>      <form method="post">
                <%=controllerdepartamentos.getFormDetallesDepartamento(z_deptno)%>
                <button type="submit">Modificar departamento</button>              
            </form><br/>
    <%  }
    %>
        <table border="1">
            <thead>
                <tr><td>DEPT_NO</td><td>DEPT_NOMBRE</td><td>LOCALIDAD</td></tr>
            </thead>
            <tbody>
                <%=controllerdepartamentos.getTablaDepartamentos()%>
            </tbody>
        </table>
    </body>
</html>
