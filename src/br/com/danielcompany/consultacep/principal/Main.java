package br.com.danielcompany.consultacep.principal;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) {

        String cepSolicitado = "06020194";

        String url = "https://viacep.com.br/ws/" + cepSolicitado + "/json/";

        try{
            //TODO extrair a chamada da api para uma outra classe
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url)).build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            System.out.println(json);

        } catch (Exception e) {
            //TODO alterar para exception(s) mais específica
            System.out.println(e.getMessage());
        }
    }
}