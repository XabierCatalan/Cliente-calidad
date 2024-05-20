package com.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.springframework.data.geo.Point;

import javax.swing.JScrollPane;

import com.Controller.VentanaInicialController;
import com.GUI.VentanaAyuda;

public class VentanaInicial extends JFrame{
    static VentanaInicialController controller = new VentanaInicialController();

    int numAciertos = 0;
    int anchoTabla = 3;
    int altoTabla = 3;

    //lista de nombres de pokemons
    HashMap<Integer , List<String>> juego = controller.crearJuego();
    ArrayList<String> listapokemons = (ArrayList<String>) controller.getlistapokemons();
    ArrayList<String> condicionesTipo = (ArrayList<String>) controller.getCondicionesTipo();
    ArrayList<String> condicionesRegion = (ArrayList<String>) controller.getCondicionesRegion();

    //Botones
    JButton ayuda = new JButton("Ayuda");
    JButton listap = new JButton("listaPokemons");
    JButton aceptar = new JButton("Aceptar");
    JButton botonSi;
    JButton botonNo;
    JButton rendirse;
    JTable table;
    DefaultTableModel model;
    JScrollPane scrollPane;

    //desplegable con los pokemons
    JComboBox<String> comboBox;

    //ventanas
    VentanaAyuda ventanaAyuda = new VentanaAyuda();

    JLabel creditos;

    public VentanaInicial() {

       initComponents();
        
        setTitle("Pokedoku");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initComponents() {
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());

        ayuda = new JButton("Ayuda");
        listap = new JButton("listaPokemons");
        aceptar = new JButton("Aceptar");
        botonSi = new JButton("Sí");
        botonNo = new JButton("No");
        rendirse = new JButton("Me rindo");

         // Crear la tabla
         createJTable();
        
         
        // Crear un ComboBox editable con autocompletado
        comboBox = new JComboBox<>(listapokemons.toArray(new String[0]));
        comboBox.setEditable(true);


        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        panel.add(ayuda);
        panel.add(listap);
        panel.add(aceptar);
        panel.add(botonSi);
        panel.add(botonNo);
        botonSi.setVisible(false);
        botonNo.setVisible(false);
        panel.add(comboBox);


        creditos = new JLabel("Grupo PSC-12: Oscar Perez, Xabier Catalan, Unai Basterretxea, Jon Ander Olivera");

        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onAceptarButtonClick();
            }
        });

        rendirse.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            //    for (int numCol : model.getColumnCount()+1) {
            //        for (int numFila : model.getRowCount()) {
            //            int num = numFila + (numCol * 3) - 2;
             //           model.setValueAt(juego.get(num).get(0), numFila, numCol);
             //       }
             //   }
            }          
        });

        cp.add(panel, BorderLayout.NORTH);
        cp.add(scrollPane, BorderLayout.CENTER);
        cp.add(creditos, BorderLayout.SOUTH);

        ayuda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                ventanaAyuda.setVisible(true);
            }
        });

    }
    
    private void filterComboBoxItems(String filterText) {
        DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) comboBox.getModel();
        model.removeAllElements();

        for (String item : listapokemons) {
            if (item.toLowerCase().startsWith(filterText)) {
                model.addElement(item);
            }
        }

        comboBox.setPopupVisible(model.getSize() > 0);
    }


    public void createJTable() {
        // Datos de ejemplo para la tabla
        anchoTabla = condicionesTipo.size();
        altoTabla = condicionesRegion.size();

        String[][] data = new String[altoTabla][anchoTabla+1];

        for (int i = 0; i < condicionesRegion.size(); i++) {
            data[i][0] = condicionesRegion.get(i); 
        }

        // Nombres de las columnas
        String[] columnNames = new String[condicionesTipo.size()+1];
        Arrays.fill(columnNames, "");
        int cont = 1;

        for (String t : condicionesTipo) {
            columnNames[cont]=t;
            cont++;
        }
        
        model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hacer que todas las celdas sean no editables
            }
        };

        // Crear la tabla con el modelo no editable
        table = new JTable(model);


        // Agregar la tabla a un JScrollPane para que tenga barras de desplazamiento
        scrollPane = new JScrollPane(table);

        // Agregar el JScrollPane a la ventana
        add(scrollPane);
    }

    private void onAceptarButtonClick() {
        // Obtener el número de la casilla seleccionada (región en la tabla)
        int selectedRow = table.getSelectedRow(); // Fila seleccionada (0-indexed)
        int selectedColumn = table.getSelectedColumn(); // Columna seleccionada (0-indexed)

        // Convertir la posición de la tabla a un número de casilla (1-9)
        int numCasilla = selectedRow + (selectedColumn * 3) - 2;

        // Obtener el nombre del Pokémon seleccionado en el ComboBox
        String pokemonSeleccionado = (String) comboBox.getSelectedItem();

        //Estas seguro?

        // Llamar a la función comprobar con los valores obtenidos
        boolean resultado = controller.comprobar(juego, pokemonSeleccionado, numCasilla);

        // Mostrar el resultado en un mensaje (solo para propósitos de demostración)
        JOptionPane.showMessageDialog(this,
                "¿El Pokémon " + pokemonSeleccionado + " está en la casilla " + numCasilla + "? " +
                        (resultado ? "Sí" : "No"));

        if (resultado) {
            model.setValueAt(pokemonSeleccionado, selectedRow, selectedColumn);
            numAciertos++;
            int numTotal=anchoTabla*altoTabla;

            if (numAciertos >= (numTotal)) {
                JOptionPane.showMessageDialog(this,
                "Has llenado los " + numTotal + " huecos de la Tabla \n HAS COMPLETADO EL POKEDOKU");
            }

        // Actualizar la vista de la tabla
        table.repaint(); 
        }
    }

}

