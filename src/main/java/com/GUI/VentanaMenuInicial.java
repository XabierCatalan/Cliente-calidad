package com.GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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
import javax.swing.JTextField;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import com.Controller.VentanaInicialController;
import com.GUI.VentanaAyuda;

public class VentanaMenuInicial extends JFrame{
    JLabel pokedoku;

    JButton Log_in;
    JButton Sign_in;


    JPanel panelGlobal;
    JPanel Botones;


    public VentanaMenuInicial() {

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        pokedoku = new JLabel("Pokedoku");

        Log_in = new JButton("Log in");
        Sign_in = new JButton("Sign in");

        Botones = new JPanel();
        Botones.setLayout(new GridLayout(1,2));
        Botones.add(Log_in);
        Botones.add(Sign_in);

        panelGlobal = new JPanel();
        panelGlobal.setLayout(new GridLayout(2,1));
        panelGlobal.add(pokedoku);
        panelGlobal.add(Botones);
        



        cp.add(panelGlobal, BorderLayout.CENTER);


        setTitle("Inicio de Sesion");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(250, 250);
        setLocationRelativeTo(null);
        setVisible(true);

        Log_in.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VentanaInicioSesion ventanaInicioSesion = new VentanaInicioSesion();
                ventanaInicioSesion.setVisible(true);
                setVisible(false);
            }
        });

        Sign_in.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VentanaRegistro ventanaRegistro = new VentanaRegistro();
                ventanaRegistro.setVisible(true);
                setVisible(false);
            }
        });
    
        
    }

    
}
