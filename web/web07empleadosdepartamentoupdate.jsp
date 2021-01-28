<%-- 
    Document   : web07empleadosdepartamentoupdate
    Created on : 26-ene-2021, 20:39:40
    Author     : lscar
    Supuesto   : Bean07EmpleadosDepartamentoUpdate
                 web07EmpleadosDepartamentoUpdate
                 Recuperar de cada Bean (anterior) un dibujo. En el nuevo Bean, 
                 creamos un método para incrementar el salario de los empleados 
                 por un número de departamento. Queremos dibujar un desplegable 
                 con los departamentos. Una caja para el incremento. Al pulsar 
                 el botón, vemos los empleados del departamento con su incremento.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="bean05" class="beans.Bean05EmpleadosDepartamento" scope="request"/>
<jsp:useBean id="bean06" class="beans.Bean06EmpleadosDepartamentoLista" scope="request"/>
<jsp:useBean id="bean07" class="beans.Bean07EmpleadosDepartamentoUpdate" scope="request"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tablas emp/dept - Update</title>
    </head>
    <body>
        <h1>Update salario emp</h1>
        <form method="post">
            <label>Elija Dept.: </label>
            <select name="deptno"><%=bean05.getDepts()%></select><br/>
            <label>Incremento salarial: </label>
            <input type="number" name="incremento" required>
            <button type="submit">Incrementar salarios</button>
        </form>
    <%  String z_ui = request.getParameter("deptno");
        if (z_ui != null) {
            int z_ui_deptno = Integer.parseInt(z_ui);
            z_ui = request.getParameter("incremento");
            int z_ui_incr = Integer.parseInt(z_ui);
            bean07.incrementarSalarios(z_ui_deptno, z_ui_incr);
        
    %>      <table border='1'>
                <thead><tr><th>APELLIDO</th><th>OFICIO</th><th>SALARIO</th></tr></thead>
                <tbody><%=bean06.getEmp(z_ui_deptno)%></tbody>
            </table>
    <%  }
    %>
    </body>
</html>
