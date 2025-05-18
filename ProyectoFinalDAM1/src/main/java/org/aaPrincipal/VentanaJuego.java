package org.aaPrincipal;

import org.Clases.Historial;
import org.Clases.HistorialDAO;
import org.Clases.Jugador;
import org.Controlador.HistorialContr;
import org.Controlador.JugadorContr;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

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

import static org.Controlador.HistorialContr.EscribirHistorial;
import static org.Controlador.JugadorContr.ListaJugadoresFichero;

public class VentanaJuego extends JFrame implements ActionListener, NativeKeyListener {
    JFrame ventanaJuego = new JFrame();
    All_In all = new All_In();
    int tamanoX = all.tPantallaX;
    int tamanoY = all.tPantallaY;

    Image backgroundImage = null;
    Image cayetanoEasterEgg = null;

    JScrollPane scrollPane;
    JPanel panelPrincipal = new JPanel();

    //jugador random
    Jugador random;
    //lista con todos los jugadores
    List<Jugador> jugadores;
    //lista de nombres de los jugadores
    List<String> nombJugadores;
    //Lista de jugadores ya probados
    List<String> nombUsados = new ArrayList<>();


    // cajas de texto y botones
    JTextField inputText = new JTextField();
    JButton bSalir = all.bSalir;
    JButton bVolver = all.bVolverVPricipal;
    JButton bIntroducir = new JButton("Introducir");
    JButton bMostrarJugadores = all.bMostrarJugadores;

    // cosas Jugadores
    JTextField inputUsuario= new JTextField("Nombre Usuario");
    int contIntentos =0;

    public VentanaJuego() {
        ventanaJuego.setTitle("Ventana Juego");
        ventanaJuego.setResizable(true);
        ventanaJuego.setLocationRelativeTo(null);
        ventanaJuego.setBounds(0, 0, tamanoX, tamanoY);


        //Caja de texto con el usuario del jugador
        inputUsuario.setBounds(tamanoX/2 - 200, 0, 400, 50);
        inputUsuario.setFont(new Font("SansSerif", Font.BOLD, 28));
        //inputUsuario.;

        // Cargar la imagen de fondo
        try {
            backgroundImage = ImageIO.read(getClass().getResource("/bg.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
            backgroundImage = null;
        }


        // Caja de texto usuario


        //Mostrar jugadores boton
        bMostrarJugadores.setBounds(50,tamanoY - 100, 300 ,50);

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
        contentPane.setLayout(null);
        ventanaJuego.setContentPane(contentPane);


        // Configuración del panel de nombres
        panelPrincipal.setLayout(new GridLayout(0, 5, 10, 10));
        panelPrincipal.setBackground(Color.DARK_GRAY);
        scrollPane = new JScrollPane(panelPrincipal);
        scrollPane.setBounds(25, 70, tamanoX - 60, tamanoY - 200);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);


        // Configuración del campo de texto y botón para agregar nombres
        inputText.setBounds(400, tamanoY - 100, (tamanoX-800), 50);
        inputText.setFont(new Font("Arial", Font.BOLD, 32));
        bIntroducir.setBounds(tamanoX - 300, tamanoY - 100, 200, 50);
        bIntroducir.setFont(new Font("Arial", Font.BOLD, 32));
        bIntroducir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    addName();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        // Añadir componentes al panel de contenido
        contentPane.add(bSalir);
        bSalir.addActionListener(this);
        contentPane.add(bVolver);
        bVolver.addActionListener(this);
        contentPane.add(bMostrarJugadores);
        bMostrarJugadores.addActionListener(this);

        contentPane.add(scrollPane);
        contentPane.add(inputText);
        contentPane.add(bIntroducir);
        contentPane.add(inputUsuario);

        // Hacer visible la ventana
        ventanaJuego.setVisible(true);
    }
    public static void cayetano(ImageIcon cayetanoEasterEgg, String message) {
        // Mostrar la imagen junto con un mensaje
        JOptionPane.showMessageDialog(
                null,
                message,
                "Título",
                JOptionPane.INFORMATION_MESSAGE,
                cayetanoEasterEgg);
    }

    String mEasterEgg = "";
    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {

        mEasterEgg += NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode());

        if (mEasterEgg.equalsIgnoreCase("CAYETANO")) {
            //System.out.println(mEasterEgg);
            ImageIcon FotoCayetano = new ImageIcon(getClass().getResource("/cayetano.jpg"));
            cayetano(FotoCayetano, "Has desbloqueado el jugador secreto CAYETANO-SAN");
            ventanaJuego.setVisible(false);
        }

    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {

    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {

    }

    public void addName() throws SQLException {
        jugadores = ListaJugadoresFichero();

        String nombreUsu = inputUsuario.getText();
        contIntentos++;

        nombresJugadores();
        if(random == null) {
            generateRandom();
            caracteristicasScroll();
        }

        //datos Jugador Random
        String nombreRandom = random.getNombre();
        String equipoJugadorRandom = random.getEquipo();
        String posicionRandom = random.getPosicion();
        String generoRandom = random.getGenero();
        String elementoRandom = random.getElemento();


        String nombreInput = "";
        String equipoJugadorInput = "";
        String posicionInput = "";
        String generoInput = "";
        String elementoInput = "";

        String name = inputText.getText().trim();
        //datos Jugador introducido
        Iterator<Jugador> iterator = jugadores.iterator();
        while (iterator.hasNext()) {
            Jugador jugador = iterator.next();
            if (jugador.getNombre().equals(name)) {
                nombreInput = jugador.getNombre();
                equipoJugadorInput = jugador.getEquipo();
                posicionInput = jugador.getPosicion();
                generoInput = jugador.getGenero();
                elementoInput = jugador.getElemento();
            }
        }
        if (!name.isEmpty()) {
            if (nombJugadores.contains(name)) {
                if (!nombUsados.contains(name)) {

                    //Variables comparadoras y que van al lable
                    JLabel nombreLabel = new JLabel(nombreInput);
                    //ALINEAR ARRIBA VETICAL
                    nombreLabel.setVerticalAlignment(SwingConstants.TOP);
                    //ALINEAR CENTRO HORIZONTAL
                    nombreLabel.setHorizontalAlignment(SwingConstants.CENTER);
                    //Fuentes y tamaño de la letra
                    nombreLabel.setFont(new Font("SansSerif", Font.BOLD, 32));
                    nombreLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
                    if (nombreLabel.getText().equalsIgnoreCase(nombreRandom)) {
                        nombreLabel.setForeground(Color.green);
                    }else {
                        nombreLabel.setForeground(Color.red);
                    }
                    panelPrincipal.add(nombreLabel);
                    panelPrincipal.revalidate();
                    SwingUtilities.invokeLater(() -> {
                        JScrollBar vertical = scrollPane.getVerticalScrollBar();
                        vertical.setValue(vertical.getMaximum());
                    });
                    nombUsados.add(nombreInput);

                    //tiempecito de espera por que le cuesta cargar en el ordenador de clase. Aunque me gusta mas la variable timer
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    JLabel equipoLabel = new JLabel(equipoJugadorInput);
                    //ALINEAR ARRIBA VETICAL
                    equipoLabel.setVerticalAlignment(SwingConstants.TOP);
                    //ALINEAR CENTRO HORIZONTAL
                    equipoLabel.setHorizontalAlignment(SwingConstants.CENTER);
                    //Fuentes y tamaño de la letra
                    equipoLabel.setFont(new Font("SansSerif", Font.BOLD, 32));
                    equipoLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
                    if (equipoLabel.getText().equalsIgnoreCase(equipoJugadorRandom)) {
                        equipoLabel.setForeground(Color.green);
                    }else {
                        equipoLabel.setForeground(Color.red);
                    }
                    panelPrincipal.add(equipoLabel);
                    panelPrincipal.revalidate();
                    SwingUtilities.invokeLater(() -> {
                        JScrollBar vertical = scrollPane.getVerticalScrollBar();
                        vertical.setValue(vertical.getMaximum());
                    });

                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    JLabel posicionLabel = new JLabel(posicionInput);
                    //ALINEAR ARRIBA VETICAL
                    posicionLabel.setVerticalAlignment(SwingConstants.TOP);
                    //ALINEAR CENTRO HORIZONTAL
                    posicionLabel.setHorizontalAlignment(SwingConstants.CENTER);
                    //Fuentes y tamaño de la letra
                    posicionLabel.setFont(new Font("SansSerif", Font.BOLD, 32));
                    posicionLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
                    if (posicionLabel.getText().equalsIgnoreCase(posicionRandom)) {
                        posicionLabel.setForeground(Color.green);
                    }else {

                        // colorear en naranja el texto en el caso de que contenga uno de los datos
                        posicionLabel.setForeground(Color.RED);

                    }
                    panelPrincipal.add(posicionLabel);
                    panelPrincipal.revalidate();
                    SwingUtilities.invokeLater(() -> {
                        JScrollBar vertical = scrollPane.getVerticalScrollBar();
                        vertical.setValue(vertical.getMaximum());
                    });

                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    JLabel generoLabel = new JLabel(generoInput);
                    //ALINEAR ARRIBA VETICAL
                    generoLabel.setVerticalAlignment(SwingConstants.TOP);
                    //ALINEAR CENTRO HORIZONTAL
                    generoLabel.setHorizontalAlignment(SwingConstants.CENTER);
                    //Fuentes y tamaño de la letra
                    generoLabel.setFont(new Font("SansSerif", Font.BOLD, 32));
                    generoLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
                    if (generoLabel.getText().equalsIgnoreCase(generoRandom)) {
                        generoLabel.setForeground(Color.green);
                    }else {
                        generoLabel.setForeground(Color.red);
                    }
                    panelPrincipal.add(generoLabel);
                    panelPrincipal.revalidate();
                    SwingUtilities.invokeLater(() -> {
                        JScrollBar vertical = scrollPane.getVerticalScrollBar();
                        vertical.setValue(vertical.getMaximum());
                    });

                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    JLabel elementoLabel = new JLabel(elementoInput);
                    //ALINEAR ARRIBA VETICAL
                    elementoLabel.setVerticalAlignment(SwingConstants.TOP);
                    //ALINEAR CENTRO HORIZONTAL
                    elementoLabel.setHorizontalAlignment(SwingConstants.CENTER);
                    //Fuentes y tamaño de la letra
                    elementoLabel.setFont(new Font("SansSerif", Font.BOLD, 32));
                    elementoLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
                    if (elementoLabel.getText().equalsIgnoreCase(elementoRandom)) {
                        elementoLabel.setForeground(Color.green);
                    }else {
                        elementoLabel.setForeground(Color.red);
                    }
                    panelPrincipal.add(elementoLabel);
                    panelPrincipal.revalidate();
                    SwingUtilities.invokeLater(() -> {
                        JScrollBar vertical = scrollPane.getVerticalScrollBar();
                        vertical.setValue(vertical.getMaximum());
                    });



                }else {
                    popupYaAgregado();
                }
            }else{
                popupNombreNoExiste();

            }
            inputText.setText("");
            inputText.requestFocus();
        }else {
            popupCajaDeTextoVacia();
        }

        if (nombreRandom.equals(name)){
            popupHasGanado();
            Historial historial = new Historial();
            //compurebo si el usuario no ha introducido su usuario y le doy uno random
            if (!nombreUsu.isEmpty()) {
                historial.setNombre(nombreUsu);
            }else {
                historial.setNombre("TiempoMin");
            }
            historial.setIntentos(contIntentos);
            List<Historial>lista = new ArrayList<>( new HistorialDAO().obtenerTodos());
            int a =0;
            if (lista.isEmpty()){
                a++;
            }else{
              a= lista.size()+1;
            }
            historial.setId(a);
            EscribirHistorial(historial);

        }
        nombJugadores = null;

    }

    public void caracteristicasScroll(){
        JLabel nombre = new JLabel("Nombre");
        nombre.setForeground(Color.WHITE);
        //ALINEAR ARRIBA VETICAL
        nombre.setVerticalAlignment(SwingConstants.TOP);
        //ALINEAR CENTRO HORIZONTAL
        nombre.setHorizontalAlignment(SwingConstants.CENTER);
        //Fuentes y tamaño de la letra
        nombre.setFont(new Font("SansSerif", Font.BOLD, 32));
        nombre.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        panelPrincipal.add(nombre);
        panelPrincipal.revalidate();
        SwingUtilities.invokeLater(() -> {
            JScrollBar vertical = scrollPane.getVerticalScrollBar();
            vertical.setValue(vertical.getMaximum());
        });

        JLabel equipo = new JLabel("Equipo");
        equipo.setForeground(Color.WHITE);
        //ALINEAR ARRIBA VETICAL
        equipo.setVerticalAlignment(SwingConstants.TOP);
        //ALINEAR CENTRO HORIZONTAL
        equipo.setHorizontalAlignment(SwingConstants.CENTER);
        //Fuentes y tamaño de la letra
        equipo.setFont(new Font("SansSerif", Font.BOLD, 32));
        equipo.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        panelPrincipal.add(equipo);
        panelPrincipal.revalidate();
        SwingUtilities.invokeLater(() -> {
            JScrollBar vertical = scrollPane.getVerticalScrollBar();
            vertical.setValue(vertical.getMaximum());
        });

        JLabel posicion = new JLabel("Posicion");
        posicion.setForeground(Color.WHITE);
        //ALINEAR ARRIBA VETICAL
        posicion.setVerticalAlignment(SwingConstants.TOP);
        //ALINEAR CENTRO HORIZONTAL
        posicion.setHorizontalAlignment(SwingConstants.CENTER);
        //Fuentes y tamaño de la letra
        posicion.setFont(new Font("SansSerif", Font.BOLD, 32));
        posicion.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        panelPrincipal.add(posicion);
        panelPrincipal.revalidate();
        SwingUtilities.invokeLater(() -> {
            JScrollBar vertical = scrollPane.getVerticalScrollBar();
            vertical.setValue(vertical.getMaximum());
        });

        JLabel genero = new JLabel("Genero");
        genero.setForeground(Color.WHITE);
        //ALINEAR ARRIBA VETICAL
        genero.setVerticalAlignment(SwingConstants.TOP);
        //ALINEAR CENTRO HORIZONTAL
        genero.setHorizontalAlignment(SwingConstants.CENTER);
        //Fuentes y tamaño de la letra
        genero.setFont(new Font("SansSerif", Font.BOLD, 32));
        genero.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        panelPrincipal.add(genero);
        panelPrincipal.revalidate();
        SwingUtilities.invokeLater(() -> {
            JScrollBar vertical = scrollPane.getVerticalScrollBar();
            vertical.setValue(vertical.getMaximum());
        });

        JLabel elemento = new JLabel("Elemento");
        elemento.setForeground(Color.WHITE);
        //ALINEAR ARRIBA VETICAL
        elemento.setVerticalAlignment(SwingConstants.TOP);
        //ALINEAR CENTRO HORIZONTAL
        elemento.setHorizontalAlignment(SwingConstants.CENTER);
        //Fuentes y tamaño de la letra
        elemento.setFont(new Font("SansSerif", Font.BOLD, 32));
        elemento.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        panelPrincipal.add(elemento);
        panelPrincipal.revalidate();
        SwingUtilities.invokeLater(() -> {
            JScrollBar vertical = scrollPane.getVerticalScrollBar();
            vertical.setValue(vertical.getMaximum());
        });
    }

    public void nombresJugadores() {
        jugadores = ListaJugadoresFichero();
        nombJugadores = new ArrayList<>();
        Iterator<Jugador> iterator = jugadores.iterator();
        while (iterator.hasNext()) {
            Jugador jugador = iterator.next();
            nombJugadores.add(jugador.getNombre());
        }
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == bSalir){
            HistorialContr.borrarFichero();
            JugadorContr.borrarFichero();
            System.exit(0);
        } else if (e.getSource() == bVolver) {
            new VentanaPrincipal();
            ventanaJuego.setVisible(false);
        } else if (e.getSource() == bMostrarJugadores) {
            new VentanaJugadores();
        }
    }

    public void generateRandom(){
        int numrandom = (int) (Math.random()*100);
        random = jugadores.get(numrandom);

    }

    public void popupNombreNoExiste(){
        //esto me lo decia un panchito de un video de como hacer los popup
        JOptionPane.showMessageDialog(

                null,

                "El jugador no existe o está mal escrito",
                "Nombre no encontrado",
                JOptionPane.WARNING_MESSAGE
        );
    }

    public void popupCajaDeTextoVacia(){
        //esto me lo decia un panchito de un video de como hacer los popup
        JOptionPane.showMessageDialog(

                null,

                "La caja de texto esta vacia",
                "Nombre no encontrado",
                JOptionPane.WARNING_MESSAGE
        );
    }

    public void popupYaAgregado(){
        //esto me lo decia un panchito de un video de como hacer los popup
        JOptionPane.showMessageDialog(

                null,

                "El jugador ya ha sido introducido",
                "Nombre no encontrado",
                JOptionPane.WARNING_MESSAGE
        );
    }

    public void popupHasGanado(){
        //esto me lo decia un panchito de un video de como hacer los popup
        JOptionPane.showMessageDialog(

                null,

                "Has ganado Felicidades",
                "Nombre no encontrado",
                JOptionPane.YES_OPTION
        );
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
