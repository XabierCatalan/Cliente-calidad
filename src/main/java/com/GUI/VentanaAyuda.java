package com.GUI;

import java.awt.BorderLayout;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import java.awt.*;



public class VentanaAyuda extends JFrame{
    
    JLabel info;
    JPanel panel;

    public VentanaAyuda() {

        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());

        info = new JLabel("Este es un juego de lógica en el que tienes que adivinar los pokemons que se esconde en las casillas. Para ello, se te proporcionan una serie de pistas que te ayudarán a descubrirlo. ¡Buena suerte!");
        
        info.setHorizontalAlignment(JLabel.CENTER);
        info.setVerticalAlignment(JLabel.CENTER);
        info.setPreferredSize(new Dimension(300, 300));

        

        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(info, BorderLayout.CENTER);

        cp.add(panel);


        setTitle("Ayuda");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(false);
    }
}
