package org.aaPrincipal;

import org.Clases.Jugador;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.Controlador.JugadorContr.ListaJugadores;
import static org.minijuego.minijuego.iniciar;

public class VentanaJuego extends JFrame implements ActionListener, NativeKeyListener {
    JFrame ventanaJuego = new JFrame();
    All_In all = new All_In();
    int tamanoX = all.tPantallaX;
    int tamanoY = all.tPantallaY;

    Image backgroundImage = null;
    Image cayetanoEasterEgg = null;

    JScrollPane scrollPane;
    JPanel panelPrincipal = new JPanel();

    Jugador random;
    List<Jugador> jugadores;
    
    JTextField inputText = new JTextField();
    JButton bSalir = all.bSalir;
    JButton bVolver = all.bVolverVPricipal;
    JButton bIntroducir = new JButton("Introducir");


    public VentanaJuego() {
        ventanaJuego.setTitle("Ventana Juego");
        ventanaJuego.setResizable(true);
        ventanaJuego.setLocationRelativeTo(null);
        ventanaJuego.setBounds(0, 0, tamanoX, tamanoY);


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
        ventanaJuego.setContentPane(contentPane);


        // Configuración del panel de nombres
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        scrollPane = new JScrollPane(panelPrincipal);
        scrollPane.setBounds(10, 50, tamanoX - 20, tamanoY - 100); // Ajusta el tamaño y la posición
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Configuración del campo de texto y botón para agregar nombres
        inputText.setBounds(100, tamanoY - 40, tamanoX - 220, 40);
        bIntroducir.setBounds(tamanoX - 110, tamanoY - 40, 100, 30);
        bIntroducir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addName();
            }
        });

        // Añadir componentes al panel de contenido
        contentPane.add(bSalir);
        bSalir.addActionListener(this);
        contentPane.add(bVolver);
        bVolver.addActionListener(this);

        contentPane.add(scrollPane);
        contentPane.add(inputText);
        contentPane.add(bIntroducir);

        // Hacer visible la ventana
        ventanaJuego.setVisible(true);
    }
    public static void cayetano(ImageIcon cayetanoEasterEgg, String message) {

        // Mostrar la imagen junto con un mensaje
        JOptionPane.showMessageDialog(null, message, "Título", JOptionPane.INFORMATION_MESSAGE, cayetanoEasterEgg);
    }

    String mEasterEgg = "";
    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {

        mEasterEgg += NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode());


        if (mEasterEgg.equalsIgnoreCase("CAYETANO")) {
            //System.out.println(mEasterEgg);
            String rutaCayetano = "/calletano.jpg";
            ImageIcon FotoCayetano = new ImageIcon(getClass().getResource("/calletano.jpg"));
            cayetano(FotoCayetano, "Soy calletano SAN");
            ventanaJuego.setVisible(false);
        }

    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {

    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {

    }

    private void addName() {
        String name = inputText.getText().trim();
        if (!name.isEmpty()) {

            JLabel nameLabel = new JLabel(name);
            nameLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
            nameLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
            panelPrincipal.add(nameLabel);
            panelPrincipal.revalidate();
            SwingUtilities.invokeLater(() -> {
                JScrollBar vertical = scrollPane.getVerticalScrollBar();
                vertical.setValue(vertical.getMaximum());
            });
            inputText.setText("");
            inputText.requestFocus();
        }

    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == bSalir){
            System.exit(0);
        } else if (e.getSource() == bVolver) {
            new VentanaPrincipal();
            ventanaJuego.setVisible(false);
        }
    }

    public void generarRandom(){
        int numrandom = (int) (Math.random()*100);
        random =
    }

    public static void main(String[] args) {
        try {
            GlobalScreen.registerNativeHook();
            GlobalScreen.addNativeKeyListener(new VentanaJuego());
        } catch (NativeHookException e) {
            System.err.println("ha ocurrido un error con la aplicacion. Tipo de error:" + e.getMessage());
        }
    }
}
