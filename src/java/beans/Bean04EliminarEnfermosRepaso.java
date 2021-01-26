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
public class Bean04EliminarEnfermosRepaso {
    
    public Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new OracleDriver());
        String z_path = "jdbc:oracle:thin:@localhost:1521:xe";
        Connection z_conn = DriverManager.getConnection(z_path, "system", "oracle");
        return z_conn;
    }
    
    public void borrarEnfermo(int insc) throws SQLException {
        Connection z_conn = this.getConnection();
        String z_sql = "delete enfermo where inscripcion = ?";
        PreparedStatement z_pst = z_conn.prepareStatement(z_sql);
        z_pst.setInt(1, insc);
        z_pst.executeUpdate();
        z_conn.close();
    }
    
    public String mostrarEnfermos() throws SQLException {
        Connection z_conn = this.getConnection();
        String z_sql = "select * from enfermo";
        Statement z_st = z_conn.createStatement();
        ResultSet z_rs = z_st.executeQuery(z_sql);
        String html = "<table border='1'>";
        while(z_rs.next()) {
            html += "<tr><td>"+z_rs.getString("APELLIDO")+"</td>"
                    + "<td>"+z_rs.getString("DIRECCION")+"</td>"
                    + "<td>"+z_rs.getString("INSCRIPCION")+"</td></tr>";
        }
        z_rs.close();
        z_conn.close();
        html += "</table>";
        return html;
    }
}
