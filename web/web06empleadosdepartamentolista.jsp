<%-- 
    Document   : web06empleadosdepartamentolista
    Created on : 26-ene-2021, 20:15:31
    Author     : lscar
--%>    
<%-- 
    Document   : web05EmpleadosDepartamento
    Created on : 26-ene-2021, 16:54:24
    Author     : lscar
    Supuesto   : Bean05EmpleadosDepartamento
                 Web05EmpleadosDepartamento
                 Al iniciar la página, dibujamos una lista con los departamentos. 
                 Cuando seleccionemos un departamento, mostramos sus empleados.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="bean06" class="beans.Bean06EmpleadosDepartamentoLista" scope="request"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Empleados.Departamentos</title>
    </head>
    <body>
        <h1>Empleados por Departamento - Lista</h1>
        <ul>
            <%=bean06.getDepts()%>
        </ul>
    <%  String z_ui = request.getParameter("deptno");
        if (z_ui != null) {
            int z_ui_deptno = Integer.parseInt(z_ui);
    %>      <table border="1">
                <thead><tr><th>APELLIDO</th><th>OFICIO</th><th>SALARIO</th></tr></thead>
                <tbody>
                    <%=bean06.getEmp(z_ui_deptno)%>
                </tbody>
            </table>
    <%  }
    %>  
    </body>
</html>


