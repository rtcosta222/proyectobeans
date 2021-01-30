/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import models.Hospital;
import repositories.RepositoryHospital;

/**
 *
 * @author lscar
 * 
 * La secuencia es siempre la misma:
 * . Declarar la clase:
 *     - Declarar el atributo.
 *     - Constructor.
 *     - Método(s):
 *         . Query the repository.
 *         . Process response to View.
 */

public class ControllerHospital {
    // Attributo
    RepositoryHospital repository;
    // Constructor. Cuidado void no va en los constructors.
    public ControllerHospital () {
        this.repository = new RepositoryHospital();
    }
    // Method 01
    public String getTablaHospital() throws SQLException {
        // Query the Repository
        ArrayList<Hospital> lista = this.repository.getHospitales();
        // Process response
        String html = "";
        for (Hospital h: lista) {
            html += "<tr>";
            html += "<td>" + h.getH_cod() + "</td>";
            html += "<td>" + h.getH_nombre() + "</td>";
            html += "<td>" + h.getH_direccion() + "</td>";
            html += "<td>" + h.getH_telefono() + "</td>";
            html += "<td>" + h.getH_numcama() + "</td>";
            html += "<td><a class='btn btn-primary' href='webcontroller08detailshospital.jsp?hospcod=" + h.getH_cod() + "'>Detalles</a>";
            html += "<a class='btn btn-info' href='webcontroller08updatehospital.jsp?hospcod=" + h.getH_cod() + "'>Modificar</a>";
            html += "<a class='btn btn-danger' href='webcontroller08crudhospital.jsp?eliminar=" + h.getH_cod() + "'>Eliminar</a>";
            html += "</td>";
            html += "</tr>";
        }
        return html;
    }
    // Método 02
    public void insertarHospital(int h_cod, String h_nom, String h_dir, String h_tlf, int h_numcama) throws SQLException {
        this.repository.insertarHospital(h_cod, h_nom, h_dir, h_tlf, h_numcama);
    }    
    // Método 03
    public void eliminarHospital(int h_cod) throws SQLException {
        this.repository.eliminarHospital(h_cod);
    }   }