package org.pruebas;

import org.aaPrincipal.All_In;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class p4betaconscrol extends All_In implements ActionListener {
    JFrame ventanaPrincipal = new JFrame();
    All_In all = new All_In();

    int tamanoX = all.tPantallaX;
    int tamanoY = all.tPantallaY;

    // Lista para almacenar los nombres
    List<JButton> buttons = all.bVPrincipal;

    // Variable para imagen
    Image backgroundImage = null;

    // Botón de salida
    JButton bSalir = new JButton();

    // Componentes para agregar nombres
    JTextField inputField = new JTextField();
    JButton addButton = new JButton("Agregar");
    JPanel namesPanel = new JPanel();
    JScrollPane scrollPane;

    public p4betaconscrol() {
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

        // Configuración del botón de salida
        bSalir.addActionListener(this);
        bSalir.setText(""); // Asegúrate de que el botón tenga texto
        int cSalidaX = all.tPantallaX - 100;
        int cSalidaY = 0;
        int tSalidaX = all.tPantallaX * 6 / 100;
        int tSalidaY = all.tPantallaY * 6 / 100;
        bSalir.setBounds(cSalidaX, cSalidaY, tSalidaX, tSalidaY);
        bSalir.setBackground(Color.RED);
        bSalir.setForeground(Color.WHITE);

        // Añadir MouseListener para el botón
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

        // Configuración del panel de nombres
        namesPanel.setLayout(new BoxLayout(namesPanel, BoxLayout.Y_AXIS));
        scrollPane = new JScrollPane(namesPanel);
        scrollPane.setBounds(10, 50, tamanoX - 20, tamanoY - 100); // Ajusta el tamaño y la posición
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Configuración del campo de texto y botón para agregar nombres
        inputField.setBounds(10, tamanoY - 40, tamanoX - 120, 30);
        addButton.setBounds(tamanoX - 110, tamanoY - 40, 100, 30);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addName();
            }
        });

        // Añadir componentes al panel de contenido
        contentPane.add(bSalir);
        contentPane.add(scrollPane);
        contentPane.add(inputField);
        contentPane.add(addButton);

        // Hacer visible la ventana
        ventanaPrincipal.setVisible(true);
    }

    private void addName() {
        String name = inputField.getText().trim();
        if (!name.isEmpty()) {
            JLabel nameLabel = new JLabel(name);
            nameLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
            nameLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
            namesPanel.add(nameLabel);
            namesPanel.revalidate();
            // Hacer scroll hasta el final
            SwingUtilities.invokeLater(() -> {
                JScrollBar vertical = scrollPane.getVerticalScrollBar();
                vertical.setValue(vertical.getMaximum());
            });
            inputField.setText("");
            inputField.requestFocus();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bSalir) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new p4betaconscrol();
    }
}