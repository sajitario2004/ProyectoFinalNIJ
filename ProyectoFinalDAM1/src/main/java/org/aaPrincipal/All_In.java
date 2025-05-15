package org.aaPrincipal;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.module.Configuration;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class All_In {

    //tamaño de la pantalla
    public final int tPantallaY;
    public final int tPantallaX;

    JButton bSalir;

    JButton bJuego;
    JButton bMostrarJugadores;
    JButton Historial;

    //Lista de botones principales
    public List<JButton> bVPrincipal = new ArrayList<>();



    public All_In() {

        //Tamaño de la pantalla
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        this.tPantallaX = screenSize.width ;
        this.tPantallaY = screenSize.height ;

        //Boton de cerrar

        // Configuración del botón de salida
        JButton bSalir = new JButton();
        bSalir.setText("X"); // Asegúrate de que el botón tenga texto
        int cSalidaX = tPantallaX - 100;
        int cSalidaY = 0;
        int tSalidaX = 100;
        int tSalidaY = 50;
        bSalir.setBounds(cSalidaX, cSalidaY, tSalidaX, tSalidaY);
        bSalir.setBackground(Color.RED);
        bSalir.setForeground(Color.WHITE);
        bSalir.setBorderPainted(false);
        bSalir.setFocusPainted(false);

        //Añadir MouseListener para el boton es como a:hover en html y tambien le da un color si no esta el raton encima
        bSalir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                bSalir.setBackground(new Color(138, 0, 0));
                bSalir.setForeground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                bSalir.setBackground(Color.RED);
                bSalir.setForeground(Color.WHITE);
            }
        });
        this.bSalir = bSalir;

        //Configuracion botonJugar

        JButton bJuego = new JButton("Iniciar");
        int xbJuego =(int) (tPantallaX/100*45) ;
        int ybJuego = (int) (tPantallaY/100*45) ;
        int wbJuego =(int) (tPantallaX/10) ;
        int hbJuego = (int) (tPantallaY/20) ;
        bJuego.setBounds(xbJuego, ybJuego, wbJuego, hbJuego);
        bJuego.setBackground(Color.orange);
        bJuego.setForeground(Color.WHITE);
        bJuego.setBorderPainted(false);
        bJuego.setFocusPainted(false);
        bJuego.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                bJuego.setBackground(new Color(138, 0, 0));
                bJuego.setForeground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                bJuego.setBackground(Color.orange);
                bJuego.setForeground(Color.WHITE);
            }
        });
        this.bJuego = bJuego;

        //Botones prinicpals




    }



}
