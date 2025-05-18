package org.Controlador;

import org.Clases.Jugador;
import org.Clases.JugadorDAO;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JugadorContr {
    private final static String nombre_fichero="Jugadores.txt";
    public static void ListaJugadores(){

        BufferedWriter br = null;
        try {
            br = new BufferedWriter(new FileWriter(nombre_fichero));
            List<Jugador> jugadores = new JugadorDAO().obtenerTodos();
            Iterator<Jugador> it = jugadores.iterator();
            while (it.hasNext()) {
                Jugador a = it.next();
                br.write(a.toString());
                br.newLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public static   List<Jugador> ListaJugadoresFichero(){
        List<Jugador> listajuga = new ArrayList<Jugador>();
        BufferedReader br = null;
        try {
            ListaJugadores();
            br = new BufferedReader (new FileReader(nombre_fichero));
            String linea = br.readLine();
            while(linea!=null){
                String[] datos = linea.split(",");
                Jugador a = new Jugador(Integer.parseInt(datos[0]),datos[1],datos[2],datos[3],datos[4],datos[5]);
                listajuga.add(a);
                linea = br.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                br.close();
            } catch (IOException e) {}
        }
        return listajuga;
    }

    public static void borrarFichero(){
        BufferedWriter br = null;
        try {
            br =  new BufferedWriter(new FileWriter(nombre_fichero));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
