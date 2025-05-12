package org.Conecxion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {
    private static final String url = "jdbc:mysql://localhost:3306/Inazuma";
    private static final String usuario = "usuario";
    private static final String contraseña = "1234";

    private static Connection conexion;
    public static Connection getConexion() throws SQLException {
        if (conexion == null || conexion.isClosed()) {
            try{
                Class.forName("com.mysql.cj.jdbc.Drver");
                conexion = DriverManager.getConnection(url,usuario,contraseña);
                System.out.println("Conexion establecida");
            }catch (ClassNotFoundException e){
                throw new SQLException("Clase no encontrada");
            }
        }
        return conexion;
    }
    public static void cerrarConexion() throws SQLException {
        if (conexion != null && !conexion.isClosed()) {
            conexion.close();
            System.out.println("Conexion cerrada");
        }
    }
}
