package br.com.danielcompany.consultacep.file;

import br.com.danielcompany.consultacep.modelos.Endereco;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;

public class FileWriter {
    public void escreverLog(String nomeArquivo, List<Endereco> mensagem){
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        try {
            java.io.FileWriter log = new java.io.FileWriter(nomeArquivo);
            log.write(gson.toJson(mensagem));
            log.close();
        } catch (IOException e) {
            System.out.println("Erro ao criar o log: " + e.getMessage());
        }
    }
}
