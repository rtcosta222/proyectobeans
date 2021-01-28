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
import oracle.jdbc.OracleDriver;

/**
 *
 * @author lscar
 */
public class Repository01Departamentos {

    public Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new OracleDriver());
        String cadena = "jdbc:oracle:thin:@localhost:1521:xe";
        Connection z_conn = DriverManager.getConnection(cadena, "system", "oracle");
        return z_conn;
    }
    
    public ArrayList<Departamento> getDepartamentos() throws SQLException {
        // Get connection and query database
        Connection z_conn = this.getConnection();
        String z_sql = "select * from dept";
        Statement z_st = z_conn.createStatement();
        ResultSet z_rs = z_st.executeQuery(z_sql);

        // Process database response: build response to controller.
        ArrayList<Departamento> listadepts = new ArrayList<>();
        while(z_rs.next()) {
            Departamento dept = new Departamento();
            dept.setNumero(z_rs.getInt("DEPT_NO"));
            dept.setNombre(z_rs.getString("DNOMBRE"));
            dept.setLocalidad(z_rs.getString("LOC"));
            listadepts.add(dept);
        }  
        z_rs.close();
        z_conn.close();
        return listadepts;
    }
    
    public Departamento buscarDepartamento(int deptno) throws SQLException {
        Connection z_conn = this.getConnection();
        String z_sql = "select * from dept where dept_no=?";
        PreparedStatement z_pst = z_conn.prepareStatement(z_sql);
        z_pst.setInt(1, deptno);
        ResultSet z_rs = z_pst.executeQuery();
        z_rs.next();
        Departamento z_deptobj = new Departamento();
        z_deptobj.setNumero(z_rs.getInt("DEPT_NO"));
        z_deptobj.setNombre(z_rs.getString("DNOMBRE"));
        z_deptobj.setLocalidad(z_rs.getString("LOC"));
        z_rs.close();
        z_conn.close();
        return z_deptobj;
    }
    
    public void eliminarDept(int deptno) throws SQLException {
        Connection z_conn = this.getConnection();
        String z_sql = "delete from dept where dept_no=?";
        PreparedStatement z_pst = z_conn.prepareStatement(z_sql);
        z_pst.setInt(1, deptno);
        z_pst.executeUpdate();
        z_conn.close();
    }
}
