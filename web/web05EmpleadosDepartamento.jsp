<%-- 
    Document   : web05EmpleadosDepartamento
    Created on : 26-ene-2021, 16:54:24
    Author     : lscar
    Supuesto   : Bean05EmpleadosDepartamento
                 Web05EmpleadosDepartamento
                 Al iniciar la página, dibujamos un desplegable <select> con 
                 los departamentos. Cuando seleccionemos un departamento, 
                 mostramos sus empleados.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="deptemp" class="beans.Bean05EmpleadosDepartamento" scope="request"/> 

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Empleados.Departamentos</title>
    </head>
    <body>
        <h1>Empleados por Departamento</h1>
        <form method="post">
            <label>Elija Dept.</label>
            <select name="deptno"><%=deptemp.getDepts()%></select>
            <button type="submit">Elegir</button>
        </form>

    <%  String z_ui = request.getParameter("deptno");
        if (z_ui != null) {
            int z_ui_deptno = Integer.parseInt(z_ui);
    %>      <table border='1'>
                <thead><tr><th>APELLIDO</th><th>OFICIO</th><th>SALARIO</th></tr></thead>
                <tbody><%=deptemp.getEmp(z_ui_deptno)%></tbody>
            </table>
    <%  }
    %>  
    </body>
</html>
