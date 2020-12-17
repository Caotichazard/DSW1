package br.ufscar.dc.dsw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "Hotel")
public class Hotel {
	
	@Id @Column(nullable = false, unique=true,length = 18)
	private String cnpj;
	
	@Column(nullable = false, unique = true, length = 60)
    private String nome;
    
    @Column(nullable = false, length = 60)
    private String cidade;
    
    @Column(nullable = false, unique = true, length = 60)
    private String email;
    
    @Column(nullable = false, length = 60)
	private String senha;

	public Hotel(){

    }
	public Hotel(String cnpj, String nome,String cidade ,String email, String senha) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.cidade = cidade;
        this.email = email;
        this.senha = senha;
	}

	

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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

    public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
    }

    public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
    }
    

	@Override
	public String toString() {
		return "Hotel [Nome=" + nome + "Cidade=" + cidade + "Email=" + email + "]";
	}
}