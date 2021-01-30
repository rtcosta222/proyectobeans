<%-- 
    Document   : webcontroller052modificardepartamentos
    Created on : 28-ene-2021, 20:38:28
    Author     : lscar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controllerdepartamentos" class="controllers.Controller01Departamentos" scope="request"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MVC03</title>
    </head>
    <body>
        <h1>Modificar Departamento</h1>
        
        <table border="1">
            <theader>
                <tr><td>DEPT_NO</td><td>DEPT_NOMBRE</td><td>LOCALIDAD</td></tr>
            </theader>
            <tbody>
                <%=controllerdepartamentos.getTablaEdicionDepartamentos()%>
            </tbody>
        </table>
        <script src="js/jquery-3.5.1.min.js" type="text/javascript"></script>
        <script>
            $(document).ready(function() {
                $("#btn").click(function(event){
                    if (confirm(“¿Seguro que quiere borrar hospital?")) {
                    // Go ahead
                    } else {
                        e.preventDefault(); // prevents default
                    }
                });
            });
        </script>
    </body>
</html>
