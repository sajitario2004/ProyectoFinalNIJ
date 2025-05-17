package org.Controlador;

import org.Clases.Historial;
import org.Clases.HistorialDAO;
import org.Clases.Jugador;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HistorialContr {

    public static void EscribirHistorial(Historial historial) {
        final String nombre_fichero="historial.txt";
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(nombre_fichero));
                bw.write(historial.toString());
                bw.newLine();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                bw.close();
            }catch (Exception e){

            }

        }
    }
    public static List<Historial> ListaHistorialFichero() {
        List<Historial> listahisto = new ArrayList<Historial>();
        BufferedReader br = null;
        try {
            String nombre_fichero = "historial.txt";
            br = new BufferedReader(new FileReader(nombre_fichero));
            String linea = br.readLine();
            while (linea != null) {
                String[] datos = linea.split(",");
                if (datos.length == 4) {
                    int id = Integer.parseInt(datos[0]);
                    String nombre = datos[1];
                    int tiempo = Integer.parseInt(datos[2]);
                    int intentos = Integer.parseInt(datos[3]);

                    Historial a = new Historial(id, nombre, tiempo, intentos);
                    listahisto.add(a);
                }
                linea = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
            }
        }
        return listahisto;
    }

    public void borrarFichero(){
        BufferedWriter br = null;
        try {
            final String nombre_fichero="historial.txt";
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
