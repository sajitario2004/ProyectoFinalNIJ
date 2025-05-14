package org.Clases;

import java.util.List;

public interface IHistorial{
	
	void insertar(Historial jugador);
    void actualizar(Historial jugador);
    void eliminar(int id);
    Historial obtenerPorId(int id);
    List<Historial> obtenerTodos();
    
}
