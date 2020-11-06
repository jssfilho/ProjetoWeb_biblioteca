package br.com.bilbioteca.config;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConexaoBanco {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
    private static final String USER = "root";
    private static final String PASS = "biblioteca";
    private static Connection conec= null;
    
    public static Connection getConnection() throws ClassNotFoundException{
        try {
            Class.forName(DRIVER);
            ConexaoBanco.conec =  DriverManager.getConnection(URL, USER, PASS);
            return ConexaoBanco.conec;
        } catch ( SQLException ex) {
            throw new RuntimeException("Erro na conexão ", ex);
        }
    }
    public static void closeConnection(Connection con) {
        try{
           if(con!=null){
            con.close();
            } 
        }catch (SQLException ex){
            
        }
        
    }
     public static void closeConnection(Connection con, PreparedStatement stmt) {

        closeConnection(con);

        try {

            if (stmt != null) {
                stmt.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {

        closeConnection(con, stmt);

        try {

            if (rs != null) {
                rs.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
