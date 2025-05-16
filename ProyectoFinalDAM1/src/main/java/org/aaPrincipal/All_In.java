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


    JTextField tUsuario;
    JButton bJuego;
    JButton bMostrarJugadores;
    JButton bHistorial;

    JButton bVolverVPricipal;

    //Paneles de scrool
    JScrollPane scrollJuego;
    JPanel panelJuego;

    JScrollPane scrollJugadores;
    JPanel panelJugadores;

    JScrollPane scrollHistorial;
    JPanel panelHistorial;

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

        //Boton volver
        // Configuración del botón de salida
        JButton bVolver = new JButton("<");
        int tVolverx = 100;
        int tVolverY = 50;
        bVolver.setBounds(0, 0, tVolverx, tVolverY);
        bVolver.setBackground(Color.BLUE);
        bVolver.setForeground(Color.WHITE);
        bVolver.setBorderPainted(false);
        bVolver.setFocusPainted(false);

        //Añadir MouseListener para el boton es como a:hover en html y tambien le da un color si no esta el raton encima
        bVolver.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                bVolver.setBackground(Color.CYAN);
                bVolver.setForeground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                bVolver.setBackground(Color.CYAN);
                bVolver.setForeground(Color.WHITE);
            }
        });
        this.bVolverVPricipal = bVolver;

        //Configuracion botonJugar
        JButton bJuego = new JButton("Iniciar");
        int xbJuego =(int) (tPantallaX/100*45) ;
        int ybJuego = (int) (tPantallaY/100*45) ;
        int wbJuego =(int) (tPantallaX/10) ;
        int hbJuego = (int) (tPantallaY/20) ;
        bJuego.setFont(new Font("Liberation Serif", Font.BOLD, 24));
        bJuego.setBounds(xbJuego, ybJuego, wbJuego, hbJuego);
        bJuego.setBackground(Color.orange);
        bJuego.setForeground(Color.WHITE);
        bJuego.setBorderPainted(false);
        bJuego.setFocusPainted(false);
        bJuego.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                bJuego.setBackground(Color.YELLOW);
                bJuego.setForeground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                bJuego.setBackground(Color.orange);
                bJuego.setForeground(Color.WHITE);
            }
        });
        this.bJuego = bJuego;

        //Boton MostrarJugadores
        JButton bMostrarJugadores = new JButton("Mostrar Jugadores");
        int xbMosJug =(int) (tPantallaX/100*45) ;
        int ybMosJug = (int) (tPantallaY/100*55) ;
        int wbMosJug =(int) (tPantallaX/10) ;
        int hbMosJug = (int) (tPantallaY/20) ;
        bMostrarJugadores.setFont(new Font("Liberation Serif", Font.BOLD, 24));
        bMostrarJugadores.setBounds(xbMosJug, ybMosJug, wbMosJug, hbMosJug);
        bMostrarJugadores.setBackground(Color.BLUE);
        bMostrarJugadores.setForeground(Color.WHITE);
        bMostrarJugadores.setBorderPainted(false);
        bMostrarJugadores.setFocusPainted(false);
        bMostrarJugadores.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                bMostrarJugadores.setBackground(Color.CYAN);
                bMostrarJugadores.setForeground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e) {

                bMostrarJugadores.setBackground(Color.BLUE);
                bMostrarJugadores.setForeground(Color.WHITE);
            }
        });
        this.bMostrarJugadores = bMostrarJugadores;

        //Boton historial
        JButton bHistorial = new JButton("Historial");
        int xbHistorial =(int) (tPantallaX/100*45) ;
        int ybHistorial = (int) (tPantallaY/100*65) ;
        int wbHistorial =(int) (tPantallaX/10) ;
        int hbHistorial = (int) (tPantallaY/20) ;
        bHistorial.setFont(new Font("Liberation Serif", Font.BOLD, 24));
        bHistorial.setBounds(xbHistorial, ybHistorial, wbHistorial, hbHistorial);
        bHistorial.setBackground(Color.RED);
        bHistorial.setForeground(Color.WHITE);
        bHistorial.setBorderPainted(false);
        bHistorial.setFocusPainted(false);
        bHistorial.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                bHistorial.setBackground(new Color(138, 0, 0));
                bHistorial.setForeground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e) {

                bHistorial.setBackground(Color.RED);
                bHistorial.setForeground(Color.WHITE);
            }
        });
        this.bHistorial = bHistorial;


        //Botones prinicpals





    }



}
