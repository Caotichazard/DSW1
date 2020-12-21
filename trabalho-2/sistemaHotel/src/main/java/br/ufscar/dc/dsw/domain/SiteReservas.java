package br.ufscar.dc.dsw.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "SiteReservas")
public class SiteReservas extends Usuario {
	
	@Column(nullable = false, unique=true,length = 18)
	private String url;
	
	
    
    @Column(nullable = false, length = 60)
    private String telefone;
    
    @OneToMany(mappedBy = "siteReservas")
	private List<Promocao> promocoes;
    

	public SiteReservas(){//obrigatório default contructor
    	
    }
	public SiteReservas(String email, String senha, String url, String nome, String telefone){
        super(nome,email,"SITE",senha); 
        this.url = url;
        this.telefone = telefone;
    }

	

	

   
    public void setUrl(String url){
        this.url = url;
    }

    public String getUrl(){
        return this.url;
    }


    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public String getTelefone(){
        return this.telefone;
    }


    public List<Promocao> getPromocoes(){
        return promocoes;
    }

    public void setPromocoes(List<Promocao> promocoes){
        this.promocoes = promocoes;
    }
    
/*
	@Override
	public String toString() {
		return "Site de Reservas [Nome=" + nome + " Telefone=" + telefone + " url=" + url + "]";
    }
    */
}