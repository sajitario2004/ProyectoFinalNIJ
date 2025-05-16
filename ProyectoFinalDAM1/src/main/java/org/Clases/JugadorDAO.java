package org.Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JugadorDAO implements IntDAO<Jugador> {

    private Connection connection;

    public JugadorDAO() throws SQLException {
        this.connection = ConexionMySQL.getConexion();
    }


    @Override
    public void crear(String fichero) throws SQLException {

    }

    @Override
    public void actualizar(Jugador o) throws SQLException {

    }

    @Override
    public void borrar(Jugador o) throws SQLException {

    }

    @Override
    public Jugador obtenerPorId(int id, String fichero) throws SQLException {
        String sql = "SELECT * FROM Jugador WHERE id = ?";
        Jugador j = null;
        try(PreparedStatement ps  = connection.prepareStatement(sql)){
            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    j = new Jugador(rs.getInt("id_jugador"),rs.getString("nombre"),
                            rs.getString("equipo"),rs.getString("posicion"),
                            rs.getString("genero"),rs.getString("elemento") );
                }
            }
        }
        return j;
    }



    @Override
    public List<Jugador> obtenerTodos() throws SQLException {
        String sql = "SELECT * FROM Jugador";
        List<Jugador> jugadores = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Jugador jugador = new Jugador(
                        rs.getInt("id_jugador"),
                        rs.getString("nombre"),
                        rs.getString("equipo"),
                        rs.getString("posicion"),
                        rs.getString("genero"),
                        rs.getString("elemento")
                );
                jugadores.add(jugador);
            }
        }
        return jugadores;
    }
    public void cerrarConexion() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}

