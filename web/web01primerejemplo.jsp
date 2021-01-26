<%-- 
    Document   : web01primerejemplo
    Created on : 25-ene-2021, 17:47:43
    Author     : lscar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="bean01" class="beans.Bean01PrimerEjemplo" scope="request"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP JavaBeans</title>
    </head>
    <body>
        <h1>Primer Java Beans</h1>
        <%=bean01.getSaludo()%>
        <%=bean01.getSaludoPersonal()%>
    </body>
</html>
