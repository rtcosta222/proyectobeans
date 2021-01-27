/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import oracle.jdbc.OracleDriver;

/**
 *
 * @author lscar
 */
public class BeansUtils {
        private Connection getConnection() throws SQLException {
            DriverManager.registerDriver(new OracleDriver());
            String z_path = "jdbc:oracle:thin:@localhost:1521:xe";
            Connection z_conn = DriverManager.getConnection(z_path, "system", "oracle");
            return z_conn;
    }
}
