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
@Table(name = "Usuario")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true, length = 60)
    private String nome;
    
    @Column(nullable = false, length = 60)
    private String login;
    
    @Column(nullable = false, unique = true, length = 60)
    private String senha;
    
    @Column(nullable = false, length = 60)
	private String papel;

    
    
	public Usuario(){

    }
	
    
    public Usuario(String login, String nome,String papel, String senha) {
        
        this.nome = nome;
        this.login = login;
        this.papel = papel;
        this.senha = senha;
	}

	

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
    }

    public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
    }

    public String getPapel() {
		return papel;
	}
	public void setPapel(String papel) {
		this.papel = papel;
    }

    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
    }

    public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
    }
    

	@Override
	public String toString() {
		return "Usuario [Nome=" + nome + "Papel=" + papel + "Id=" + id + "]";
	}
}