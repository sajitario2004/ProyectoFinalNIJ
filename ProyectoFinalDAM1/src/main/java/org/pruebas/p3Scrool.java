package org.pruebas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class p3Scrool extends JFrame {
    private JPanel namesPanel;
    private JScrollPane scrollPane;
    private JTextField inputField;
    private JButton addButton;

    public p3Scrool() {
        setTitle("Inazuma Eleven Loldle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);
        setLocationRelativeTo(null);

        // Panel principal con BorderLayout
        setLayout(new BorderLayout());

        // Panel para los nombres con BoxLayout en Y_AXIS
        namesPanel = new JPanel();
        namesPanel.setLayout(new BoxLayout(namesPanel, BoxLayout.Y_AXIS));
        namesPanel.setBackground(Color.WHITE);

        // JScrollPane que contiene el panel de nombres
        scrollPane = new JScrollPane(namesPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Área inferior con input y botón
        JPanel inputPanel = new JPanel(new BorderLayout(5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inputField = new JTextField();
        inputField.setFont(new Font("SansSerif", Font.PLAIN, 16));
        addButton = new JButton("Agregar");

        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        // Acción del botón para agregar nombres
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addName();
            }
        });

        // Permitir pulsar Enter para agregar nombre
        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addName();
            }
        });
    }

    // Método para agregar nombre al panel
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            p3Scrool frame = new p3Scrool();
            frame.setVisible(true);
        });
    }
}


