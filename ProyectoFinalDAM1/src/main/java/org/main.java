package org;

import org.aaPrincipal.VentanaPrincipal;

import javax.swing.*;

public class main {
    public static void main(String[] args) {
        popupInicio();
        VentanaPrincipal.main(args);

    }

    public static void popupInicio(){
        //esto me lo decia un panchito de un video de como hacer los popup
        JOptionPane.showMessageDialog(

                null,

                "Importante en la base de datos tiene " +
                        "que existir el usuario: prueba y " +
                        "la contraseña tiene que ser 1234.\n Tambien se " +
                        "tiene que haber ejecutado el archivo sql" +
                        "agregado junto al proyecto /SQL/BaseDatos.sql .",
                "Leer antes de Jugar",
                JOptionPane.WARNING_MESSAGE
        );
    }
}
