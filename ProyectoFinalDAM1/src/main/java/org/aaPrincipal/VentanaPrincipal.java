package org.aaPrincipal;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.minijuego.minijuego;
import org.pruebas.p4betaconscrol;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.List;

import static org.minijuego.minijuego.iniciar;

public class VentanaPrincipal extends All_In implements ActionListener, NativeKeyListener {
    JFrame ventanaPrincipal = new JFrame();
    All_In all = new All_In();

    int tamanoX = all.tPantallaX;
    int tamanoY = all.tPantallaY;

    List<JButton> buttons = all.bVPrincipal;

    //variable para imagen
    Image backgroundImage = null;

    //buton
    JButton bSalir = all.bSalir; // Asegúrate de inicializar el botón
    JButton bJuego = all.bJuego;

    public VentanaPrincipal() {
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaPrincipal.setTitle("Ventana Principal");
        ventanaPrincipal.setResizable(true);
        ventanaPrincipal.setLocationRelativeTo(null);
        ventanaPrincipal.setBounds(0, 0, tamanoX, tamanoY);

        // Cargar la imagen de fondo
        try {
            backgroundImage = ImageIO.read(getClass().getResource("/bg.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
            backgroundImage = null;
        }

        // Panel personalizado para dibujar la imagen adaptada al tamaño del JFrame
        JPanel contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        contentPane.setLayout(null); // Desactivar el layout manager para usar posicionamiento absoluto
        ventanaPrincipal.setContentPane(contentPane);

        // Añadir botones
        bSalir.addActionListener(this);
        contentPane.add(bSalir);
        bJuego.addActionListener(this);
        contentPane.add(bJuego);

        // Hacer visible la ventana
        ventanaPrincipal.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bSalir) {
            BufferedWriter bw = null;
            try {
                bw = new BufferedWriter(new FileWriter("inazuma.txt",true));
                bw.flush();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } finally {
                try {
                    bw.close();
                }catch (Exception exception){
                    System.out.println("Error al cerrar el archivo");
                }
            }
            System.exit(0);

        } else if (e.getSource() == bJuego) {
            new p4betaconscrol();
            ventanaPrincipal.setVisible(false);
        }
    }

    public static void main(String[] args) {

        try {
            GlobalScreen.registerNativeHook();
            GlobalScreen.addNativeKeyListener(new VentanaPrincipal());
        } catch (NativeHookException e) {
            System.err.println("ha ocurrido un error con la aplicacion. Tipo de error:" + e.getMessage());
        }

        //new VentanaPrincipal();


    }

    String mEasterEgg = "";
    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {

        mEasterEgg += NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode());


        if (mEasterEgg.equalsIgnoreCase("INAZUMA")) {
            System.out.println(mEasterEgg);
            iniciar();
            ventanaPrincipal.setVisible(false);
        }
       
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {

    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {

    }
}
