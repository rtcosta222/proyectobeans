<%-- 
    Document   : webcontroller06eliminardepttabla
    Created on : 29-ene-2021, 17:13:59
    Author     : lscar
    Supuesto   : 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controllerdepartamentos" class="controllers.Controller01Departamentos" scope="request"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MVC04</title>
    </head>
    <body>
    <%  String dato = request.getParameter("eliminar");
        if (dato != null) {
            int z_deptno = Integer.parseInt(dato); 
            controllerdepartamentos.eliminarDepartamento(z_deptno);
        }
    %>
        <h1>Eliminar Dept.</h1>
        <form>
            <table border="1">
                <thead>
                    <tr>
                        <th>Número </th>
                        <th>Nombre </th>
                        <th>Localidad</th>
                    </tr>
                </thead>
                <tbody>
                    <%=controllerdepartamentos.getTablaEliminarDepartamento()%>
                </tbody>
            </table>
        </form>
        <script src="js/jquery-3.5.1.min.js" type="text/javascript"></script>
        <script>
            $(document).ready(function(){
                $("#formeliminar").submit(function() {
                    var respuesta = confirm("Desea eliminar el departamento?");
                    if (respuesta == true) {
                        return false;
                        terminar
                    }
                });
            });
        </script>            
        </script>
                    
    </body>
</html>
