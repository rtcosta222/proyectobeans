/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import models.Departamento;
import repositories.Repository01Departamentos;

/**
 *
 * @author lscar
 */
public class Controller01Departamentos {
    // Atributos
    Repository01Departamentos repo;
    
    // Constructor
    public Controller01Departamentos() {
        this.repo = new Repository01Departamentos();
    }
    
    // Métodos
    public String getTablaDepartamentos() throws SQLException {
        ArrayList<Departamento> lista = repo.getDepartamentos();
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

    public String getSelectDepartamentos() throws SQLException {
        ArrayList<Departamento> lista = repo.getDepartamentos();
        String html = "";
        for (Departamento d: lista) {
            html += "<option value='" + d.getNumero() + "'>";
            html += d.getNombre() + "</option>";
        }
        return html;
    }
    
    public String getDetallesDepartamento(int deptno) throws SQLException {
        Departamento dept = repo.buscarDepartamento(deptno);
        String html = "<h1>Número: " + dept.getNumero() + "<h1>";
        html += "<h1>Nombre: " + dept.getNombre() + "<h1>";
        html += "<h1>Localidad: " + dept.getLocalidad() + "<h1>";       
        return html;
    }
    
    public void eliminarDepartamento(int deptno) throws SQLException {
        repo.eliminarDept(deptno);
    }
}
