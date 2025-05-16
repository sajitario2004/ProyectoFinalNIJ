package org.Clases;

public class Jugador {
    private int id;
    private String nombre;
    private String equipo;
    private String posicion;
    private String genero;
    private String elemento;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    public Jugador(int id ,String nombre, String equipo, String posicion, String genero, String elemento) {
        this.id = id;
        this.nombre = nombre;
        this.equipo = equipo;
        this.posicion = posicion;
        this.genero = genero;
        this.elemento = elemento;
    }
    public Jugador(){}
    @Override
    public String toString() {
        return id +","+nombre+","+ equipo+","+ posicion+","+genero+","+ elemento;
    }
}
