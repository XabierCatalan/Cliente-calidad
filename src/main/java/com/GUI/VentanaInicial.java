package com.GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import com.Controller.VentanaInicialController;

public class VentanaInicial extends JFrame{
    static VentanaInicialController controller = new VentanaInicialController();

    //lista de nombres de pokemons
    HashMap<Integer , List<String>> juego = controller.crearJuego();
    ArrayList<String> listapokemons = (ArrayList<String>) controller.getlistapokemons();
    ArrayList<String> condicionesTipo = (ArrayList<String>) controller.getCondicionesTipo();
    ArrayList<String> condicionesRegion = (ArrayList<String>) controller.getCondicionesRegion();

    //Botones
    JButton ayuda = new JButton("Ayuda");
    JButton listap = new JButton("listaPokemons");
    JButton aceptar = new JButton("Aceptar");

    //desplegable con los pokemons
    JComboBox<String> comboBox;

    public VentanaInicial() {

        Container cp = this.getContentPane();
        cp.setLayout(new BorderLayout());


        //botones

        ayuda = new JButton("Ayuda");
        listap = new JButton("listaPokemons");
        aceptar = new JButton("Aceptar");

        comboBox = new JComboBox<>(listapokemons.toArray(new String[0]));

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        panel.add(ayuda);
        panel.add(listap);
        panel.add(aceptar);
        panel.add(comboBox);

        cp.add(panel, BorderLayout.SOUTH);

        // Crear la tabla
        createJTable();
        
        setTitle("Pokedoku");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    public void createJTable() {
        // Datos de ejemplo para la tabla

        String[][] data = new String[condicionesRegion.size()][condicionesTipo.size()+1];

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

        JTable table = new JTable(data, columnNames);


        // Agregar la tabla a un JScrollPane para que tenga barras de desplazamiento
        JScrollPane scrollPane = new JScrollPane(table);

        // Agregar el JScrollPane a la ventana
        add(scrollPane);




    }


    















  
   /*  public static void main(String[] args) {
        var ctx = new SpringApplicationBuilder(VentanaInicial.class)
                .headless(false).web(WebApplicationType.NONE).run(args);

        EventQueue.invokeLater(() -> {

            var ex = ctx.getBean(VentanaInicial.class);
            ex.setVisible(true);
        });
    } */

}

