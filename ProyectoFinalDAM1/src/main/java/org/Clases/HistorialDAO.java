package org.Clases;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HistorialDAO implements IntDAO<Historial> {

    private Connection conexion;

    public HistorialDAO() throws SQLException {
        this.conexion = ConexionMySQL.getConexion();
    }

    @Override
    public void crear(String nombrefichero) throws SQLException {
        String sql = "INSERT INTO Historial (id_historial,nombre, intentos) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql);
             BufferedReader br = new BufferedReader(new FileReader(nombrefichero))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 3) {

                    Historial h = new Historial();
                    h.setId(Integer.parseInt(datos[0]));
                    h.setNombre(datos[1]);
                    h.setIntentos(Integer.parseInt(datos[2]));

                    stmt.setInt(1, h.getId());
                    stmt.setString(2, h.getNombre());
                    stmt.setInt(3, h.getIntentos());

                    stmt.executeUpdate();
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Archivo no encontrado: " + e.getMessage(), e);
        } catch (IOException e) {
            throw new RuntimeException("Error de entrada/salida: " + e.getMessage(), e);
        }
    }



    @Override
    public Historial obtenerPorId(int idhisto, String nombrefichero) throws SQLException {
        String sql = "SELECT * FROM historial WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, idhisto); // Establece el parámetro correctamente
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String nombre = rs.getString("nombre_usuario");
                    int tiempo = rs.getInt("tiempo");
                    int intentos = rs.getInt("intentos");
                    return new Historial(idhisto, nombre,  intentos);
                } else {
                    return null; // No se encontró el historial
                }
            }
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public List<Historial> obtenerTodos() throws SQLException {
        List<Historial> lista = new ArrayList<>();
        String sql = "SELECT * FROM historial";

        try (PreparedStatement stmt = conexion.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id_historial");
                String nombre = rs.getString("nombre_usuario");
                int intentos = rs.getInt("intentos");

                Historial h = new Historial(id, nombre, intentos);
                lista.add(h);
            }
        }
        return lista;
    }


    @Override
    public void actualizar(Historial o) throws SQLException {

    }

    @Override
    public void borrar(Historial o) throws SQLException {

    }

    public void cerrarConexion() throws SQLException {
        conexion.close();
    }
}


