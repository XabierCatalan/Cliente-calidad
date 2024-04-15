package com.GUI;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;

import jakarta.annotation.PostConstruct;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.List;
import java.util.ArrayList;

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
    ArrayList<String> listapokemons = (ArrayList<String>) controller.getlistapokemons();

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
        String[][] data = {
            {"ALOLA","", "", ""},
            {"KANTO","", "", ""},
            {"TESELIA","", "", ""},
            {"SINNOH","", "", ""}
        };

        // Nombres de las columnas
        String[] columnNames = {"", "FUEGO", "PLANTA", "AGUA"};

        // Crear la tabla con los datos y nombres de columnas
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

