import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.InputMismatchException;

@SuppressWarnings("SpellCheckingInspection")
public class ConsultarMoneda {

   /* public Moneda buscarMoneda(String from, String to) {
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
    }*/

    public Moneda buscarMoneda(String from, String to) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/5f81b1c61c47a764f7e175f4/pair/" + from + "/" + to);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String responseBody = response.body();
            Gson gson = new Gson();
            JsonObject jsonResponse = gson.fromJson(responseBody, JsonObject.class);

            if (jsonResponse.has("result") && jsonResponse.get("result").getAsString().equals("error")) {
                if (jsonResponse.has("error-type")) {
                    String errorType = jsonResponse.get("error-type").getAsString();
                    switch (errorType) {
                        case "unsupported-code" ->
                                throw new RuntimeException("Error -> Uno o ambos códigos de moneda no son soportados❌");
                        case "invalid-key" ->
                                throw new RuntimeException("Error -> La clave de API proporcionada no es válida❌");
                        case "malformed-request" ->
                                throw new RuntimeException("Error -> La solicitud a la API está malformada❌");
                        case "InputMismatchException" ->
                                throw new RuntimeException("---Error: La cantidad ingresada no es un número válido---❌");
                        default ->
                                throw new RuntimeException("Error al obtener la tasa de cambio: Servicio reportó un error: " + errorType + "❌");
                    }
                } else {
                    throw new RuntimeException("Error desconocido al obtener la tasa de cambio desde el servicio❌");
                }
            }

            return gson.fromJson(responseBody, Moneda.class);

        } catch (Exception e) {
            throw new RuntimeException("Error al obtener la tasa de cambio -> Clave de Moneda no encontrada en base de datos o Malformada❌");
        }
    }
}
