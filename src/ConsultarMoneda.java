import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SuppressWarnings("SpellCheckingInspection")
public class ConsultarMoneda {

    public Moneda buscarMoneda(String from, String to) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/5f81b1c61c47a764f7e175f4/pair/" + from + "/" + to);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            // Analizar el cuerpo de la respuesta para ver si hay un error de moneda no encontrada
            if (response.body().contains("error") && response.body().contains("invalid currency")) {
                throw new RuntimeException("Moneda no válida o no encontrada.");
            }

            return new Gson().fromJson(response.body(), Moneda.class);

        } catch (Exception e) {
            throw new RuntimeException("Error al obtener la tasa de cambio: El servicio retornó: " + e.getMessage());
        }
    }
}
