package br.ufscar.dc.dsw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "Hotel")
public class Hotel extends Usuario {
	
	@Column(nullable = false, unique=true,length = 18)
	private String cnpj;
	

    
    @Column(nullable = false, length = 60)
	private String cidade;
	
	@OneToMany(mappedBy = "hotel")
	private List<Promocao> promocoes;
    
   

	public Hotel(){

    }
	public Hotel(String cnpj, String nome,String cidade ,String email, String senha) {
		super(nome,email,"HOTEL",senha); 
        this.cnpj = cnpj;
        this.cidade = cidade;
        
	}

	


    public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
    }

    public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
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
		return "Hotel [Nome=" + nome + "Cidade=" + cidade + "Email=" + email + "]";
	}
*/
}