package org.Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class HistorialDAO implements IHistorial{

    private static Connection conectar() {
        Connection con = null;

        String url = "jdbc:mysql://localhost/Inazuma";
        try {
            con = DriverManager.getConnection(url, "root", "1234");
        } catch (SQLException ex) {
            System.out.println("Error al conectar al SGBD.");
        }

        return con;
    }

    @Override
    public void insertar(Historial jugador) {

    }

    @Override
    public void actualizar(Historial jugador) {

    }

    @Override
    public void eliminar(int id) {

    }

    @Override
    public Historial obtenerPorId(int id) {
        return null;
    }

    @Override
    public List<Historial> obtenerTodos() {
        return List.of();
    }
}
