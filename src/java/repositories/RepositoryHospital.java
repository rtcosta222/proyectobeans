/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.Departamento;
import models.Hospital;
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
    // Methos 02
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
    // Method 02
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
    // Method 03
    public void eliminarHospital(int hcod) throws SQLException {
        Connection z_conn = this.getConnection();
        String z_sql = "delete from hospital where hospital_cod=?";
        PreparedStatement z_pst = z_conn.prepareStatement(z_sql);
        z_pst.setInt(1, hcod);
        z_pst.executeUpdate();
        z_conn.close();
    }
    // Method 04
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
}
