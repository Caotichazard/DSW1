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
	private String login;

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
 
    void setId(Long id){
        this.id = id;
    }
    Long getId(){
        return this.id;
    }

    void setLogin(String login){
        this.login = login;
    }
    String getLogin(){
        return this.login;
    }

    void setSenha(String senha){
        this.senha = senha;
    }
    String getSenha(){
        return this.senha;
    }

    void setPapel(String papel){
        this.papel = papel;
    }
    String getPapel(){
        return this.papel;
    }

    @Override
	public String toString() {
		return "Usuario [Login= " + login + " Papel= " + papel +"]";
	}
}