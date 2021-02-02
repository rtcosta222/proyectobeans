/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import models.Departamento;
import repositories.RepositoryDepartamentos;

/**
 *
 * @author lscar
 */
public class ControllerDepartamentos {
    // Atributos
    // The next instruction is equivalent to:
    //  <jsp:useBean id="repo" class="RepositoryDepartamentos" .../>
    //  It is an object "repo" of class "RepositoryDepartamentos"
    RepositoryDepartamentos repo;
    
    // Métodos
    //  Constructor
    public ControllerDepartamentos() {
        this.repo = new RepositoryDepartamentos();
    }
    
    public String getTablaDepartamentos() throws SQLException {
        // Query the Repository
        ArrayList<Departamento> lista = this.repo.getDepartamentos();
        // Process response
        String html = "";
        for (Departamento d: lista) {
            html += "<tr>";
            html += "<td>" + d.getNumero() + "</td>";
            html += "<td>" + d.getNombre() + "</td>";
            html += "<td>" + d.getLocalidad() + "</td>";
            html += "</tr>";
        }
        return html;
    }

    public String getTablaEdicionDepartamentos() throws SQLException {
        // Query the Repository
        ArrayList<Departamento> lista = this.repo.getDepartamentos();
        // Process response
        String html = "";
        for (Departamento d: lista) {
            html += "<tr>";
            html += "<td>" + d.getNumero() + "</td>";
            html += "<td>" + d.getNombre() + "</td>";
            html += "<td>" + d.getLocalidad() + "</td>";
            html += "<td><button type='button' name='boton-edicion'>Editar</button></td>";
            html += "</tr>";
        }
        return html;
    }
        
    public String getSelectDepartamentos() throws SQLException {
        // Query the Repository
        ArrayList<Departamento> lista = repo.getDepartamentos();
        // Process response
        String html = "";
        for (Departamento d: lista) {
            html += "<option value='" + d.getNumero() + "'>";
            html += d.getNombre() + "</option>";
        }
        return html;
    }
    
    public String getDetallesDepartamento(int deptno) throws SQLException {
        // Query the Repository
        Departamento dept = repo.buscarDepartamento(deptno);
        // Process response
        String html = "<h1>Número: " + dept.getNumero() + "<h1>";
        html += "<h1>Nombre: " + dept.getNombre() + "<h1>";
        html += "<h1>Localidad: " + dept.getLocalidad() + "<h1>";       
        return html;
    }
    
    public String getFormDetallesDepartamento (int deptno) throws SQLException {
        Departamento dept = repo.buscarDepartamento(deptno);
        String html = "<label>Dept no.: </label>";
        html += "<input type='number' name='cjdeptnum' value='" + dept.getNumero() + "'readonly/><br/>";
        html += "<label>Nombre del dept: </label>";
        html += "<input type='text' name='cajadeptnom' value='" + dept.getNombre() + "'required/><br/>";
        html += "<label>Localidad del dept: </label>";
        html += "<input type='text' name='cajadeptloc' value='" + dept.getLocalidad() + "'required/><br/>";
        return html;
    }
    
    public void eliminarDepartamento(int deptno) throws SQLException {
        // Query the Repository
        repo.eliminarDept(deptno);
        // Nothing to return to the View
    }
    
    public void insertarDepartamento(int deptnum, String deptnom, String deptloc) throws SQLException {
        // Query the Repository
        repo.insertarDept(deptnum, deptnom, deptloc);
        // Nothing to return to the View
    }
    
    public void modificarDepartamento (int deptnum, String deptnom, String deptloc) throws SQLException {
        // Query the Repository
        repo.modificarDept(deptnum, deptnom, deptloc);
        // Nothing to return to the View
    
    }
    
    public String getTablaEliminarDepartamento() throws SQLException {
        // Query the Repository
        ArrayList<Departamento> listadepts = this.repo.getDepartamentos();
        // Process response
        String html = "";
        for (Departamento dept: listadepts) {
            html += "<tr>";
            html += "<td>" + dept.getNumero() + "</td>";
            html += "<td>" + dept.getNombre() + "</td>";
            html += "<td>" + dept.getLocalidad() + "</td>";
            html += "<td>";
            html += "<button type='submit' name='eliminar' value='" + dept.getNumero() + "'>Eliminar</button>";
            html += "</td>";
            html += "</tr>";
        }
        return html;
    }
}
