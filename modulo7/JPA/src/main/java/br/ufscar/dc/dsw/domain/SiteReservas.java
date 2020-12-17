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
@Table(name = "SiteReservas")
public class SiteReservas {
	
	@Id @Column(nullable = false, unique=true,length = 18)
	private String url;
	
	@Column(nullable = false, unique = true, length = 60)
    private String nome;
    
    @Column(nullable = false, length = 60)
    private String telefone;
    
    @Column(nullable = false, unique = true, length = 60)
    private String email;
    
    @Column(nullable = false, length = 60)
	private String senha;

	public SiteReservas(){//obrigatório default contructor
    	
    }
	public SiteReservas(String email, String senha, String url, String nome, String telefone){
        this.email = email;
        this.senha = senha;
        this.url = url;
        this.nome = nome;
        this.telefone = telefone;
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

    public void setUrl(String url){
        this.url = url;
    }

    public String getUrl(){
        return this.url;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public String getTelefone(){
        return this.telefone;
    }
    

	@Override
	public String toString() {
		return "Site de Reservas [Nome=" + nome + " Telefone=" + telefone + " url=" + url + "]";
	}
}