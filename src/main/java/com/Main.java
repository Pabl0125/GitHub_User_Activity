package com;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

public class Main {
    public static void main(String[] args) {

        // 3.1 Inicializar el Cliente
        HttpClient client = HttpClient.newHttpClient();

        // 3.2 Construir la Request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.github.com/users/Pabl0125/events"))
                .header("Accept", "application/json")
                .GET()
                .build();

        // 3.3 Realizar la petición dentro del bloque try
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Respuesta del servidor: " + response.statusCode());
            // System.out.println(response.body());

            //Vamos a leer con Jackson la respuesta de la API
            ObjectMapper mapper = new ObjectMapper();
            // Convertimos el body (String) en una lista de nuestros POJOs
            //readValue(content, ValueType)
            List<GitHubEvent> eventos = mapper.readValue(response.body(),new TypeReference<List<GitHubEvent>>(){});
            //Recorremos las lista con un bucle for each
            eventos.forEach(e -> {
                System.out.println("Evento: " + e.getType() + " en el repo: " + e.getRepo().getName() + " id: " + e.getId());
            });

        } catch (IOException | InterruptedException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            
        }
        
        
    }
}