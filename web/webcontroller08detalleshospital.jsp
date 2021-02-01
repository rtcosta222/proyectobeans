<%-- 
    Document   : webcontroller08detailshospital
    Created on : 29-ene-2021, 20:43:21
    Author     : lscar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controllerhospital" class="controllers.ControllerHospital" scope="request"/>

<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="includes/webhead.jsp"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD HOSPITAL - Detalles</title>
    </head>
    <body>
        <jsp:include page="includes/webmenuhospitales.jsp"/>
        <section>
            <main role="main" class="container">
                <div class="starter-template">
                    <h1>Detalles de Hospital</h1>
                <%  String ui = request.getParameter("hospcod");
                    if (ui != null) {
                        int z_hospcod = Integer.parseInt(ui);
                %>      <table class="table table-bordered">
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
                                <%=controllerhospital.getTableDetallesHospital(z_hospcod)%>
                            </tbody>
                        </table>    
                <%  }
                %>  
                </div>
            </main><!-- /.container -->            
        </section>
        <jsp:include page="includes/webfooter.jsp"/>
    </body>
</html>
