package br.ufscar.dc.dsw.domain;

import java.util.Set;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Hotel")
public class Hotel extends Usuario {

    @NotBlank(message = "{NotBlank.hotel.cnpj}")
    @Size(min = 0, max = 25, message = "{Size.hotel.cnpj}")
    @Column(nullable = false, unique = true, length = 25)
    private String CNPJ;

    @NotBlank(message = "{NotBlank.hotel.nome}")
    @Size(min = 0, max = 260)
    @Column(nullable = false, length = 260)
    private String nome;

    @NotBlank(message = "{NotBlank.hotel.cidade}")
    @Size(min = 0, max = 260)
    @Column(nullable = false, length = 260)
    private String cidade;

    @OneToMany(mappedBy = "hotel")
    private List<Promocao> promocoes;
    
    private String idString;
    private String loginString;

    public Hotel(){

    }

    public Hotel(String login, String senha, String CNPJ, String nome, String cidade){
        super(login, senha, "HOTEL");
        this.CNPJ = CNPJ;
        this.cidade = cidade;
        this.nome = nome;
        //this.idString = super.getId().toString();
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

    
    public List<Promocao> getPromocoes() {
        return promocoes;
    }

    public void setPromocoes(List<Promocao> promocoes) {
        this.promocoes = promocoes;
    }

    

    

    
    
    
    /**
     * @return the idString
     */
    public String getIdString() {
        return super.getId().toString();
    }

    

    /**
     * @param idString the idString to set
     */
    public void setIdString(String idString) {
        this.idString = idString;
    }

    
    
    
}