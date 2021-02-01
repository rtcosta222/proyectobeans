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
                    <h1>Modificar Hospital</h1><br>
                <%  String z_ui = request.getParameter("hospcod");
                    if (z_ui != null) {
                        int z_hospcod = Integer.parseInt(z_ui);
                %>      <form method="post">
                            <div><label>Hospital Cod.: </label>
                            <%=controllerhospital.getDetallesHospital(z_hospcod)%>
                            <button type="submit" class="btn-lg btn-success">Modificar Hospital</button>              
                        </form><br/>
                <%  }
                %>
                <%  String cjhc = request.getParameter("cjhcod");
                    if (cjhc != null) {
                        int hcod =Integer.parseInt(cjhc);
                        String hnom = request.getParameter("cjhnom");
                        String hdir = request.getParameter("cjhdir");
                        String htlf = request.getParameter("cjhtlf");
                        String cjnc = request.getParameter("cjhnc");
                        int hnc = Integer.parseInt(cjnc);
                        controllerhospital.modificarHospital(hcod, hnom, hdir, htlf, hnc);
                    }
                    if (cjhc != null) {
                %>      <jsp:forward page="webcontroller08crudhospital.jsp"/>
                <%  }                    
                %>
                </div>
            </main><!-- /.container -->            
        </section>
        <jsp:include page="includes/webfooter.jsp"/>
 
    </body>
</html>
