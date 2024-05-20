package com.GUI;

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



public class VentanaAyudaV2 extends JFrame{
    
    JLabel info;
    JLabel info1;
    JLabel info2;
    JLabel info3;
    JLabel info4;

    JLabel regla;
    JLabel regla1;
    JLabel regla2;
    JLabel regla3;
    JLabel regla4;
    

    JPanel panel;

    public VentanaAyudaV2() {

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        info = new JLabel("  DESCRICIÓN DEL JUEGO"); 
        info1 = new JLabel("   Este es un juego de lógica en el que tienes"); 
        info2 = new JLabel("   que adivinar los pokemons que se esconden"); 
        info3 = new JLabel("   en las casillas. Para ello, se te proporcionan"); 
        info4 = new JLabel("   una serie de condiciones que debes cumplir."); 

        regla = new JLabel("  REGLAS DEL JUEGO"); 
        regla1 = new JLabel("   1- Se te proporcionan una serie de condiciones"); 
        regla2 = new JLabel("   2- El pokemon que se esconde debe cumplir todas las condiciones  "); 
        regla3 = new JLabel("   3- Tienes un numero de intentos limitados"); 
        regla4 = new JLabel("   4- Si se te acaban los intentos PERDISTE!"); 


        

        panel = new JPanel();
        panel.setLayout(new GridLayout(10,1));
        panel.add(info);
        panel.add(info1);
        panel.add(info2);
        panel.add(info3);
        panel.add(info4);
        panel.add(regla);
        panel.add(regla1);
        panel.add(regla2);
        panel.add(regla3);
        panel.add(regla4);

        cp.add(panel, BorderLayout.CENTER);


        setTitle("Ayuda");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(false);
        //agregarBotonAyuda();

    }

    private void agregarBotonAyuda() {
        // Crear botón de ayuda
        JButton ayudaButton = new JButton("?");
        ayudaButton.setPreferredSize(new Dimension(20, 20));
        ayudaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Mensaje de ayuda aquí.");
            }
        });

        // Agregar el botón de ayuda a la esquina superior derecha
        JPanel panelSuperiorDerecho = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelSuperiorDerecho.add(ayudaButton);

        // Agregar el panel al contenedor principal
        panel.add(panelSuperiorDerecho, BorderLayout.NORTH);
    }
}
