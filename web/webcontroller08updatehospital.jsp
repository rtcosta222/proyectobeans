<%-- 
    Document   : webcontroller08updatehospital
    Created on : 29-ene-2021, 20:44:58
    Author     : lscar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controllerhospital" class="controllers.ControllerHospital" scope="request"/>

<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="includes/webhead.jsp"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD HOSPITALES - Modificar</title>
    </head>
    <body>
        <jsp:include page="includes/webmenuhospitales.jsp"/>
        <section>
            <main role="main" class="container">
                <div class="starter-template">
                    <h1>Modificar Hospital</h1>
                    
                </div>
            </main><!-- /.container -->            
        </section>
        <jsp:include page="includes/webfooter.jsp"/>
    </body>
</html>
