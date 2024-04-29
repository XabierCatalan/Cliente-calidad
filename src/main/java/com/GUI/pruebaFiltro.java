package com.GUI;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class pruebaFiltro extends JFrame {
    private JComboBox<String> comboBox;
    private List<String> originalItems;

    public pruebaFiltro() {
        setTitle("Filterable JComboBox Example");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 150);

        // Items originales del JComboBox
        originalItems = new ArrayList<>();
        originalItems.add("Manzana");
        originalItems.add("Banana");
        originalItems.add("Cereza");
        originalItems.add("Durazno");
        originalItems.add("Uva");
        originalItems.add("Kiwi");
        originalItems.add("Naranja");

        // JComboBox
        comboBox = new JComboBox<>(originalItems.toArray(new String[0]));

        // JTextField para filtrar
        JTextField filterField = new JTextField();
        filterField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filterItems(filterField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filterItems(filterField.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filterItems(filterField.getText());
            }
        });

        // Layout
        setLayout(new BorderLayout());
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(comboBox, BorderLayout.NORTH);
        panel.add(filterField, BorderLayout.SOUTH);
        add(panel, BorderLayout.NORTH);
    }

    private void filterItems(String text) {
        List<String> filteredItems = new ArrayList<>();
        for (String item : originalItems) {
            if (item.toLowerCase().contains(text.toLowerCase())) {
                filteredItems.add(item);
            }
        }
        comboBox.setModel(new DefaultComboBoxModel<>(filteredItems.toArray(new String[0])));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new pruebaFiltro().setVisible(true);
        });
    }
}

