
package com.GUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.Controller.VentanaInicialController;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class VentanaAdmin extends JFrame{
    
    static VentanaInicialController controller = new VentanaInicialController();
    ArrayList<String> listaTipos = (ArrayList<String>) controller.getlistaTipos();
    ArrayList<String> listaRegiones = (ArrayList<String>) controller.getlistaRegiones();
    ArrayList<String> listaUsuarios = (ArrayList<String>) controller.getUsuarios();



    //Region
    JPanel panelRegion;
    JLabel Region;
    JLabel Region1;
    JButton addRegionButton;
    JTextField RegionText;

    //Tipo Pokemon
    JPanel panelTipoPokemon;
    JLabel TipoPokemon;
    JLabel TipoPokemon_1;
    JButton addTipoPokemonButton;
    JTextField TipoPokemonText;

    //Pokemon
    JPanel panelPokemon;
    JLabel Pokemon;
    JLabel Pokemon1;
    JLabel Pokemon_Tipo1;
    JLabel Pokemon1_Tipo2;
    JLabel Pokemon1_Region;
    JButton addPokemonButton;
    JTextField PokemonText;
    JComboBox<String> TipoPokemon1;
    JComboBox<String> TipoPokemon2;
    JComboBox<String> TipoRegion;

    //Usuario
    JPanel panelUsuario;
    JLabel Usuario;
    JLabel Usuario_Correo;
    JLabel Usuario_Contraseña;
    JLabel Usuario_Nivel;
    JButton addUsuarioButton;
    JTextField correo;
    JTextField contraseña;
    JTextField nivel;

    //panel visualizar usuarios
    JPanel panelVisualizarUsuarios;
    JList<String> JlistaUsuarios;
    DefaultListModel<String> listModel;


    //Ventana
    JPanel panelVentana;




    public VentanaAdmin() {
        

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        // Region
        panelRegion = new JPanel();
        panelRegion.setLayout(new GridLayout(4, 1));
        Region = new JLabel("Apartado de Region");
        Region1 = new JLabel("Nombre de la Region");
        addRegionButton = new JButton("Add Region");
        RegionText = new JTextField();
        panelRegion.add(Region);
        panelRegion.add(Region1);
        panelRegion.add(RegionText);
        panelRegion.add(addRegionButton);

        // Tipo Pokemon
        panelTipoPokemon = new JPanel();
        panelTipoPokemon.setLayout(new GridLayout(4, 1));
        TipoPokemon = new JLabel("Apartado de Tipos");
        TipoPokemon_1 = new JLabel("Nombre del Tipo");
        addTipoPokemonButton = new JButton("Add Tipo Pokemon");
        TipoPokemonText = new JTextField();
        panelTipoPokemon.add(TipoPokemon);
        panelTipoPokemon.add(TipoPokemon_1);
        panelTipoPokemon.add(TipoPokemonText);
        panelTipoPokemon.add(addTipoPokemonButton);

        // Pokemon
        panelPokemon = new JPanel();
        panelPokemon.setLayout(new GridLayout(10, 1));
        Pokemon = new JLabel("Apartado de pokemons");
        Pokemon1 = new JLabel("Nombre del Pokemon");
        Pokemon_Tipo1 = new JLabel("Tipo 1");
        Pokemon1_Tipo2 = new JLabel("Tipo 2");
        Pokemon1_Region = new JLabel("Region");
        PokemonText = new JTextField();
        addPokemonButton = new JButton("Add Pokemon");
        TipoPokemon1 = new JComboBox<>(listaTipos.toArray(new String[0]));
        TipoPokemon1.setEditable(false);

        TipoPokemon2 = new JComboBox<>(listaTipos.toArray(new String[0]));
        TipoPokemon2.setEditable(false);

        TipoRegion = new JComboBox<>(listaRegiones.toArray(new String[0]));
        TipoRegion.setEditable(false);

        panelPokemon.add(Pokemon);
        panelPokemon.add(Pokemon1);
        panelPokemon.add(PokemonText);
        panelPokemon.add(Pokemon_Tipo1);
        panelPokemon.add(TipoPokemon1);
        panelPokemon.add(Pokemon1_Tipo2);
        panelPokemon.add(TipoPokemon2);
        panelPokemon.add(Pokemon1_Region);
        panelPokemon.add(TipoRegion);
        panelPokemon.add(addPokemonButton);

        // Usuario
        panelUsuario = new JPanel();
        panelUsuario.setLayout(new GridLayout(8, 1));
        Usuario = new JLabel("Apartado de Usuarios");
        Usuario_Correo = new JLabel("Correo");
        Usuario_Contraseña = new JLabel("Contraseña");
        Usuario_Nivel = new JLabel("Nivel");
        addUsuarioButton = new JButton("Add Usuario");
        correo = new JTextField();
        contraseña = new JTextField();
        nivel = new JTextField();
        panelUsuario.add(Usuario);
        panelUsuario.add(Usuario_Correo);
        panelUsuario.add(correo);
        panelUsuario.add(Usuario_Contraseña);
        panelUsuario.add(contraseña);
        panelUsuario.add(Usuario_Nivel);
        panelUsuario.add(nivel);
        panelUsuario.add(addUsuarioButton);

        //panel visualizar usuarios
        panelVisualizarUsuarios = new JPanel();
        panelVisualizarUsuarios.setLayout(new GridLayout(1, 1));
        listModel = new DefaultListModel<>();

        for (String usuario : listaUsuarios) {
            listModel.addElement(usuario);
        }


        JlistaUsuarios = new JList<>();
        JlistaUsuarios.setModel(listModel);
        panelVisualizarUsuarios.add(JlistaUsuarios);

        // Ventana
        panelVentana = new JPanel();
        panelVentana.setLayout(new GridLayout(3, 2));
        panelVentana.add(panelRegion);
        panelVentana.add(panelTipoPokemon);
        panelVentana.add(panelPokemon);
        panelVentana.add(panelUsuario);
        panelVentana.add(panelVisualizarUsuarios);
        





        cp.add(panelVentana, BorderLayout.CENTER);

        setTitle("Panel de Administrador");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(500, 800);
        setLocationRelativeTo(null);
        setVisible(false);

        addRegionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open a dialog to input region details
                String region = RegionText.getText();
                if (region != null && !region.isEmpty()) {
                    controller.postRegion(region);
                    listaRegiones.clear();
                    listaRegiones = (ArrayList<String>) controller.getlistaRegiones();
                    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(listaRegiones.toArray(new String[0]));
                    TipoRegion.setModel(model);
                   //que se actualice el Jcombobox
                }

                RegionText.setText("");
        
        }});

        addTipoPokemonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open a dialog to input region details
                String tipo = TipoPokemonText.getText();
                if (tipo != null && !tipo.isEmpty()) {
                    controller.postTipo(tipo);
                    listaTipos.clear();
                    listaTipos = (ArrayList<String>) controller.getlistaTipos();
                    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(listaTipos.toArray(new String[0]));
                    TipoPokemon1.setModel(model);
                    TipoPokemon2.setModel(model);

                   //que se actualice el Jcombobox
                }

                TipoPokemonText.setText("");
                
        
        }});

        addPokemonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open a dialog to input region details
                String nombre = PokemonText.getText();
                String tipo1 = (String) TipoPokemon1.getSelectedItem();
                String tipo2 = (String) TipoPokemon2.getSelectedItem();
                String region = (String) TipoRegion.getSelectedItem();
               
                if (nombre != null && !nombre.isEmpty() && tipo1 != null && !tipo1.isEmpty() &&
                        tipo2 != null && !tipo2.isEmpty() && region != null && !region.isEmpty()) {
                    controller.postPokemon(nombre, tipo1, tipo2, region);
                }

                PokemonText.setText("");
                
                
    
        }});

        addUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open a dialog to input region details
                String cor = correo.getText();
                String contra = contraseña.getText();
                String niv = nivel.getText();
                if (cor != null && !cor.isEmpty() && contra != null && !contra.isEmpty() && niv != null && !niv.isEmpty()) {
                    controller.postUsuario(cor, contra, niv);
                }

                correo.setText("");
                contraseña.setText("");
                

        }});
}

}




