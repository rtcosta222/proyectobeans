<%-- 
    Document   : webcontroller09doctoreshospital
    Created on : 01-feb-2021, 21:38:30
    Author     : lscar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controllerhospital" class="controllers.ControllerHospital" scope="request"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MCV</title>
    </head>
    <body>
        <h1>Hospitales</h1>
    <%  String ui = request.getParameter("hcdetalles");
        if (ui != null) {
            int z_hospcod = Integer.parseInt(ui);
    %>      <h2>Detalles:</h2>
            <table border="1">
                <thead><tr><th>Num de personas</th><th>Suma salarial</th><th>Media salarial</th></tr></thead>
                <tbody>
                    <%=controllerhospital.getDetallesHospital02(z_hospcod)%>
                </tbody>
            </table>
    <%  }
        ui = request.getParameter("hcsalario");
        if (ui != null) {
            int z_hospcod = Integer.parseInt(ui);
    %>      <form method="get">
                <input type="hidden" value="<%=z_hospcod%>" name="cjhc"/>
                <label>Introduzca valor del incremento: </label>
                <input type="number" name="cjincr" required/>
                <button type="submit">Incrementar salario</button>
            </form> 
    <%  }
        
        ui = request.getParameter("cjhc");
        if (ui != null) {
            int z_hospcod = Integer.parseInt(ui);
            int z_incr = Integer.parseInt(request.getParameter("cjincr"));
            String z_regnum = controllerhospital.modificarSalarioPlantilla(z_hospcod, z_incr);
    %>      <h2>Plantilla con sueldo incrementado:</h2>
            <table border="1">
                <thead><tr><th>Apellido</th><th>Función</th><th>Nuevo salario</th></tr></thead>
                <tbody>
                    <%=controllerhospital.getSalarioPlantilla(z_hospcod)%>
                </tbody>
            </table>
            <%=z_regnum%>
    <%  }

    %>  <h2>Todos los hospitales:</h2>
        <table border="1">
            <thead>
                <tr><th>Cod.</th><th>Nombre</th><th>Dirección</th><th>Teléfono</th><th>Num camas</th></tr>
            </thead>
            <tbody>
                <%=controllerhospital.getTablaHospital01()%>
            </tbody>
        </table>
    </body>
</html>
