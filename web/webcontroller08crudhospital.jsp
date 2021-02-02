<%-- 
    Document   : webcontroller08crudhospital
    Created on : 29-ene-2021, 19:52:38
    Author     : lscar
    Supuesto   : Mostrar una tabla de Hospitales utilizando el patrón MVC
                    Modelos
                    Controladores
                    Vistas
                    Repositorios
                 Incluir diseño con BootStrap e intentar hacer un CRUD en 
                 Hospitales, tal y como hicimos en la App de JSP. Hacer una 
                 página Insertar y, cuando insertemos, lo llevamos de nuevo a la 
                 página de Tabla. Y, en la página insertar, no pedimos el ID del 
                 hospital, recuperamos el Maximo ID desde el Repository. Incluir
                 un constructor para inicializar el objeto Hospital en el 
                 repositorio.
                 SCRIPT (NOK).
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
                %>  <table border="1" class="table table-bordered">
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
                <script>
                    $(document).ready(function(){ ¡
                        $("#btn-eliminarhospital").click(function() {
                            var respuesta = confirm("Desea eliminar el hospital?");
                            if (respuesta == false) {
                                return true;
                            }
                        });
                    });          
                </script>
            </main><!-- /.container -->            
        </section>
        <jsp:include page="includes/webfooter.jsp"/>
    </body>
</html>
