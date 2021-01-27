package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import oracle.jdbc.OracleDriver;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lscar
 */
public class Bean04EliminarEnfermos {
    // Método 01
    private Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new OracleDriver());
        String cadena = "jdbc:oracle:thin:@localhost:1521:xe";
        Connection z_conn = DriverManager.getConnection(cadena, "system", "oracle");
        return z_conn;
    }
    // Método 02    
    public String getTablaEnfermo() throws SQLException {
        Connection z_conn= this.getConnection();
        Statement z_st = z_conn.createStatement();
        String z_sql = "select * from enfermo";
        ResultSet z_rs = z_st.executeQuery(z_sql);
        String html = "<table border='1'>";
        html += "<tr><th>Apellido</th><th>Oficio</th><th>Salario</th></tr>";
        while (z_rs.next()) {
            html += "<tr>";
            html += "<td>" + z_rs.getString("APELLIDO") + "</td>";
            html += "<td>" + z_rs.getString("DIRECCION") + "</td>";
            html += "<td>" + z_rs.getString("INSCRIPCION") + "</td>";
            html += "</tr>";
        }
        html +="</table>";
        z_rs.close();
        z_conn.close();
        return html;
    }
    // Método 03
    public void eliminarEnfermo (int ins) throws SQLException {
        Connection z_conn = this.getConnection();
        String z_sql = "delete from enfermo where inscripcion = ?";
        PreparedStatement z_pst = z_conn.prepareStatement(z_sql);
        z_pst.setInt(1, ins);
        z_pst.executeUpdate();
        z_conn.close();
    }
}