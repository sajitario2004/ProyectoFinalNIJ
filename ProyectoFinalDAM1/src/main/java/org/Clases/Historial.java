package org.Clases;

public class Historial {
    private int id;
    private String nombre;
    private int tiempo;
    private int intentos;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
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

    public Historial(int id ,String nombre, int tiempo, int intentos) {
        this.id = id;
        this.nombre = nombre;
        this.tiempo = tiempo;
        this.intentos = intentos;
    }


    public Historial() {
    }

    @Override
    public String toString() {
        return "Historial{"+"nombre='" + nombre +", tiempo=" + tiempo + ", intentos=" + intentos + '}';
    }
}
