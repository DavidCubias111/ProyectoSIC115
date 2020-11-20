/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sic.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
public class Conexion {
    private static Connection con;
   
    private static void conectar() {
        String url = "jdbc:postgresql://localhost:5433/";
        String db = "sic_tarea";
        String user = "postgres";
        String password = "cf15025";
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            con = DriverManager.getConnection(url+db, user, password);
        } catch (SQLException | ClassNotFoundException | InstantiationException |
                IllegalAccessException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getConexion() {
        if (con == null) {
            conectar();
        }
        return con;
    }
    
}
