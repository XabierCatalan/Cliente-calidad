package com.Controller;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

//Aqui iran todos los metodos de Inicio se Sesion / registrarse----

public class SesionesController {
    private static final String BASE_URL = "http://localhost:8080";

    public boolean register(String Correo, String Contra) {
        
        String register = BASE_URL + "/registrar?correo=" + Correo + "&contra=" + Contra;
        System.out.println("register: " + register);
        try {
            
            URL url = new URL(register);
            
            // Open a connection to the server
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            //connection.setRequestProperty("Content-Type", "application/json");
            //connection.setDoOutput(true);

            // Send the JSON data to the server
           // connection.getOutputStream().write(userJson.getBytes());

            // Get the response from the server
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Registration successful
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String response = bufferedReader.readLine();
                System.out.println("Respuesta del Server" + response);
                if (response.equals("Usuario registrado")) {
                    bufferedReader.close();

                    return true;
                } else {
                    bufferedReader.close();

                    return false;
                    
                }
            } else {
                // Registration failed
                System.out.println("Registration failed. Response code: " + responseCode);
                return false;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String iniciarSesion(String Correo, String Contra) {
        
        String ini = BASE_URL + "/iniciarSesion?correo=" + Correo + "&contra=" + Contra;
        System.out.println("Iniciando Sesion: " + ini);
        try {
            
            URL url = new URL(ini);
            
            // Open a connection to the server
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
           

            // Get the response from the server
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // inicio se sesion successful
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String response = bufferedReader.readLine();
                System.out.println(response);
                if (response.equals("Usuario no existe")) {

                    bufferedReader.close();
                    System.out.println("El correo y la contraseña son incorrectos");
                    String respuesta = "NUll";
                    return respuesta;
                } else if(response.equals("Jugador")) {
                    System.out.println("inicio de sesion de jugador");
                    String respuesta = "Jugador";
                    bufferedReader.close();
                    return respuesta;
                    
                } else if(response.equals("Admin")) {
                    System.out.println("inicio de sesion de Admin");
                    String respuesta = "Admin";
                    bufferedReader.close();
                    return respuesta;
                    
                }
            } else {
                // Registration failed
                System.out.println("Log in failed. Response code: " + responseCode);
                String respuesta = "Log in failed. Response code: " + responseCode;
                return respuesta;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        String respuesta = "NULL-2";
        return respuesta;
    }
}
