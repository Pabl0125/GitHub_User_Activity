import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;

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
            System.out.println(response.body());
        } catch (IOException | InterruptedException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            
        }
        
    }
}