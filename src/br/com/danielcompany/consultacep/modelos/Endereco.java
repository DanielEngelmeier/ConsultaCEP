package br.com.danielcompany.consultacep.modelos;

public class Endereco {
    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String uf;

    public Endereco(String cep, String logradouro, String bairro, String cidade, String uf) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
    }

    public Endereco(EnderecoViaCep enderecoViaCep) {
        this.cep = enderecoViaCep.cep();
        this.logradouro = enderecoViaCep.logradouro();
        this.bairro = enderecoViaCep.bairro();
        this.cidade = enderecoViaCep.localidade();
        this.uf = enderecoViaCep.uf();
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

}
