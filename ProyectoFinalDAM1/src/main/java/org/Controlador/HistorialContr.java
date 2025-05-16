package org.Controlador;

import org.Clases.Historial;
import org.Clases.HistorialDAO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class HistorialContr {


    public static void ListaHistorial(){
        final String nombre_fichero="historial.txt";
        BufferedWriter br = null;
        try {
            br = new BufferedWriter(new FileWriter(nombre_fichero));
            List<Historial> listahistorial = new HistorialDAO().obtenerTodos();
            Iterator<Historial> it = listahistorial.iterator();
            while (it.hasNext()) {
                Historial a = it.next();
                br.write(a.toString());
                br.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
            }catch (Exception e){

            }

        }
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
