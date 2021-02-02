/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* PLSQL procedure, alternative 01:
create or replace procedure pr_insertarhospital
(p_nombre hospital.nombre%type,
p_direccion hospital.direccion%type,
p_telefono hospital.telefono%type,
p_camas hospital.num_cama%type)
as
   v_maximo hospital.hospital_cod%type;     
begin
   select max(hospital_cod)+1 into v_maximo from hospital;
   insert into hospital values (v_maximo, p_nombre, p_direccion, p_telefono, p_camas);
   commit;
end;

/* PLSQL procedure, alternative 02:
create or replace procedure pr_detalleshospital (
p_hospitalcod in hospital.hospital_cod%type,
p_personas out int,
p_suma out int,
p_media out int)
as
begin
    select count(doctor_no),sum(salario), avg(salario)
    into p_personas, p_suma, p_media from doctor
    where hospital_cod=p_hospitalcod;
end;

create or replace procedure pr_incrementarsalarioplantilla (p_hospcod hospital.hospital_cod%type,
                                                            p_incr int)
as
begin
    update plantilla set salario=salario+p_incr where hospital_cod=p_hospcod;
end;
*/

package repositories;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.Departamento;
import models.DetallesHospital;
import models.Hospital;
import models.Plantilla;
import oracle.jdbc.OracleDriver;

/**
 *
 * @author lscar
 */
public class RepositoryHospital {
    // Method 01
    public Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new OracleDriver());
        String cadena = "jdbc:oracle:thin:@localhost:1521:xe";
        Connection z_conn = DriverManager.getConnection(cadena, "system", "oracle");
        System.out.println("Connection");
        return z_conn;
    }
    // Method 02
    public ArrayList<Hospital> getHospitales() throws SQLException {
        // Get connection and query database
        Connection z_conn = this.getConnection();
        String z_sql = "select * from hospital";
        Statement z_st = z_conn.createStatement();
        ResultSet z_rs = z_st.executeQuery(z_sql);
        
        // Process database response: build response to controller.
        ArrayList<Hospital> listahospitales = new ArrayList<>();
        while(z_rs.next()) {
            Hospital hosp = new Hospital();
            hosp.setH_cod(z_rs.getInt("HOSPITAL_COD"));
            hosp.setH_nombre(z_rs.getString("NOMBRE"));
            hosp.setH_direccion(z_rs.getString("DIRECCION"));
            hosp.setH_telefono(z_rs.getString("TELEFONO"));
            hosp.setH_numcama(z_rs.getInt("NUM_CAMA"));
            listahospitales.add(hosp);
        }  
        z_rs.close();
        z_conn.close();
        return listahospitales;
    }
    // Method 03
    public Hospital getDetallesHospital(int hospcod) throws SQLException {
        Hospital z_hospital = new Hospital();
        Connection z_conn = this.getConnection();
        String z_sql ="select * from hospital where hospital_cod=?";
        PreparedStatement z_pst = z_conn.prepareStatement(z_sql);
        z_pst.setInt(1, hospcod);
        ResultSet z_rs = z_pst.executeQuery();
        z_rs.next();
    
        z_hospital.setH_cod(z_rs.getInt("HOSPITAL_COD"));
        z_hospital.setH_nombre(z_rs.getString("NOMBRE"));
        z_hospital.setH_direccion(z_rs.getString("DIRECCION"));
        z_hospital.setH_telefono(z_rs.getString("TELEFONO"));
        z_hospital.setH_numcama(z_rs.getInt("NUM_CAMA"));
        z_rs.close();
        z_conn.close();
        return z_hospital;
    }
    // Method 04
    public void insertarHospital(int hcod, String hnom, String hdir, String htlf, int hnc) throws SQLException {
        // Get connection and query database
        Connection z_conn = this.getConnection();
        String z_sql = "insert into hospital values (?,?,?,?,?)";
        PreparedStatement z_pst = z_conn.prepareStatement(z_sql);
        z_pst.setInt(1, hcod);
        z_pst.setString(2, hnom);
        z_pst.setString(3, hdir);
        z_pst.setString(4, htlf);
        z_pst.setInt(5, hnc);
        z_pst.executeUpdate();
        z_conn.close();
    }
    // Method 04 alternative01
    public void insertarHospitalAlt01(String hnom, String hdir, String htlf, int hnc) throws SQLException {
        // Get connection and query database
        Connection z_conn = this.getConnection();
        String z_sql = "{call pr_insertarhospital(?,?,?,?)}";
        CallableStatement z_pst = z_conn.prepareCall(z_sql);
        z_pst.setString(1, hnom);
        z_pst.setString(2, hdir);
        z_pst.setString(3, htlf);
        z_pst.setInt(4, hnc);
        z_pst.executeUpdate();
        z_conn.close();
    }
    //Method 05
    public DetallesHospital getDetallesHospitalAlt02(int hcod) throws SQLException {
        // Get connection and query database
        Connection z_conn = this.getConnection();
        String z_sql = "{call pr_detalleshospital(?,?,?,?)}";
        CallableStatement z_cst = z_conn.prepareCall(z_sql);
        z_cst.setInt(1, hcod);
        z_cst.registerOutParameter(2,java.sql.Types.INTEGER);
        z_cst.registerOutParameter(3,java.sql.Types.INTEGER);
        z_cst.registerOutParameter(4,java.sql.Types.INTEGER);
        z_cst.execute();
        int personas = z_cst.getInt(2);
        int suma = z_cst.getInt(3);
        int media = z_cst.getInt(4);
        DetallesHospital z_detalle = new DetallesHospital(personas, suma, media);
        z_conn.close();
        return z_detalle;
    }
    // Method 06
    public void eliminarHospital(int hcod) throws SQLException {
        Connection z_conn = this.getConnection();
        String z_sql = "delete from hospital where hospital_cod=?";
        PreparedStatement z_pst = z_conn.prepareStatement(z_sql);
        z_pst.setInt(1, hcod);
        z_pst.executeUpdate();
        z_conn.close();
    }
    // Method 07
    public void modificarHospital(int hcod, String hnom, String hdir, String htlf, int hnc) throws SQLException {
        // Get connection and query database
        Connection z_conn = this.getConnection();
        String z_sql = "update hospital set nombre=?, direccion=?, telefono=?, num_cama=? where hospital_cod=?";
        PreparedStatement z_pst = z_conn.prepareStatement(z_sql);
        z_pst.setString(1, hnom);
        z_pst.setString(2, hdir);
        z_pst.setString(3, htlf);
        z_pst.setInt(4, hnc);
        z_pst.setInt(5, hcod);
        z_pst.executeUpdate();
        z_conn.close();
    }
    // Method 02
    public ArrayList<Plantilla> getDetallesPlantilla(int hcod) throws SQLException {
        // Get connection and query database
        Connection z_conn = this.getConnection();
        String z_sql = "select * from plantilla where hospital_cod=?";
        PreparedStatement z_pst = z_conn.prepareStatement(z_sql);
        z_pst.setInt(1, hcod);
        ResultSet z_rs = z_pst.executeQuery();
        
        // Process database response: build response to controller.
        ArrayList<Plantilla> listaplantilla = new ArrayList<>();
        while(z_rs.next()) {
            Plantilla plantilla = new Plantilla();
            plantilla.setApellido(z_rs.getString("APELLIDO"));
            plantilla.setSala_cod(z_rs.getInt("SALA_COD"));
            plantilla.setFuncion(z_rs.getString("FUNCION"));
            plantilla.setTurno(z_rs.getString("TURNO"));
            plantilla.setSalario(z_rs.getInt("SALARIO"));
            listaplantilla.add(plantilla);
        }  
        z_rs.close();
        z_conn.close();
        return listaplantilla;
    }
    
    public void modificarSalarioPlantilla(int z_hospcod, int z_incr) throws SQLException {
        Connection z_conn = this.getConnection();
        String z_sql = "{call pr_incrementarsalarioplantilla(?,?)}";
        CallableStatement z_pst = z_conn.prepareCall(z_sql);
        z_pst.setInt(1, z_hospcod);
        z_pst.setInt(2, z_incr);
        z_pst.executeUpdate();
        z_conn.close();
    }
}
