<%-- 
    Document   : web02tablamultiplicar
    Created on : 25-ene-2021, 18:14:19
    Author     : lscar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="beantabla" class="beans.Bean02TablaMultiplicar" scope="request"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tabla Multiplicar</title>
    </head>
    <body>
        <h1>Tabla multiplicar</h1>
        <form method="post">
            <label>Intro. número</label>
            <input type="number" name="cajanumero"/>
            <button type="submit">Mostrar tabla</button>
        </form>
    <%  String dato = request.getParameter("cajanumero");
        if (dato != null) {
            int numero = Integer.parseInt(dato);
    %>        <%=beantabla.getTablaMultiplicar(numero)%>
    <%  }    
    %>
    </body>
</html>
