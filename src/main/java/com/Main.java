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
        if(args.length!=1){
            System.out.println("Invalid input arguments: github-activity <username>");
            return;
        }
        String usarname = args[0];
        // 3.1 Inicializar el Cliente
        HttpClient client = HttpClient.newHttpClient();

        // 3.2 Construir la Request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.github.com/users/" + usarname + "/events"))
                .header("Accept", "application/json")
                .GET()
                .build();

        // 3.3 Realizar la petición dentro del bloque try
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Respuesta del servidor: " + response.statusCode());
            if(response.statusCode() == 404){
                return;
            }
            // System.out.println(response.body());

            //Vamos a leer con Jackson la respuesta de la API
            ObjectMapper mapper = new ObjectMapper();
            // Convertimos el body (String) en una lista de nuestros POJOs
            //readValue(content, ValueType)
            List<GitHubEvent> eventos = mapper.readValue(response.body(),new TypeReference<List<GitHubEvent>>(){});

            procesarEventos(eventos);

        } catch (IOException | InterruptedException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            
        }
    }

    private static void procesarEventos(List<GitHubEvent> eventos) {
        if (eventos.isEmpty()) return;

        String currentRepoName = eventos.get(0).getRepo().getName();
        String currentEventType = eventos.get(0).getType();
        int eventcounter = 0;

        for (GitHubEvent e : eventos) {
            if (e.getType().equals(currentEventType) && e.getRepo().getName().equals(currentRepoName)) {
                eventcounter++;
            } else {
                // Llamada al método auxiliar
                printSummary(currentEventType, currentRepoName, eventcounter);

                eventcounter = 1;
                currentRepoName = e.getRepo().getName();
                currentEventType = e.getType();
            }
        }
        // Llamada final para el último grupo
        printSummary(currentEventType, currentRepoName, eventcounter);
    }
    // Auxiliar method to print the info
    private static void printSummary(String type, String repoName, int count) {
        switch (type) {
            case "PushEvent":
                System.out.println("- Pushed " + count + " commits to " + repoName);
                break;
            case "DeleteEvent":
                System.out.println("- Deleted " + count + " resources on " + repoName);
                break;
            case "CreateEvent":
                System.out.println("- Created " + count + " resources on " + repoName);
                break;
            default:
                System.out.println("- " + count + " " + type + " on " + repoName);
                break;
        }
    }

}

