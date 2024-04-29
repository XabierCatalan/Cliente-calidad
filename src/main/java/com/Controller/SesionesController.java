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
                System.out.println(response);
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
}
