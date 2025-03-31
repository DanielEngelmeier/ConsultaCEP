package br.com.danielcompany.consultacep.principal;

import br.com.danielcompany.consultacep.api.ApiService;
import br.com.danielcompany.consultacep.file.FileWriter;
import br.com.danielcompany.consultacep.modelos.Endereco;
import br.com.danielcompany.consultacep.modelos.EnderecoViaCep;
import java.io.IOException;
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


        while(!cep.equalsIgnoreCase("sair")){

            System.out.println("Digite um CEP ou \"sair\" para finalizar: ");
            cep = leitura.nextLine();

            if(cep.equalsIgnoreCase("sair")){
                break;
            }

            try {
                EnderecoViaCep enderecoViaCep = apiService.buscarCep(cep);
                Endereco novoEndereco = new Endereco(enderecoViaCep);

                enderecos.add(novoEndereco);
            } catch (IOException | InterruptedException e) {
                System.out.println("Erro ao consultar o CEP: " + e.getMessage());
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }

        }
        fileWriter.escreverLog("enderecosAdicionados.json", enderecos);

    }
}