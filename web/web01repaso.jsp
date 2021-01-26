<%-- 
    Document   : web01repaso
    Created on : 26-ene-2021, 0:45:31
    Author     : lscar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="tiposaludo" class="beans.Beans01Repaso" scope="request"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Primer Ejemplo Repaso</title>
    </head>
    <body>
        <h1>Primer Ejemplo - Repaso</h1>
        <%=tiposaludo.getSaludo()%>
        <%=tiposaludo.getSaludoPersonal()%>
    </body>
</html>
