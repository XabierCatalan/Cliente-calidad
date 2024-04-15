package com.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class VentanaInicialController {
    private static final String BASE_URL = "http://localhost:8080";
    

    public List<String> getlistapokemons() {


        String apartado = BASE_URL + "/listap";

        List<String> listapokemons = new ArrayList<>();

        try {


            URL url = new URL(apartado);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();

            if(responseCode == HttpURLConnection.HTTP_OK) {
                // Success

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String response = bufferedReader.readLine();
                
               System.out.println(response);

               for (String string : response.split(",")) {
                   listapokemons.add(string);
               }

                

                bufferedReader.close();
                return listapokemons;
            } else {
                // Error
                System.err.println("error en solicitud de la lista de pokemons GET");
                return null;
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        for (String string : listapokemons) {
            System.out.println(string);
        }

        return listapokemons;
    }
}
