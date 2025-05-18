package org.Controlador;

import org.Clases.Historial;
import org.Clases.HistorialDAO;
import org.Clases.Jugador;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HistorialContr {
     private static final String nombre_fichero="Historial.txt";
    private static final String nombre_fichero2="Registro_Historial.txt";
    public static void EscribirHistorial(Historial historial) {

        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(nombre_fichero));
                bw.write(historial.toString());
                bw.newLine();
                new HistorialDAO().crear(nombre_fichero);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                bw.close();
            }catch (Exception e){

            }

        }
    }
    public static List<Historial> ListaHistorialFichero() throws SQLException {
        List<Historial> listahis = new ArrayList<Historial>();
        BufferedReader br = null;
        try {
            ListaHistorial();
            br = new BufferedReader (new FileReader(nombre_fichero2));
            String linea = br.readLine();
            while(linea!=null){
                String[] datos = linea.split(",");
                Historial a = new Historial(Integer.parseInt(datos[0]),datos[1],Integer.parseInt(datos[2]));
                listahis.add(a);
                linea = br.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                br.close();
            } catch (IOException e) {}
        }
        return listahis;
    }

    public static void ListaHistorial() throws SQLException {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(nombre_fichero2));
            List<Historial> lista = new HistorialDAO().obtenerTodos();
            Iterator<Historial>i = lista.iterator();
            while (i.hasNext()) {
                Historial h = i.next();
                bw.write(h.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                bw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public static void borrarFichero(){



        BufferedWriter br = null;
        BufferedWriter br2 = null;
        try {
            br =  new BufferedWriter(new FileWriter(nombre_fichero));
            br2 =  new BufferedWriter(new FileWriter(nombre_fichero2));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                br.close();
                br2.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
