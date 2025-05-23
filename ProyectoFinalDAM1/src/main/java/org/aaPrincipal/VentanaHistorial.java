package org.aaPrincipal;

import org.Clases.Historial;
import org.Clases.HistorialDAO;
import org.Clases.Jugador;
import org.Controlador.HistorialContr;
import org.Controlador.JugadorContr;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.Controlador.HistorialContr.ListaHistorialFichero;
import static org.Controlador.JugadorContr.ListaJugadoresFichero;


public class VentanaHistorial extends JFrame implements ActionListener {
    JFrame ventanaHistorial = new JFrame();
    All_In all = new All_In();
    int tamanoX = all.tPantallaX;
    int tamanoY = all.tPantallaY;

    //panelse y ventana
    JScrollPane scrollPane;
    JPanel panelPrincipal = new JPanel();


    //variable para imagen
    Image backgroundImage = null;

    //String aux
    String nomJugadores;
    int contAux = 0;
    //botones
    JButton bSalir = all.bSalir;
    JButton bVolverVP = all.bVolverVPricipal;

    List<Historial> historial;

    public VentanaHistorial() throws SQLException {
        ventanaHistorial.setTitle("Ventana Jugadores");
        ventanaHistorial.setResizable(true);
        ventanaHistorial.setLocationRelativeTo(null);
        ventanaHistorial.setBounds(0, 0, tamanoX, tamanoY);

        //Cargar la imagen de fondo
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
        // Desactivar el layout manager para usar posicionamiento absoluto
        contentPane.setLayout(null);
        // Configuración del panel de nombres
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        scrollPane = new JScrollPane(panelPrincipal);
        scrollPane.setBounds(tamanoX/100*30, 50, tamanoX/100*40, tamanoY - 100); // Ajusta el tamaño y la posición
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        ventanaHistorial.setContentPane(contentPane);



        bSalir.addActionListener(this);
        contentPane.add(bSalir);
        bVolverVP.addActionListener(this);
        contentPane.add(bVolverVP);
        contentPane.add(scrollPane);

        historial = ListaHistorialFichero();

        Iterator it = historial.iterator();
        while (it.hasNext()){
            Historial itHisto = (Historial) it.next();
            nomJugadores = itHisto.getNombre() + ", " + itHisto.getIntentos() +"\n";
            addName();
        }



        ventanaHistorial.setVisible(true);
    }

    public void addName(){


        String name = nomJugadores;
        JLabel nameLabel = new JLabel(name);
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        nameLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        panelPrincipal.add(nameLabel);
        panelPrincipal.revalidate();
        // Hacer scroll hasta el final, esto lo hago con lamda por que si no no hay
        // huevos ha hacer que el scrollpanel se valla autoincrementando con los nombres introducidos
        SwingUtilities.invokeLater(() -> {
            JScrollBar vertical = scrollPane.getVerticalScrollBar();
            vertical.setValue(vertical.getMaximum());
        });
        String lineas = "-----------------------------------";
        JLabel lineasLabel = new JLabel(lineas);
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        nameLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        panelPrincipal.add(lineasLabel);
        panelPrincipal.revalidate();
        SwingUtilities.invokeLater(() -> {
            JScrollBar vertical = scrollPane.getVerticalScrollBar();
            vertical.setValue(vertical.getMaximum());
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (bSalir == e.getSource()){
            System.exit(0);
            HistorialContr.borrarFichero();
            JugadorContr.borrarFichero();
        } else if (bVolverVP == e.getSource()) {
            new VentanaPrincipal();
            ventanaHistorial.setVisible(false);
        }
    }

    public static List<String> getNombres(){
        List<String> nombres = new ArrayList<>();
        return null;

    }

    public static void main(String[] args) throws SQLException {
        new VentanaHistorial();
    }

}
