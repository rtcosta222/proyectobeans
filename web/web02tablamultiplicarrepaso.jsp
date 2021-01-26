<%-- 
    Document   : web02tablamultiplicarrepaso
    Created on : 26-ene-2021, 1:05:52
    Author     : lscar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="multi" class="beans.Bean02TablaMultiplicarRepaso" scope="request"/>
             
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tabla de Multiplicar</title>
    </head>
    <body>
        <h1>Resultado</h1>
        <form>
            <label>Introduzca num.: </label>
            <input type="number" name="cjnum"/>
            <button type="submit">Crear tabla</button>
        </form>
    <%  String num = request.getParameter("cjnum");
        if (num != null) {
            int numint = Integer.parseInt(num);
    %>      <%=multi.multiplicar(numint)%>;
    <%  }
    %>    
    </body>
</html>
