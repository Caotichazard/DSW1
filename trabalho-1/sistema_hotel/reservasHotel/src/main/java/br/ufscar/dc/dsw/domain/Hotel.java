package br.ufscar.dc.dsw.domain;



public class Hotel{
    private String email;
    private String senha;
    private String CNPJ;
    private String nome;
    private String cidade;

    public Hotel(String email, String senha, String CNPJ, String nome, String cidade){
        this.email = email;
        this.senha = senha;
        this.CNPJ = CNPJ;
        this.nome = nome;
        this.cidade = cidade;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public String getSenha(){
        return this.senha;
    }

    public void setCNPJ(String CNPJ){
        this.CNPJ = CNPJ;
    }

    public String getCNPJ(){
        return this.CNPJ;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setCidade(String cidade){
        this.cidade = cidade;
    }

    public String getCidade(){
        return this.cidade;
    }
}