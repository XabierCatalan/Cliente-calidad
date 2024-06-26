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

import com.Controller.SesionesController;
import com.GUI.*;

public class VentanaInicioSesion extends JFrame{

    SesionesController controller = new SesionesController();

    JLabel correo;
    JLabel contra;

    JTextField correoText;
    JTextField contraText;

    JButton aceptar;

    JPanel Grid;

    public VentanaInicioSesion() {

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());


        correo = new JLabel("Correo: ");
        contra = new JLabel("Contraseña: ");

        correoText = new JTextField();
        contraText = new JTextField();

        aceptar = new JButton("Aceptar");

        Grid = new JPanel();
        Grid.setLayout(new GridLayout(5,1));
        Grid.add(correo);
        Grid.add(correoText);
        Grid.add(contra);
        Grid.add(contraText);


        Grid.add(aceptar);

        cp.add(Grid, BorderLayout.CENTER);


        setTitle("Inicio de Sesion");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(250, 250);
        setLocationRelativeTo(null);
        setVisible(false);

        aceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String correo = correoText.getText();
                String contra = contraText.getText();
                String ini = controller.iniciarSesion(correo, contra);
                System.out.println("Respuesta:" + ini);

                if (ini == "NUll") {
                    JOptionPane.showMessageDialog(null, "El correo y la contraseña son incorrectos");
                    
                } else if(ini == "Jugador") {
                    VentanaInicial Vi = new VentanaInicial();
                    Vi.setVisible(true);
                    setVisible(false);
                    
                } else if(ini == "Admin") {
                    VentanaAdmin VA = new VentanaAdmin();
                    VA.setVisible(true);
                    setVisible(false);
                    
                }
                

               
            }
        });
    }

   
}
