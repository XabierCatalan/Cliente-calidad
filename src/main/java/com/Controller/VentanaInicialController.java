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
                
               //System.out.println(response);

               listapokemons = convertJsonToArrayList(response);

                

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

        return listapokemons;
    }

    public static ArrayList<String> convertJsonToArrayList(String jsonString) throws IOException {
        // Crear un ObjectMapper de Jackson
        ObjectMapper mapper = new ObjectMapper();

        // Usar ObjectMapper para convertir la cadena JSON en un ArrayList<String>
        ArrayList<String> arrayList = mapper.readValue(jsonString, new TypeReference<ArrayList<String>>() {});

        return arrayList;
    }
    
    public static HashMap<Integer, List<String>> convertJsonToMap(String jsonString) throws IOException {
        // Crear un ObjectMapper de Jackson
        ObjectMapper mapper = new ObjectMapper();

        // Usar ObjectMapper para convertir la cadena JSON en un HashMap
        HashMap<Integer, List<String>> map = mapper.readValue(jsonString, new TypeReference<HashMap<Integer, List<String>>>() {});

        return map;
    }

    public HashMap<Integer , List<String>> crearJuego() {


        String apartado = BASE_URL + "/crearJuego";

        HashMap<Integer , List<String>> juego = new HashMap();

        try {


            URL url = new URL(apartado);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();

            if(responseCode == HttpURLConnection.HTTP_OK) {
                // Success

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String response = bufferedReader.readLine();
                
               //System.out.println(response);

               juego = convertJsonToMap(response);


                bufferedReader.close();
                return juego;
            } else {
                // Error
                System.err.println("error en solicitud de la lista de pokemons GET");
                return null;
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return juego;
    }


    public List<String> getCondicionesTipo(){
        String apartado = BASE_URL + "/condicionTipo";

        List<String> condicionesTipo = new ArrayList<>();

        try {


            URL url = new URL(apartado);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();

            if(responseCode == HttpURLConnection.HTTP_OK) {
                // Success

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String response = bufferedReader.readLine();
                
               //System.out.println(response);

               condicionesTipo = convertJsonToArrayList(response);
                
               System.out.println(condicionesTipo);

                bufferedReader.close();
                return condicionesTipo;
            } else {
                // Error
                System.err.println("error en solicitud de la lista de pokemons GET");
                return null;
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return condicionesTipo;
    }

    public List<String> getCondicionesRegion(){
        String apartado = BASE_URL + "/condicionRegion";

        List<String> condicionesRegion = new ArrayList<>();

        try {


            URL url = new URL(apartado);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();

            if(responseCode == HttpURLConnection.HTTP_OK) {
                // Success

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String response = bufferedReader.readLine();
                
               //System.out.println(response);

               condicionesRegion = convertJsonToArrayList(response);

                System.out.println(condicionesRegion);

                bufferedReader.close();
                return condicionesRegion;
            } else {
                // Error
                System.err.println("error en solicitud de la lista de pokemons GET");
                return null;
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return condicionesRegion;
    }

    
}
