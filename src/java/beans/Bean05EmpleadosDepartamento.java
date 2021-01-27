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
public class Bean05EmpleadosDepartamento {
    
    public Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new OracleDriver());
        String z_path = "jdbc:oracle:thin:@localhost:1521:xe";
        Connection z_conn = DriverManager.getConnection(z_path, "system", "oracle");
        return z_conn;
    }
    
    public String getDepts() throws SQLException {
        Connection z_conn = this.getConnection();
        String z_sql = "select * from dept";
        Statement z_st = z_conn.createStatement();
        ResultSet z_rs = z_st.executeQuery(z_sql);
        String html = "";
        while(z_rs.next()) {
            String z_ui_deptnombre = z_rs.getString("DNOMBRE");
            String z_ui_deptno = z_rs.getString("DEPT_NO");
            html += "<option value=" + z_ui_deptno + ">" + z_ui_deptnombre + "</option>";
        }  
        z_rs.close();
        z_conn.close();
        return html;
    }    
    
    public String getEmp(int deptno) throws SQLException {
        Connection z_conn = this.getConnection();
        String z_sql = "select * from emp where dept_no=?";
        PreparedStatement z_pst = z_conn.prepareStatement(z_sql);
        z_pst.setInt(1, deptno);
        ResultSet z_rs = z_pst.executeQuery();
        String html = "";
        while(z_rs.next()) {
            html += "<tr><td>" + z_rs.getString("APELLIDO") + "</td>"
                    + "<td>" + z_rs.getString("OFICIO") + "</td>"
                    + "<td>" + z_rs.getString("SALARIO") + "</td></tr>";
        }
        z_rs.close();
        z_conn.close();
        return html;
    }
}
