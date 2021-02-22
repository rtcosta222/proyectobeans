<%-- 
    Document   : webcontroller01Departamentos
    Created on : 27-ene-2021, 17:44:27
    Author     : lscar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controller01departamentos" class="controllers.ControllerDepartamentos" scope="request"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MVC01</title>
    </head>
    <body>
        <h1>Departamentos Controller</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Número</th>
                    <th>Nombre</th>
                    <th>Localidad</th>
                </tr>
            </thead>
            <tbody>
                <%=controller01departamentos.getTablaDepartamentos()%>
            </tbody>
        </table>
    </body>
</html>
