package org.Clases;

import java.util.List;

public interface Dao <Object>{
    public List<Object> obtenerTodos();
    public void insertar(Object o);
    public Object buscarporId(int id);
}
