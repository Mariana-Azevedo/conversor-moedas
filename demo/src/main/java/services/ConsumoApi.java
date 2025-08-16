package services;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.DadosMoedas;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {
    public DadosMoedas ConsumoMoedaApi(String moeda) {

        var endereco = "https://v6.exchangerate-api.com/v6/59fbe3a07c3fd6310dfcd4b3/latest/" + moeda.replace(" ", "+");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();


        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // transforma JSON -> DTO
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(response.body(), DadosMoedas.class);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Erro ao consumir API", e);
        }

    }
}
