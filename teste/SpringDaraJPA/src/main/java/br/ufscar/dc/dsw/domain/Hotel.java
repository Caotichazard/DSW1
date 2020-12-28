package br.ufscar.dc.dsw.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Hotel")
public class Hotel extends Usuario {

    @Column(nullable = false, unique = true, length = 25)
    private String CNPJ;

    @Column(nullable = false, length = 260)
    private String nome;

    @Column(nullable = false, length = 260)
    private String cidade;

    public Hotel(){

    }

    public Hotel(String email, String senha, String CNPJ, String nome, String cidade){
        super(email, senha, "HOTEL");
        this.CNPJ = CNPJ;
        this.cidade = cidade;
        this.nome = nome;
    }

    
    public String getCNPJ() {
        return CNPJ;
    }
    
    public void setCNPJ(String cNPJ) {
        CNPJ = cNPJ;
    }

    
    public String getCidade() {
        return cidade;
    }
    
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    
    public String getNome() {
        return nome;
    }

    
    public void setNome(String nome) {
        this.nome = nome;
    }
}