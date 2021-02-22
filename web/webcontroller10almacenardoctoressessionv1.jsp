<%-- 
    Document   : newjspwebcontroller10almacenardoctoressessionv1
    Created on : 03-feb-2021, 4:05:55
    Author     : lscar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controllerhospital" class="controllers.ControllerHospital" scope="request"/>

<%controllerhospital.setSession(session);%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 style="color:red">Almacenar doctores v1</h1>
        <a href="webcontroller10mostrardoctoressessionv1.jsp">
            Mostrar doctores session
        </a>
        <%
        String iddoctor = request.getParameter("iddoctor");
        if (iddoctor != null){
            //ALMACENARLO EN SESSION
            controllerhospital.almacenarDoctorSession(iddoctor);
        }
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>Apellido</th>
                    <th>Especialidad</th>
                    <th>Salario</th>
                    <th>Hospital</th>
                </tr>
            </thead>
            <tbody>
                <%=controllerhospital.getFilasDoctores()%>
            </tbody>
        </table>   
    </body>
</html>
 