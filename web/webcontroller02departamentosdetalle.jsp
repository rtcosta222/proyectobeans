<%-- 
    Document   : webcontroller02departamentosdetalle
    Created on : 27-ene-2021, 19:40:35
    Author     : lscar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controllerdept" class="controllers.Controller01Departamentos" scope="request"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MVC02</title>
    </head>
    <body>
        <h1>Detalles de Departamento - Dropdown list</h1>
        <form method="post">
            <label>Departamentos </label>
            <select name="selectdepartamento"><%=controllerdept.getSelectDepartamentos()%></select>
            <button type="submit">Ver detalle</button>
        </form>
    <%  String dato = request.getParameter("selectdepartamento");
        if (dato != null) {
            int z_deptno = Integer.parseInt(dato);
    %>      <%=controllerdept.getDetallesDepartamento(z_deptno)%>
    <%  } 
    %>
    </body>
</html>
