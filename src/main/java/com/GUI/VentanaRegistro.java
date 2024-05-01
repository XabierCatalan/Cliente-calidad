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

public class VentanaRegistro extends JFrame{

    SesionesController controller = new SesionesController();

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
        setVisible(false);

        aceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String Correo = correoText.getText();
                String Contra = contraText.getText();
                if (validarDatos(Correo, Contra)) {

                boolean registrado = controller.register(Correo, Contra);

                System.out.println("Respuesta del metodo registrado del register controller " + registrado);

                if (registrado) {
                    JOptionPane.showMessageDialog(null, "Usuario registrado");
                    VentanaInicioSesion Mi = new VentanaInicioSesion();
                    Mi.setVisible(true);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario ya existente");
                }

            }
            }
        });
    }


    public boolean validarDatos(String correo, String contrasena) {
        // Verificar que el correo y la contraseña no estén vacíos
        if (correo.isEmpty() || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, ingresa correo y contraseña.");
            return false;
        }
        
        // Validar el formato del correo electrónico
        if (!correo.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            JOptionPane.showMessageDialog(null, "Formato de correo electrónico inválido.");
            return false;
        }
    
        // Verificar que la contraseña tenga al menos 6 caracteres
        if (contrasena.length() < 6) {
            JOptionPane.showMessageDialog(null, "La contraseña debe tener al menos 6 caracteres.");
            return false;
        }
        
        // Si pasa todas las validaciones, retorna true
        return true;
    }
    
}
