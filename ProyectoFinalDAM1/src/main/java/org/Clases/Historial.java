package org.Clases;

public class Historial {
    private int id;
    private String nombre;
    private int intentos;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Historial(int id ,String nombre,int intentos) {
        this.id = id;
        this.nombre = nombre;
        this.intentos = intentos;
    }

    public Historial() {
    }

    @Override
    public String toString() {
        return id+","+nombre+","+intentos;
    }
}


