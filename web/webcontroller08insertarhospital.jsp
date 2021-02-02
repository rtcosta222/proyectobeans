<%-- 
    Document   : webcontroller08insertarhospital
    Created on : 30-ene-2021, 2:18:35
    Author     : lscar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controllerhospital" class="controllers.ControllerHospital" scope="request"/>

<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="includes/webhead.jsp"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD HOSPITAL - Insertar</title>
    </head>
    <body>
        <jsp:include page="includes/webmenuhospitales.jsp"/>
        <section>
            <main role="main" class="container">
                <div class="starter-template">
                    <h1>Nuevo Hospital</h1><br>
                    <form method="post">
<!--                        <div
                            <label>Código</label>
                            <input type="number" name="cjhcod" class="form-control" required/>
                        </div> -->
                        <div>
                            <label>Nombre</label>
                            <input type="text" name="cjhnom" class="form-control" required/>
                        </div>
                        <div>
                            <label>Dirección</label>
                            <input type="text" name="cjhdir" class="form-control" required/>
                        </div>
                        <div>
                            <label>Teléfono</label>
                            <input type="text" name="cjhtlf" class="form-control" required/>
                        </div>
                        <div>
                            <label>Núm. de Camas</label>
                            <input type="number" name="cjhnc" class="form-control" required/>
                        </div>
                        <br/>
                        <div>
                            <button type="submit" class="btn-lg btn-success">Crear Hospital</button>
                        </div>
                    </form>

                <%  String hnom = request.getParameter("cjhnom");
                    if (hnom != null) {
//                        int hcod =Integer.parseInt(cjhc);
//                        String hnom = request.getParameter("cjhnom");
                        String hdir = request.getParameter("cjhdir");
                        String htlf = request.getParameter("cjhtlf");
                        String hnumcama = request.getParameter("cjhnc");
                        int hnc = Integer.parseInt(hnumcama);
                        controllerhospital.insertarHospital(hnom, hdir, htlf, hnc);
                    }
                    if (hnom != null) {
                %>      <jsp:forward page="webcontroller08crudhospital.jsp"/>
                <%  }                    
                %>
                </div>
            </main><!-- /.container -->            
        </section>
        <jsp:include page="includes/webfooter.jsp"/>
    </body>
</html>
