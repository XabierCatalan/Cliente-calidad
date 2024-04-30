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
    
//GET LISTA POKEMONS NOMBRES
    public List<String> getlistapokemons() {


        String apartado = BASE_URL + "/listap";

        List<String> listapokemons = new ArrayList<>();

        try {


            URL url = new URL(apartado);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();
            System.out.println("response code: " + responseCode);

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

//GET LISTA TIPOS NOMBRES
    public List<String> getlistaTipos() {


        String apartado = BASE_URL + "/listatiposNombres";

        List<String> listaTipos = new ArrayList<>();

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

               listaTipos = convertJsonToArrayList(response);

                

                bufferedReader.close();
                return listaTipos;
            } else {
                // Error
                System.err.println("error en solicitud de la listatiposNombres GET");
                return null;
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return listaTipos;
    }

//GET LISTA REGIONES NOMBRES
    public List<String> getlistaRegiones() {


        String apartado = BASE_URL + "/listaregionNombres";

        List<String> listaRegiones = new ArrayList<>();

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

               listaRegiones = convertJsonToArrayList(response);

                

                bufferedReader.close();
                return listaRegiones;
            } else {
                // Error
                System.err.println("error en solicitud de la listaregionNombres GET");
                return null;
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return listaRegiones;
    }

//POST REGION
    public boolean postRegion(String region) {
        String apartado = BASE_URL + "/InsertRegion?region=" + region;

        try {

            URL url = new URL(apartado);

            // Abrir una conexión al servidor
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Obtener la respuesta del servidor
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Registro exitoso
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String response = bufferedReader.readLine();
                System.out.println("Respuesta del Server" + response);
                if (response.equals("Region registrada")) {
                    bufferedReader.close();

                    return true;
                } else {
                    bufferedReader.close();

                    return false;
                    
                }
            } else {
                // Registro fallido
                System.out.println("Registro fallido. Código de respuesta: " + responseCode);
                return false;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

//POST TIPO
public boolean postTipo(String tipo) {
    String apartado = BASE_URL + "/InsertTipo?tipo=" + tipo;

    try {

        URL url = new URL(apartado);

        // Abrir una conexión al servidor
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Obtener la respuesta del servidor
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            // Registro exitoso
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String response = bufferedReader.readLine();
            System.out.println("Respuesta del Server" + response);
            if (response.equals("Region registrada")) {
                bufferedReader.close();

                return true;
            } else {
                bufferedReader.close();

                return false;
                
            }
        } else {
            // Registro fallido
            System.out.println("Registro fallido. Código de respuesta: " + responseCode);
            return false;
        }

    } catch (IOException e) {
        e.printStackTrace();
    }
    return false;
}

//POST TIPO
public boolean postPokemon(String tipo) {
    String apartado = BASE_URL + "/InsertTipo?tipo=" + tipo;

    try {

        URL url = new URL(apartado);

        // Abrir una conexión al servidor
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Obtener la respuesta del servidor
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            // Registro exitoso
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String response = bufferedReader.readLine();
            System.out.println("Respuesta del Server" + response);
            if (response.equals("Region registrada")) {
                bufferedReader.close();

                return true;
            } else {
                bufferedReader.close();

                return false;
                
            }
        } else {
            // Registro fallido
            System.out.println("Registro fallido. Código de respuesta: " + responseCode);
            return false;
        }

    } catch (IOException e) {
        e.printStackTrace();
    }
    return false;
}

//POST TIPO
public boolean postUsuario(String Correo, String Contra, String nivel) {
    String apartado = BASE_URL + "/InsertUsuario?Correo=" + Correo + "&Contra=" + Contra + "&nivel=" + nivel;

    try {

        URL url = new URL(apartado);

        // Abrir una conexión al servidor
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Obtener la respuesta del servidor
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            // Registro exitoso
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String response = bufferedReader.readLine();
            System.out.println("Respuesta del Server" + response);
            if (response.equals("Usuario Insertado")) {
                bufferedReader.close();

                return true;
            } else {
                bufferedReader.close();

                return false;
                
            }
        } else {
            // Registro fallido
            System.out.println("Registro fallido. Código de respuesta: " + responseCode);
            return false;
        }

    } catch (IOException e) {
        e.printStackTrace();
    }
    return false;
}

//CONVERTIR JSON A ARRAYLIST
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


//CREAR JUEGO
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

               System.out.println(juego);

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


//GET CONDICIONES TIPO
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


//GET CONDICIONES REGION
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

    

//COMPROBAR POKEMON
    public boolean comprobar(HashMap<Integer , List<String>> juego, String pokemon, int num){
        for (String poke : juego.get(num)) {
            if (poke.equals(pokemon)) {
                return true;
            }
        }
        return false;
    }
}
