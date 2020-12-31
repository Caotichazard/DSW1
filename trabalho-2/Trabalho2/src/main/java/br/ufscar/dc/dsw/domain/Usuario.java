package br.ufscar.dc.dsw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "Usuario")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

    @NotBlank(message = "{NotBlank.usuario.login}")
    @Size(min = 0, max = 60)
    @Column(nullable = false, unique = true, length = 60)
	private String login;

    @NotBlank(message = "{NotBlank.usuario.senha}")
    @Size(min = 0, max = 60)
    @Column(nullable = false, length = 60)
	private String senha;

    @Column(nullable = false, length = 60)
	private String papel;



    public Usuario(){

    }

    public Usuario(String login, String senha, String papel){
        this.login = login;
        this.senha = senha;
        this.papel = papel;
    }

    public Usuario(Long id,String login, String senha, String papel){
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.papel = papel;
    }
 
    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return this.id;
    }

    public void setLogin(String login){
        this.login = login;
    }
    public String getLogin(){
        return this.login;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }
    public String getSenha(){
        return this.senha;
    }

    public void setPapel(String papel){
        this.papel = papel;
    }
    public String getPapel(){
        return this.papel;
    }

    @Override
	public String toString() {
		return "Usuario [Login= " + login + " Papel= " + papel +"]";
	}
}