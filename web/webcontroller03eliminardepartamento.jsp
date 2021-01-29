<%-- 
    Document   : webcontroller03eliminardepartamento
    Created on : 27-ene-2021, 20:31:06
    Author     : lscar
    Supuesto   : 1) Mostramos una tabla con los departamentos.
                 2) Tendremos una caja para escribir el número y eliminar el 
                    departamento.
                 Para dibujar los detalles de un departamento, que nos tiene que 
                 devolver el Repository? Departamento. Para dibujar la tabla, 
                 que nos tiene que devolver el Repository???  ArrayList. Para 
                 eliminar un departamento, que nos tiene que devolver el 
                 Repository? NADA  void
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controllerdepartamentos" class="controllers.Controller01Departamentos" scope="request"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MCV03</title>
    </head>    
    <body>
        <h1>Eliminar Departamento</h1>
        <form method="get">
            <label>Eliminar dept no.: </label>
            <input type="number" name="cajadept" required>
            <button type="submit">Eliminar departamento</button>
        </form>
        
    <%  String dato = request.getParameter("cajadept");
        if (dato != null) {
            int z_deptno = Integer.parseInt(dato); 
            controllerdepartamentos.eliminarDepartamento(z_deptno);
        }
    %>
        <table border="1">
            <theader>
                <tr><td>DEPT_NO</td><td>DEPT_NOMBRE</td><td>LOCALIDAD</td></tr>
            </theader>
            <tbody>
                <%=controllerdepartamentos.getTablaDepartamentos()%>
            </tbody>
        </table>
    </body>
</html>
