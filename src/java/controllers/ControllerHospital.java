/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import models.DetallesHospital;
import models.Doctor;
import models.Hospital;
import models.Plantilla;
import repositories.RepositoryHospital;

/**
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
    // Attributos
    RepositoryHospital repository;
    private HttpSession session;

    // Constructor. Cuidado void no va en los constructors.
    public ControllerHospital () {
        this.repository = new RepositoryHospital();
    }

    public void setSession(HttpSession session) {
        this.session = session;
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
            html += "<td><a class='btn btn-primary' href='webcontroller08detalleshospital.jsp?hospcod=" + h.getH_cod() + "'>Detalles</a>";
            html += "<a class='btn btn-info' href='webcontroller08updatehospital.jsp?hospcod=" + h.getH_cod() + "'>Modificar</a>";
            html += "<a class='btn btn-danger' id='btn-eliminarhospital' href='webcontroller08crudhospital.jsp?eliminar=" + h.getH_cod() + "'>Eliminar</a>";
            html += "</td>";
            html += "</tr>";
        }
        return html;
    }
    // Method 01
    public String getTablaHospital01() throws SQLException {
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
            html += "<td><a class='btn btn-primary' href='webcontroller09doctoreshospital.jsp?hcdetalles=" + h.getH_cod() + "'>Detalles -</a>";
            html += "<a class='btn btn-info' href='webcontroller09doctoreshospital.jsp?hcsalario=" + h.getH_cod() + "'>- Incrementar salario</a>";
            html += "</td>";
            html += "</tr>";
        }
        return html;
    }

    // Method 02
    public String getDetallesHospital(int hospcod) throws SQLException {
        Hospital z_hospital = this.repository.getDetallesHospital(hospcod);

        String html = "<input type='number' name='cjhcod' class='form-control' value='" + z_hospital.getH_cod() + "' readonly/><br/></div>";
        html += "<div><label>Nombre: </label>";
        html += "<input type='text' name='cjhnom' class='form-control' value='" + z_hospital.getH_nombre()+ "' required/><br/></div>";
        html += "<div><label>Dirección: </label>";
        html += "<input type='text' name='cjhdir' class='form-control' value='" + z_hospital.getH_direccion()+ "' required/><br/></div>";        
        html += "<div><label>Teléfono: </label>";
        html += "<input type='text' name='cjhtlf' class='form-control' value='" + z_hospital.getH_telefono()+ "' required/><br/></div>";
        html += "<div><label>Num. de Camas: </label>";
        html += "<input type='number' name='cjhnc' class='form-control' value='" + z_hospital.getH_numcama()+ "' required/><br/></div>";        
        return html;
    }
    // Method 02 alternative 01
    public String getDetallesHospital02(int hospcod) throws SQLException {
        DetallesHospital z_dethospital = this.repository.getDetallesHospitalAlt02(hospcod);
        String html = "";
        html += "<tr>";
        html += "<td>" + z_dethospital.getNumpersonas() + "</td>";
        html += "<td>" + z_dethospital.getSumasal() + "</td>";
        html += "<td>" + z_dethospital.getMediasal() + "</td>";
        html += "</tr>";
        return html;
    }
    // Método 03
    public void insertarHospital(String h_nom, String h_dir, String h_tlf, int h_numcama) throws SQLException {
        this.repository.insertarHospitalAlt01(h_nom, h_dir, h_tlf, h_numcama);
    }    
    // Método 04
    public void eliminarHospital(int h_cod) throws SQLException {
        this.repository.eliminarHospital(h_cod);
    }  
    // Método 05
    public void modificarHospital(int h_cod, String h_nom, String h_dir, String h_tlf, int h_numcama) throws SQLException {
        this.repository.modificarHospital(h_cod, h_nom, h_dir, h_tlf, h_numcama);
    } 
    // Method 06
    public String getTableDetallesHospital(int hcod) throws SQLException {
        Hospital z_hospital = this.repository.getDetallesHospital(hcod);
        
        String html = "<tr>";
        html += "<td>" + z_hospital.getH_cod() + "</td>";
        html += "<td>" + z_hospital.getH_nombre() + "</td>";
        html += "<td>" + z_hospital.getH_direccion() + "</td>";
        html += "<td>" + z_hospital.getH_telefono() + "</td>";
        html += "<td>" + z_hospital.getH_numcama() + "</td>";
        html += "<tr>";
        return html;
    }
    // Method 07
    public String getDetallesPlantilla(int hcod) throws SQLException {
        ArrayList<Plantilla> listaPlantilla = this.repository.getDetallesPlantilla(hcod);
        // Process response
        String html = "";
        for (Plantilla p: listaPlantilla) {
            html += "<tr>";
            html += "<td>" + p.getApellido() + "</td>";
            html += "<td>" + p.getSala_cod()+ "</td>";
            html += "<td>" + p.getFuncion() + "</td>";
            html += "<td>" + p.getTurno() + "</td>";
            html += "<td>" + p.getSalario() + "</td>";
            html += "<tr>";
        }
        return html;
    }
    // Method 08
    public String modificarSalarioPlantilla(int z_hospcod, int z_incr) throws SQLException {
        int z_numreg = this.repository.modificarSalarioPlantilla(z_hospcod, z_incr);
        String html = "";
        html += "<p style='color:red'>Registros modificados:" + z_numreg + "</p>";
        return html;
    }
    // Method 09
    public String getSalarioPlantilla(int hospcod) throws SQLException {
        ArrayList<Plantilla> listaPlantilla = this.repository.getDetallesPlantilla(hospcod);
        String html = "";
        for (Plantilla p: listaPlantilla) {
            html += "<tr>";
            html += "<td>" + p.getApellido() + "</td>";
//            html += "<td>" + p.getSala_cod()+ "</td>";
            html += "<td>" + p.getFuncion() + "</td>";
//            html += "<td>" + p.getTurno() + "</td>";
            html += "<td>" + p.getSalario() + "</td>";
            html += "<tr>";
        }
        return html;
    }
    
        public String getFilasDoctores() throws SQLException {
        ArrayList<Doctor> doctores = this.repository.getDoctores();
        String html = "";
        for (Doctor doc : doctores) {
            html += "<tr>";
            html += "<td>" + doc.getApellido() + "</td>";
            html += "<td>" + doc.getEspecialidad() + "</td>";
            html += "<td>" + doc.getSalario() + "</td>";
            html += "<td>" + doc.getIdHospital() + "</td>";
            html += "<td>";
            html += "<a href='webcontroller10almacenardoctoressessionv1.jsp?iddoctor=";
            html += doc.getIdDoctor() + "'>Almacenar</a>";
            html += "</td>";
            html += "</tr>";
        }
        return html;
    }

    public String getFilasDoctoresv2() throws SQLException {
        ArrayList<Doctor> doctores = this.repository.getDoctores();
        String html = "";
        for (Doctor doc : doctores) {
            html += "<tr>";
            html += "<td>" + doc.getApellido() + "</td>";
            html += "<td>" + doc.getEspecialidad() + "</td>";
            html += "<td>" + doc.getSalario() + "</td>";
            html += "<td>" + doc.getIdHospital() + "</td>";
            html += "<td>";
            html += "<a href='webcontroller10almacenardoctoressessionv2.jsp?iddoctor=";
            html += doc.getIdDoctor() + "'>Almacenar</a>";
            html += "</td>";
            html += "</tr>";
        }
        return html;
    }

    public String getDoctoresSession(ArrayList<String> codigos) throws SQLException {
        if (codigos.size() == 0) {
            //NO TENEMOS NADA ALMACENADO
            return "NO EXISTEN DOCTORES";
        }
        ArrayList<Doctor> doctores = this.repository.getDoctoresHospital(codigos);
        String html = "";
        for (Doctor doc : doctores) {
            html += "<tr>";
            html += "<td>" + doc.getApellido() + "</td>";
            html += "<td>" + doc.getEspecialidad() + "</td>";
            html += "<td>" + doc.getSalario() + "</td>";
            html += "</tr>";
        }
        return html;
    }

    public void almacenarDoctorSession(String iddoctor) {
        //MANEJAMOS LA SESSION MANUALMENTE
        ArrayList<String> codigos;
        //PREGUNTAMOS SI EXISTE ALGO EN SESSION
        if (session.getAttribute("DOCTORES") == null) {
            codigos = new ArrayList<>();
        } else {
            codigos = (ArrayList) session.getAttribute("DOCTORES");
        }
        //AÑADIMOS EL NUEVO DOCTOR A LA SESSION
        codigos.add(iddoctor);
        //ALMACENAMOS EL NUEVO VALOR DE SESSION
        session.setAttribute("DOCTORES", codigos);
    }

    public String getDoctoresSession()
            throws SQLException {
        //PREGUNTAMOS SI TENEMOS DATOS EN SESSION
        if (session.getAttribute("DOCTORES") == null) {
            //NO TENEMOS NADA ALMACENADO
            return "";
        }
        ArrayList<String> codigos = (ArrayList) session.getAttribute("DOCTORES");
        ArrayList<Doctor> doctores = this.repository.getDoctoresHospital(codigos);
        String html = "";
        for (Doctor doc : doctores) {
            html += "<tr>";
            html += "<td>" + doc.getApellido() + "</td>";
            html += "<td>" + doc.getEspecialidad() + "</td>";
            html += "<td>" + doc.getSalario() + "</td>";
            html += "</tr>";
        }
        return html;
    }    
}
