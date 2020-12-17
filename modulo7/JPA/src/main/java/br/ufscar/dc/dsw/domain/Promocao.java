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
@Table(name = "Promocao")
public class Promocao {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 60)
    private String url;
    
    @Column(nullable = false, length = 60)
    private String hotel;
    
    @Column(nullable = false, length = 60)
    private String preco;
    
    @Column(nullable = false, length = 60)
	private String inicio;

	@Column(nullable = false, length = 60)
	private String fim;

	public Promocao(){

    }
	public Promocao(String url, String hotel,String preco ,String inicio, String fim) {
        this.url = url;
        this.hotel = hotel;
        this.preco = preco;
        this.inicio = inicio;
        this.fim = fim;
	}

	

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
    }

    public String getHotel() {
		return hotel;
	}
	public void setHotel(String hotel) {
		this.hotel = hotel;
    }

    public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
    }

    public String getInicio() {
		return inicio;
	}
	public void setInicio(String inicio) {
		this.inicio = inicio;
    }

    public String getFim() {
		return fim;
	}
	public void setFim(String fim) {
		this.fim = fim;
    }
    

	@Override
	public String toString() {
		return "Promocao [Site=" + url + " Hotel=" + hotel + " Preco=" + preco + " ]";
	}
}