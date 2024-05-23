package com.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.springframework.data.geo.Point;

import javax.swing.JScrollPane;

import com.Controller.VentanaInicialController;
import com.GUI.VentanaAyudaV2;

public class VentanaInicial extends JFrame{
    static VentanaInicialController controller = new VentanaInicialController();

    int numAciertos = 0;
    int anchoTabla = 3;
    int altoTabla = 3;
    int numFallos = 0;

    boolean perder = true;

    //lista de nombres de pokemons
    HashMap<Integer , List<String>> juego = controller.crearJuego();
    ArrayList<String> listapokemons = (ArrayList<String>) controller.getlistapokemons();
    ArrayList<String> condicionesTipo = (ArrayList<String>) controller.getCondicionesTipo();
    ArrayList<String> condicionesRegion = (ArrayList<String>) controller.getCondicionesRegion();

    //Botones
    JButton ayuda = new JButton("Ayuda");
    JButton listap = new JButton("listaPokemons");
    JButton aceptar = new JButton("Aceptar");
    JButton modoNoche;
    JButton volverAJugar;

    JButton rendirse;
    JTable table;
    DefaultTableModel model;
    JScrollPane scrollPane;

    JPanel panel;
    JPanel parteAbajo;

    //desplegable con los pokemons
    JComboBox<String> comboBox;

    //ventanas
    VentanaAyudaV2 VentanaAyudaV2 = new VentanaAyudaV2();

    JLabel creditos;
    JLabel fallos;

    boolean isModoNoche = false; 

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
        aceptar = new JButton("Aceptar");
        modoNoche = new JButton("Modo Noche");
        rendirse = new JButton("Me rindo");
        volverAJugar = new JButton("Volver a jugar");
         // Crear la tabla
        createJTable();
        
         
        // Crear un ComboBox editable con autocompletado
        comboBox = new JComboBox<>(listapokemons.toArray(new String[0]));
        comboBox.setEditable(true);


        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        panel.add(ayuda);
        panel.add(aceptar);
        panel.add(rendirse);
        panel.add(modoNoche);
        panel.add(comboBox);
        panel.add(volverAJugar);

        parteAbajo = new JPanel();
        parteAbajo.setLayout(new GridLayout(2,1));
        fallos = new JLabel("Fallos: " + numFallos);
        parteAbajo.add(fallos);
    
        creditos = new JLabel("Grupo PSC-12: Oscar Perez, Xabier Catalan, Unai Basterretxea, Jon Ander Olivera");
        parteAbajo.add(creditos);

        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (perder) {
                    int response = JOptionPane.showConfirmDialog(null, "¿ESTAS SEGURO?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    boolean result = (response == JOptionPane.YES_OPTION);
    
                    if (result) {
                        onAceptarButtonClick();
                    }
                }
                
            }
        });

        rendirse.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                int response = JOptionPane.showConfirmDialog(null, "¿ESTAS SEGURO DE QUE QUIERES RENDIRTE?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                boolean result = (response == JOptionPane.YES_OPTION);

                if (result) {
                    JTable table = (JTable) scrollPane.getViewport().getView();
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
    
                    for (int row = 0; row < model.getRowCount(); row++) {
                        for (int col = 1; col < model.getColumnCount(); col++) {
                            int numCasilla = row + (col * 3) - 2;
                            model.setValueAt(juego.get(numCasilla).get(0), row, col);
                        }
                    }

                    JOptionPane.showMessageDialog(null, "Has perdido, el juego ha terminado");
                    perder = false;
                }
                
           }          
        });

        modoNoche.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActivarModoNoche();
            }
        });

        volverAJugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(null, "¿Quieres volver a jugar?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                boolean result = (response == JOptionPane.YES_OPTION);

                if (result) {
                    reiniciarJuego();
                } else {
                    dispose();
                }
            }
        });
        cp.add(panel, BorderLayout.NORTH);
        cp.add(scrollPane, BorderLayout.CENTER);

        cp.add(parteAbajo, BorderLayout.SOUTH);

        ayuda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                VentanaAyudaV2.setVisible(true);
            }
        });

    }

    private void ActivarModoNoche() {
        isModoNoche = !isModoNoche;

        Color backgroundColor = isModoNoche ? Color.DARK_GRAY : Color.WHITE;
        Color foregroundColor = isModoNoche ? Color.WHITE : Color.BLACK;

        if (isModoNoche) {
            modoNoche.setText("Modo Día");
        } else {
            modoNoche.setText("Modo Noche");
        }

        getContentPane().setBackground(backgroundColor);
        panel.setBackground(backgroundColor);
        parteAbajo.setBackground(backgroundColor);
        table.setBackground(backgroundColor);
        table.setForeground(foregroundColor);
        comboBox.setBackground(backgroundColor);
        comboBox.setForeground(foregroundColor);

        for (Component component : panel.getComponents()) {
            if (component instanceof JButton) {
                component.setBackground(backgroundColor);
                component.setForeground(foregroundColor);
            }
        }

        fallos.setForeground(foregroundColor);
        creditos.setForeground(foregroundColor);
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
            public Class<?> getColumnClass(int column) {
                if (column != 0) {
                    return ImagePanel.class;
                }
                return super.getColumnClass(column);
            }
        };

        // Crear la tabla con el modelo no editable
        table = new JTable(model);
        table.setRowHeight(100);

        TableColumn imageColumn1 = table.getColumnModel().getColumn(1);
        imageColumn1.setPreferredWidth(200);
        TableColumn imageColumn2 = table.getColumnModel().getColumn(2);
        imageColumn2.setPreferredWidth(200);
        TableColumn imageColumn3 = table.getColumnModel().getColumn(3);
        imageColumn3.setPreferredWidth(200);

        imageColumn1.setCellRenderer(new ImageRenderer());
        imageColumn2.setCellRenderer(new ImageRenderer());
        imageColumn3.setCellRenderer(new ImageRenderer());

        // Agregar la tabla a un JScrollPane para que tenga barras de desplazamiento
        scrollPane = new JScrollPane(table);
    }

    private static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = VentanaInicial.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("No se encontró el archivo de imagen: " + path);
            return null;
        }
    }

    static class ImagePanel extends JPanel {
        private JLabel nameLabel;
        private JLabel imageLabel;

        public ImagePanel(String name, ImageIcon icon) {
            setLayout(new BorderLayout());
            nameLabel = new JLabel(name, SwingConstants.CENTER);
            imageLabel = new JLabel(icon, SwingConstants.CENTER);
            add(imageLabel, BorderLayout.CENTER);
            add(nameLabel, BorderLayout.SOUTH);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 150); // Tamaño mínimo para el ImagePanel
        }
    }

    // Renderizador de celdas personalizado para mostrar imágenes y nombres
    static class ImageRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (value instanceof ImagePanel) {
                return (ImagePanel) value; // Devolver directamente el ImagePanel
            } else {
                // Devolver un componente vacío si el valor no es un ImagePanel
                return new JLabel(); // Devolver un JLabel vacío
            }
        }
    }

    private void derrotaPorFallos() {
        if (numFallos >= 3) {
            reiniciarTablero();
            JOptionPane.showMessageDialog(null, "Has perdido por exceder el límite de fallos (3). Se reinició el tablero.");
        }
    }

    private void reiniciarTablero() {
        juego = controller.crearJuego();

        // Actualizar las combinaciones en la tabla
        int rowCount = model.getRowCount();
        int columnCount = model.getColumnCount();
        for (int i = 0; i < rowCount; i++) {
            for (int j = 1; j < columnCount; j++) {
                int numCasilla = i + (j * 3) - 2;
                model.setValueAt(juego.get(numCasilla).get(0), i, j);
            }
        }
    }

    private void onAceptarButtonClick() {
        // Obtener el número de la casilla seleccionada (región en la tabla)

        if (perder) {
            
        

            int selectedRow = table.getSelectedRow(); // Fila seleccionada (0-indexed)
            int selectedColumn = table.getSelectedColumn(); // Columna seleccionada (0-indexed)

            // Convertir la posición de la tabla a un número de casilla (1-9)
            int numCasilla = selectedRow + (selectedColumn * 3) - 2;

            // Obtener el nombre del Pokémon seleccionado en el ComboBox
            String pokemonSeleccionado = (String) comboBox.getSelectedItem();
            int idSeleccionado = 1;
            //Estas seguro?

            // Llamar a la función comprobar con los valores obtenidos
            boolean resultado = controller.comprobar(juego, pokemonSeleccionado, numCasilla);

            // Mostrar el resultado en un mensaje (solo para propósitos de demostración)
            JOptionPane.showMessageDialog(this,
                    "El Pokémon " + pokemonSeleccionado + (resultado ? " Sí" : " No") + " está en la casilla " + numCasilla);

        
                if (resultado) {
                    model.setValueAt(pokemonSeleccionado, selectedRow, selectedColumn);
                    numAciertos++;
                    int numTotal=anchoTabla*altoTabla;

                    if (selectedRow != -1) {
                        // Lógica para obtener la ruta de la imagen y el nombre
                        for (int i = 0; i < listapokemons.size(); i++) {
                        
                            if (pokemonSeleccionado.equals(listapokemons.get(i))) {
                                idSeleccionado=i+1;
                            }
                        }
                        String imagePath = "../sprites/icons/" + (idSeleccionado) + ".png"; // Ruta de la imagen
                        String imageName = pokemonSeleccionado; // Nombre de la imagen
            
                        // Crear ImageIcon y ImagePanel
                        ImageIcon icon = createImageIcon(imagePath);
                        ImagePanel panel = new ImagePanel(imageName, icon);
            
                        // Actualizar el valor en la tercera columna de la fila seleccionada
                        table.getModel().setValueAt(panel, selectedRow, 2);
                    }

                    if (numAciertos >= (numTotal)) {
                        JOptionPane.showMessageDialog(this,
                        "Has llenado los " + numTotal + " huecos de la Tabla \n HAS COMPLETADO EL POKEDOKU");
                    }

                // Actualizar la vista de la tabla
                table.repaint(); 
                } else {
                    numFallos++;
                    fallos.setText("Fallos: " + numFallos);
                    derrotaPorFallos();
                }
        }

    }

    private void reiniciarJuego() {
        numAciertos = 0;
        numFallos = 0;
        perder = true;
        juego = controller.crearJuego();
        condicionesTipo = (ArrayList<String>) controller.getCondicionesTipo();
        condicionesRegion = (ArrayList<String>) controller.getCondicionesRegion();
        fallos.setText("Fallos: " + numFallos);
        
        // Actualizar las columnas de la tabla
        anchoTabla = condicionesTipo.size();
        altoTabla = condicionesRegion.size();

        String[][] data = new String[altoTabla][anchoTabla+1];
        for (int i = 0; i < condicionesRegion.size(); i++) {
            data[i][0] = condicionesRegion.get(i); 
        }

        String[] columnNames = new String[condicionesTipo.size()+1];
        Arrays.fill(columnNames, "");
        int cont = 1;
        for (String t : condicionesTipo) {
            columnNames[cont]=t;
            cont++;
        }
        
        model.setDataVector(data, columnNames);
        
        // Actualizar la vista de la tabla
        table.repaint(); 
    }


}