package br.com.danielcompany.consultacep.principal;

import br.com.danielcompany.consultacep.api.ApiService;
import br.com.danielcompany.consultacep.file.FileWriter;
import br.com.danielcompany.consultacep.modelos.Endereco;
//lib importada com o .jar conforme mostrado no curso deste desafio
import br.com.danielcompany.consultacep.modelos.EnderecoViaCep;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.swing.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);
        String cep = "";
        ApiService apiService = new ApiService();
        List<Endereco> enderecos = new ArrayList<>();
        FileWriter fileWriter = new FileWriter();
        //instanciando a formatação da saída
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        while(!cep.equalsIgnoreCase("sair")){

            System.out.println("Digite um CEP ou \"sair\" para finalizar: ");
            cep = leitura.nextLine();

            if(cep.equalsIgnoreCase("sair")){
                break;
            }

            try {
                String json = apiService.buscarCep(cep);

                EnderecoViaCep enderecoViaCep = gson.fromJson(json, EnderecoViaCep.class);

                Endereco novoEndereco = new Endereco(enderecoViaCep);

                enderecos.add(novoEndereco);
            } catch (IOException | InterruptedException e) {
                System.out.println("Erro ao consultar o CEP: " + e.getMessage());
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }

        }
        fileWriter.escreverLog("enderecosAdicionados.json", gson.toJson(enderecos));

    }
}