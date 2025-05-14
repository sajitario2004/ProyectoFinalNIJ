package org.Clases;

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
    public void insertar(Historial o) throws SQLException {
        String sql = "INSERT INTO historial (id, nombre, tiempo, intentos) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, o.getId());
            stmt.setString(2, o.getNombre());
            stmt.setDouble(3, o.getTiempo());
            stmt.setInt(4, o.getIntentos());

            stmt.executeUpdate();

        }
    }

    @Override
    public Historial obtenerPorId(int id) throws SQLException {
        String sql = "SELECT * FROM historial WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String nombre = rs.getString("nombre");
                    int tiempo = rs.getInt("tiempo");
                    int intentos = rs.getInt("intentos");
                    return new Historial(id, nombre, tiempo, intentos);
                } else {
                    return null;
                }
            }
        }
    }


    @Override
    public List<Historial> obtenerTodos() throws SQLException {
        List<Historial> lista = new ArrayList<>();
        String sql = "SELECT * FROM historial";

        try (PreparedStatement stmt = conexion.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int tiempo = rs.getInt("tiempo");
                int intentos = rs.getInt("intentos");

                Historial h = new Historial(id, nombre, tiempo, intentos);
                lista.add(h);
            }
        }

        return lista;
    }
}


