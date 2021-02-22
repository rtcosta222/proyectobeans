<%-- 
    Document   : webcontroller10mostrardoctoressessionv1
    Created on : 03-feb-2021, 4:07:28
    Author     : lscar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controllerhospital"
             class="controllers.ControllerHospital"
             scope="request"/>
<%
    controllerhospital.setSession(session);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 style="color:red">Mostrar doctores v1</h1>
        <a href="webcontroller10almacenardoctoressessionv1.jsp">
            Almacenar doctores
        </a>
        <table border="1">
            <thead>
                <tr>
                    <th>Apellido</th>
                    <th>Especialidad</th>
                    <th>Salario</th>
                </tr>
            </thead>
            <tbody>
                <%=controllerhospital.getDoctoresSession()%>        
            </tbody>
        </table>
    </body>
</html>
