<%-- 
    Document   : webcontroller08crudhospital
    Created on : 29-ene-2021, 19:52:38
    Author     : lscar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controllerHospital" class="controllers.ControllerHospital" scope="request"/>

<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="includes/webhead.jsp"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD Hospital</title>
    </head>
    <body>
        <jsp:include page="includes/webmenuhospitales.jsp"/>
        <section>
            <main role="main" class="container">
                <div class="starter-template">
                    <h1>Hospital</h1><br/>
                <%  String dato = request.getParameter("eliminar");
                    if (dato != null) {
                        int z_cj_hcod = Integer.parseInt(dato);
                        controllerHospital.eliminarHospital(z_cj_hcod);
                    }
                %>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Hospital_cod</th>
                                <th>Nombre</th>
                                <th>Direccion</th>
                                <th>Telefono</th>
                                <th>Num_Cama</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%=controllerHospital.getTablaHospital()%>
                        </tbody>
                    </table>
                </div>
            </main><!-- /.container -->            
        </section>
        <jsp:include page="includes/webfooter.jsp"/>
    </body>
</html>
