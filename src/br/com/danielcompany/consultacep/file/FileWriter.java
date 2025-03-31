package br.com.danielcompany.consultacep.file;

import java.io.IOException;

public class FileWriter {
    public void escreverLog(String nomeArquivo, String mensagem){
        try {
            java.io.FileWriter log = new java.io.FileWriter(nomeArquivo);
            log.write(mensagem);
            log.close();
        } catch (IOException e) {
            System.out.println("Erro ao criar o log: " + e.getMessage());
        }
    }
}
