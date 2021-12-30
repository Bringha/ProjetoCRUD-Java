package br.com.alfashop.config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author fabio
 */
public class Conex {
    
    public static Connection getConnection(){
        
        Connection conn;        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //conectar efetivamente com o SGBD
            //montar comando SQL para inserçao
            String host = "jdbc:mysql://localhost/alfashop";
            String user = "root";
            String pass = "";
            //entao, criar comando e executar
            conn = DriverManager.getConnection(host, user, pass);
        } catch (Exception e) {
            conn = null;
        }
        
        return conn;
        
    }
    
    
}
