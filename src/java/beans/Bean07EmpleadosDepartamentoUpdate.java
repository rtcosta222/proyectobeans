/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import oracle.jdbc.OracleDriver;

/**
 *
 * @author lscar
 */
public class Bean07EmpleadosDepartamentoUpdate {
        
    private Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new OracleDriver());
        String z_path = "jdbc:oracle:thin:@localhost:1521:xe";
        Connection z_conn = DriverManager.getConnection(z_path, "system", "oracle");
        return z_conn;
    }
    
    public void incrementarSalarios (int incr, int deptno) throws SQLException {
        Connection z_conn = this.getConnection();
        String z_sql = "update emp set salario = salario + ? where dept_no = ?";
        PreparedStatement z_pst = z_conn.prepareStatement(z_sql);
        z_pst.setInt(1, deptno);
        z_pst.setInt(2, incr);
        z_pst.executeUpdate();
        z_conn.close();
    } 
}
