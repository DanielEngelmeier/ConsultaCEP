package br.com.danielcompany.consultacep.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiService {
    private static final String BASE_URL = "https://viacep.com.br/ws/";

    public String buscarCep(String cep) throws IOException, InterruptedException{
        String url = BASE_URL + cep + "/json/";
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url)).build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        if(response.statusCode() == 200){
            return response.body();
        } else {
            //caso de insucesso na requisição
            throw new RuntimeException("Erro ao consulta o CEP: " + response.statusCode());
        }
    }


}
