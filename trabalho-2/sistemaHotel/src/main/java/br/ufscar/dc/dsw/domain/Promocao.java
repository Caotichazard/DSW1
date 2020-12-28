package br.ufscar.dc.dsw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "Promocao")
public class Promocao {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
    
	@ManyToOne
	@JoinColumn(name = "hotel_id") 
	private Long hotel;
    
	@ManyToOne
	@JoinColumn(name = "siteReservas_id") 
	private Long url;

	@Column(nullable = false, length = 60)
	private String preco;
    
    @Column(nullable = false, length = 60)
	private String inicio;

	@Column(nullable = false, length = 60)
	private String fim;

	public Promocao(){

    }
	public Promocao(Long url, Long hotel,String preco ,String inicio, String fim) {
        this.url = url;
        this.hotel = hotel;
        this.preco = preco;
        this.inicio = inicio;
        this.fim = fim;
	}

	

	public Long getUrl() {
		return url;
	}
	public void setUrl(Long url) {
		this.url = url;
    }

    public Long getHotel() {
		return hotel;
	}
	public void setHotel(Long hotel) {
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