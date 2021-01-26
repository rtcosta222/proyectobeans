/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import oracle.jdbc.OracleDriver;

/**
 *
 * @author lscar
 */
public class Bean03TablaEmpleadosRepaso {
    
    public Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new OracleDriver());
        String cadena = "jdbc:oracle:thin:@localhost:1521:xe";
        Connection z_conn = DriverManager.getConnection(cadena, "system", "oracle");
        return z_conn;
    }
    
    public void incrementarSalario(int incsal) throws SQLException {
        Connection z_conn = this.getConnection();
        String z_sql = "update emp set salario = salario + ?";
        PreparedStatement z_pst = z_conn.prepareStatement(z_sql);
        z_pst.setInt(1, incsal);
        z_pst.executeUpdate();
        z_conn.close();
    }
    
    public String mostrarEmpleados () throws SQLException {
        Connection z_conn = this.getConnection();
        String z_sql = "select * from emp";
        Statement z_st = z_conn.createStatement();
        ResultSet z_rs = z_st.executeQuery(z_sql);
        String html = "<table border='1'>";
        html += "<tr><th>Apellido</th><th>Oficio</th><th>Salario</th></tr>";
        while (z_rs.next()) {
            html += "<tr><td>"+z_rs.getString("APELLIDO")+"</td>"
                      + "<td>"+z_rs.getString("OFICIO")+"</td>"
                      + "<td>"+z_rs.getString("SALARIO")+"</td></tr>"; 
        }
        html += "</table>";
        return html;
    }    
}
