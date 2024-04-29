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
import com.GUI.*;

public class VentanaRegistro extends JFrame{

    //el id es autoincremental
    JLabel correo;
    JLabel contra;

    //ponemos que el nivel por defecto sea 1 y que otro admin te tenaga que cambiar el nivel
    int nivel = 0;

    JTextField correoText;
    JTextField contraText;

    JButton aceptar;

    JPanel Grid;



    public VentanaRegistro() {

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        correo = new JLabel("Correo: ");
        contra = new JLabel("Contraseña: ");

        correoText = new JTextField();
        contraText = new JTextField();

        aceptar = new JButton("Sign in");

        Grid = new JPanel();
        Grid.setLayout(new GridLayout(5,1));
        Grid.add(correo);
        Grid.add(correoText);
        Grid.add(contra);
        Grid.add(contraText);


        Grid.add(aceptar);

        cp.add(Grid, BorderLayout.CENTER);

        setTitle("Registro de Usuario");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(250, 250);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
}
