<%-- 
    Document   : webcontroller07gettablahospital
    Created on : 29-ene-2021, 18:17:26
    Author     : lscar
    Supuesto   : 1) Model: Hospital (OK).
                    Repo: RepositoryHospital
                    Controller: ControllerHospital
                    HOSPITAL
                    Mostrar una tabla de Hospitales utilizando el patrón MVC
                    . Modelos
                    . Controladores
                    . Vistas
                    . Repositorios
        
                 2) (NOK) Si lo tenéis en algún momento, incluir diseño con BootStrap
                    e intentar hacer un CRUD en Hospitales, tal y como hicimos 
                    en la App de JSP. Hacer una página Insertar y, cuando 
                    insertemos, lo llevamos de nuevo a la página de Tabla. Y, en 
                    la página insertar, no pedimos el ID del hospital, 
                    recuperamos el Maximo ID desde el Repository
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controllerHospital" class="controllers.ControllerHospital" scope="request"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MVC - Tabla Hospital</title>
    </head>
    <body>
        <h1>Mostrar Hospitales</h1>
        <table>
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
    </body>
</html>
