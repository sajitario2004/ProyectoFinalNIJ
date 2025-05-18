package org.Clases;

import java.sql.SQLException;
import java.util.List;

public interface IntDAO<T> {

    void crear(String fichero ) throws SQLException;
    void actualizar(T o) throws SQLException;
    void borrar(T o) throws SQLException;
    T obtenerPorId(int id , String fichero) throws SQLException;
    List<T> obtenerTodos() throws SQLException;

    
}
