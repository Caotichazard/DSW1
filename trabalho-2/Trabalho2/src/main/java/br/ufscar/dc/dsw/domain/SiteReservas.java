package br.ufscar.dc.dsw.domain;

import java.util.Set;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "SiteReservas")
public class SiteReservas extends Usuario {

    @Column(nullable = false, unique = true, length = 25)
    private String Url;

    @Column(nullable = false, length = 260)
    private String nome;

    @Column(nullable = false, length = 260)
    private String telefone;

    @OneToMany(mappedBy = "site")
    private List<Promocao> promocoes;


    public SiteReservas(){

    }

    public SiteReservas(String email, String senha, String Url, String nome, String telefone){
        super(email, senha, "SITE");
        this.Url = Url;
        this.telefone = telefone;
        this.nome = nome;
    }

    
    
    public String getUrl() {
        return Url;
    }

   
    public void setUrl(String url) {
        Url = url;
    }

    
    
    public String getTelefone() {
        return telefone;
    }

    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    
    public String getNome() {
        return nome;
    }

    
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public List<Promocao> getPromocoes() {
        return promocoes;
    }

    
    public void setPromocoes(List<Promocao> promocoes) {
        this.promocoes = promocoes;
    }
}