package org.aaPrincipal;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class VentanaJuego extends JFrame implements ActionListener {
    JFrame ventanaJuego = new JFrame();
    All_In all = new All_In();
    int tamanoX = all.tPantallaX;
    int tamanoY = all.tPantallaY;

    Image backgroundImage = null;

    JScrollPane scrollPane;
    JPanel panelPrincipal;

    JButton bSalir = all.bSalir;

    public VentanaJuego() {
        ventanaJuego.setTitle("Ventana Juego");
        ventanaJuego.setResizable(true);
        ventanaJuego.setLocationRelativeTo(null);
        ventanaJuego.setBounds(0, 0, tamanoX, tamanoY);

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
        ventanaJuego.setContentPane(contentPane);

        // Añadir botones
        bSalir.addActionListener(this);
        contentPane.add(bSalir);
        ventanaJuego.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new VentanaJuego();
    }
}
