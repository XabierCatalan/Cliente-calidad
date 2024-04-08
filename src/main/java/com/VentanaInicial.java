package com;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import java.awt.EventQueue;

import javax.swing.JFrame;

public class VentanaInicial extends JFrame{
  
    public static void main(String[] args) {
        var ctx = new SpringApplicationBuilder(VentanaInicial.class)
                .headless(false).web(WebApplicationType.NONE).run(args);

        EventQueue.invokeLater(() -> {

            var ex = ctx.getBean(VentanaInicial.class);
            ex.setVisible(true);
        });
    }

}

